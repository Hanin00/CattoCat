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
    private lateinit var locationSource: FusedLocationSource //????????? ?????? ??????
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
            //staff ??? ?????? all Btn ?????? ??????.
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
                LatLng(getLatitude, getLongitude),  // ?????? ??????
                9.0 // ??? ??????
            )

            //???????????? ???????????? ??????(?????????) ?????? ??????
            val cameraUpdate = CameraUpdate.scrollTo(LatLng(getLatitude, getLongitude))
            naverMap.moveCamera(cameraUpdate)

            //?????? ??? ????????? ?????? ?????? ??????
            val locationButton: LocationButtonView = binding.mapBtnLocation
            locationButton.map = naverMap
        }
    }

    //???????????? ????????? ?????? ??????
    private val PERMISSION: Array<String> = arrayOf(
        Manifest.permission.ACCESS_COARSE_LOCATION,
        Manifest.permission.ACCESS_FINE_LOCATION
    )

    //?????? ??????
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
            if (!locationSource.isActivated) { // ?????? ?????????
                Log.d(TAG, "MainActivity - onRequestPermissionsResult ?????? ?????????")
                naverMap.locationTrackingMode = LocationTrackingMode.None
            } else {
                Log.d(TAG, "MainActivity - onRequestPermissionsResult ?????? ?????????")
                naverMap.locationTrackingMode = LocationTrackingMode.Follow // ????????? ?????? ????????? ??????
            }
            return
        }

        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }

    override fun onGetTotalCatSuccess(result: ArrayList<CatMarkerItem>) {
        Log.d("Test", "????????????")
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
        Log.d("Test", "????????????")
        Log.d("Test", "${result}")

        clearMarkers()
        if (result != null) {
            catTotalInfo = result.content as ArrayList<CatMarkerItem>
            //todo viewpager ??????

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

    //??? ??????
    private fun setRefreshMap(response: java.util.ArrayList<CatMarkerItem>) {

        clearMarkers()
        setNaverMarker()
        moveCamera()
    }

    //?????? ??????
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

                    captionMinZoom = 2.0 //?????? ???
                    captionMaxZoom = 16.0//?????? ???
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

    //????????? ?????? ????????? ?????? ????????? - ????????????
    private fun onCatClick(mapItem: CatMarkerItem) {
        val intent = Intent(this, MyCatInfoFragment::class.java)
        startActivity(intent)
        finish()
        Toast.makeText(this, "????????? ?????? : ${mapItem.cat_name}", Toast.LENGTH_SHORT).show()
    }



    //todo viewpager ??? ?????? ??????
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