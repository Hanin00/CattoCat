package com.example.cattocat.src.addcat.map

import android.Manifest
import android.content.ContentValues
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import com.example.cattocat.databinding.ActivityMakeMarkerBinding
import com.example.cattocat.src.addcat.AddCatView
import com.example.cattocat.src.addcat.model.AddCatInfo
import com.example.cattocat.src.main.map.MapActivity
import com.naver.maps.geometry.LatLng
import com.naver.maps.map.*
import com.naver.maps.map.util.FusedLocationSource
import com.naver.maps.map.widget.LocationButtonView

class MakeMarkerActivity : AppCompatActivity(),OnMapReadyCallback {

    private lateinit var binding: ActivityMakeMarkerBinding
    private lateinit var mapView: MapView
    private lateinit var naverMap: NaverMap
    private var getLatitude: Double = 37.5548732
    private var getLongitude: Double = 127.0246126
    private lateinit var locationSource: FusedLocationSource //사용자 현재 위치


    private val xlocation = ""
    private val ylocation = ""
    private val locatefrommap = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMakeMarkerBinding.inflate(layoutInflater)
        setContentView(binding.root)
        mapView = binding.makemarkerMap
        mapView.onCreate(savedInstanceState)

        binding.makemarkerMap.getMapAsync(this)
        locationSource = FusedLocationSource(this, LOCATION_PERMISSION_REQUEST_CODE)

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
            val cameraUpdate = CameraUpdate.scrollTo(LatLng(getLatitude,getLongitude))
            naverMap.moveCamera(cameraUpdate)

            //지도 위 사용자 위치 표시 객체
        //    val locationButton: LocationButtonView = binding.makemarkerBtnLocation
         //   locationButton.map = naverMap
        }
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


    //현재위치 표시를 위한 권한
    private val PERMISSION: Array<String> = arrayOf(
        Manifest.permission.ACCESS_COARSE_LOCATION,
        Manifest.permission.ACCESS_FINE_LOCATION
    )

    //위치 권한
    companion object {
        private const val LOCATION_PERMISSION_REQUEST_CODE = 1000
    }

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
                Log.d(ContentValues.TAG, "MainActivity - onRequestPermissionsResult 권한 거부됨")
                naverMap.locationTrackingMode = LocationTrackingMode.None
            } else {
                Log.d(ContentValues.TAG, "MainActivity - onRequestPermissionsResult 권한 승인됨")
                naverMap.locationTrackingMode = LocationTrackingMode.Follow // 현위치 버튼 컨트롤 활성
            }
            return
        }

        /*       if (requestCode == LOCATION_PERMISSION_REQUEST_CODE) {
                   if (grantResults[0] == PackageManager.PERMISSION_GRANTED &&
                       grantResults[1] == PackageManager.PERMISSION_GRANTED
                   ) {
                       naverMap.locationTrackingMode = LocationTrackingMode.Follow
                   }
               }*/


        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }
}