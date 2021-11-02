package com.example.cattocat.src.main.map

import android.Manifest
import android.content.ContentValues.TAG
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.view.isInvisible
import androidx.viewpager2.widget.ViewPager2
import com.example.cattocat.Companion
import com.example.cattocat.Companion.Companion.ISSTAFF
import com.example.cattocat.Companion.Companion.LOCATION_PERMISSION_REQUEST_CODE
import com.example.cattocat.Companion.Companion.USERID
import com.example.cattocat.databinding.ActivityMapBinding
import com.example.cattocat.src.main.map.adapter.MapVPAdapter
import com.example.cattocat.src.main.map.catmarker.CatMarkerService
import com.example.cattocat.src.main.map.catmarker.CatMarkerView
import com.example.cattocat.src.main.map.catmarker.model.CatMarkerItem
import com.example.cattocat.src.main.map.catmarker.model.CatMyResponse
import com.example.cattocat.src.main.mycat.MyCatActivity
import com.example.cattocat.src.main.mycat.MyCatService
import com.example.cattocat.src.main.mycat.MyCatView
import com.example.cattocat.src.main.mycat.model.MyCatItem
import com.example.cattocat.src.main.mycat.model.MyCatResponse
import com.example.cattocat.src.main.mycat.mycatinfo.MyCatInfoFragment
import com.naver.maps.geometry.LatLng
import com.naver.maps.map.*
import com.naver.maps.map.overlay.Marker
import com.naver.maps.map.overlay.Overlay
import com.naver.maps.map.overlay.OverlayImage
import com.naver.maps.map.util.FusedLocationSource
import com.naver.maps.map.widget.LocationButtonView


//map
class MapActivity : AppCompatActivity(), OnMapReadyCallback, CatMarkerView,
    Overlay.OnClickListener {
    private lateinit var binding: ActivityMapBinding
    private lateinit var mapView: MapView
    private lateinit var naverMap: NaverMap
    private var getLatitude: Double = 37.5548732
    private var getLongitude: Double = 127.0246126
    private lateinit var locationSource: FusedLocationSource //사용자 현재 위치
    private var markers = mutableListOf<Marker>()
    private lateinit var catTotalInfo: java.util.ArrayList<CatMarkerItem>




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMapBinding.inflate(layoutInflater)
        setContentView(binding.root)
        mapView = binding.mapNavermap
        mapView.onCreate(savedInstanceState)

        binding.mapNavermap.getMapAsync(this)
        locationSource = FusedLocationSource(this, LOCATION_PERMISSION_REQUEST_CODE)


        if(ISSTAFF == 1){
            //staff 인 경우 all Btn 접근 가능.
            binding.mapBtnAll.isInvisible =false
            binding.mapBtnAll.setOnClickListener {
                CatMarkerService(this,USERID).tryTotalCat()
            }
            binding.mapBtnMy.setOnClickListener {
                CatMarkerService(this,USERID).tryMyCat()
            }

        }else{


            binding.mapBtnAll.isInvisible = true
            binding.mapBtnMy.setOnClickListener {
                CatMarkerService(this,USERID).tryMyCat()
            }

        }
    }

    override fun onMapReady(map: NaverMap) {
        naverMap = map
        naverMap.let {
            it.locationSource = locationSource
            ActivityCompat.requestPermissions(this, PERMISSION, LOCATION_PERMISSION_REQUEST_CODE)
            val uiSettings = it.uiSettings
            uiSettings.isLocationButtonEnabled = true
            uiSettings.isCompassEnabled = false
            uiSettings.isScaleBarEnabled = false

            val cameraPosition = CameraPosition(
                LatLng(getLatitude, getLongitude),  // 위치 지정
                9.0 // 줌 레벨
            )

            //화면에서 표시하는 지도(카메라) 위치 조정
            val cameraUpdate = CameraUpdate.scrollTo(LatLng(getLatitude, getLongitude))
            naverMap.moveCamera(cameraUpdate)

            //지도 위 사용자 위치 표시 객체
            val locationButton: LocationButtonView = binding.mapBtnLocation
            locationButton.map = naverMap
        }
    }

    //현재위치 표시를 위한 권한
    private val PERMISSION: Array<String> = arrayOf(
        Manifest.permission.ACCESS_COARSE_LOCATION,
        Manifest.permission.ACCESS_FINE_LOCATION
    )

    //위치 권한
//    companion object {
//        private const val LOCATION_PERMISSION_REQUEST_CODE = 1000
//    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        if (locationSource.onRequestPermissionsResult(
                requestCode, permissions,
                grantResults
            )
        ) {
            if (!locationSource.isActivated) { // 권한 거부됨
                Log.d(TAG, "MainActivity - onRequestPermissionsResult 권한 거부됨")
                naverMap.locationTrackingMode = LocationTrackingMode.None
            } else {
                Log.d(TAG, "MainActivity - onRequestPermissionsResult 권한 승인됨")
                naverMap.locationTrackingMode = LocationTrackingMode.Follow // 현위치 버튼 컨트롤 활성
            }
            return
        }

        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }

    override fun onGetTotalCatSuccess(result: ArrayList<CatMarkerItem>) {
        Log.d("Test", "정상연결")
        Log.d("Test", "${result}")
        if (result != null) {
            catTotalInfo = result as ArrayList<CatMarkerItem>

            if (catTotalInfo.size > 0) {
                //     viewPager.visibility = View.VISIBLE

                clearMarkers()
                setRefreshMap(result)
                moveCamera()
                binding.mapNavermap.getMapAsync(this)

            }
        }
    }

    override fun onGetTotalFailure(message: String) {
        Log.e("Test", "onGetTotalFailure: $message")
    }

    override fun onGetMyCatSuccess(result: CatMyResponse) {
        Log.d("Test", "정상연결")
        Log.d("Test", "${result}")

        clearMarkers()
        if (result != null) {
            catTotalInfo = result.content as ArrayList<CatMarkerItem>
            //todo viewpager 연결

            if (catTotalInfo.size > 0) {
                //     viewPager.visibility = View.VISIBLE
                clearMarkers()
                setRefreshMap(catTotalInfo)
                moveCamera()
                binding.mapNavermap.getMapAsync(this)

            }
        }
    }

    override fun onGetMyFailure(message: String) {
        Log.e("Test", "onGetMyFailure: $message")
    }


    private fun clearMarkers() {
        for (i in 0..markers.size - 1) {
            markers[i].map = null
        }
        markers.clear()
    }

    private fun noResponse() {
        clearMarkers()
        moveCamera()
    }

    //맵 갱신
    private fun setRefreshMap(response: java.util.ArrayList<CatMarkerItem>) {

        clearMarkers()
        setNaverMarker()
        moveCamera()
    }

    //마커 생성
    private fun setNaverMarker() {
        if (catTotalInfo != null) {
            for (i in 0 until catTotalInfo.size) {
                markers += Marker().apply {
                    position = LatLng(
                        catTotalInfo[i].cat_ylocation.toString().toDouble(),
                        catTotalInfo[i].cat_xlocation.toString().toDouble()
                    )
                    icon = OverlayImage.fromResource(R.drawable.navermap_default_marker_icon_yellow)
                    map = naverMap
                    width = Marker.SIZE_AUTO
                    height = Marker.SIZE_AUTO
                    captionText = catTotalInfo[i].cat_name.toString()

                    captionMinZoom = 2.0 //최소 줌
                    captionMaxZoom = 16.0//최대 줌
                    tag = catTotalInfo[i].cat_id
                    onClickListener = this@MapActivity
                }
            }
        }
        //todo viewpager

    }

    private fun moveCamera() {
        val cameraUpdate =
            CameraUpdate.scrollTo(
                LatLng(
                    getLatitude,
                    getLongitude
                )
            ).animate(CameraAnimation.Fly)
        naverMap.moveCamera(cameraUpdate)
    }

    //고양이 정보 아이템 클릭 리스너 - 뷰페이저
    private fun onCatClick(mapItem: CatMarkerItem) {
        val intent = Intent(this, MyCatInfoFragment::class.java)
        startActivity(intent)
        finish()
        Toast.makeText(this, "고양이 이름 : ${mapItem.cat_name}", Toast.LENGTH_SHORT).show()
    }



    //todo viewpager 와 연동 필요
    override fun onClick(overlay: Overlay): Boolean {

        return true
    }


    override fun onStart() {
        super.onStart()
        mapView.onStart()
    }

    override fun onResume() {
        super.onResume()
        mapView.onResume()
    }

    override fun onPause() {
        super.onPause()
        mapView.onPause()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        mapView.onSaveInstanceState(outState)
    }

    override fun onStop() {
        super.onStop()
        mapView.onStop()
    }

    override fun onDestroy() {
        super.onDestroy()
        mapView.onDestroy()
    }

    override fun onLowMemory() {
        super.onLowMemory()
        mapView.onLowMemory()
    }



}