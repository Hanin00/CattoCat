package com.example.cattocat.src.main.map

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import com.example.cattocat.R
import com.example.cattocat.databinding.ActivityMapBinding
import com.example.cattocat.src.main.map.model.NaverMapResult
import com.naver.maps.geometry.LatLng
import com.naver.maps.map.*
import com.naver.maps.map.NaverMapSdk.NaverCloudPlatformClient
import com.naver.maps.map.util.FusedLocationSource
import com.naver.maps.map.widget.LocationButtonView
import retrofit2.converter.gson.GsonConverterFactory


//map
class MapActivity : AppCompatActivity(), OnMapReadyCallback,NaverMapView {
    private lateinit var binding : ActivityMapBinding
    private lateinit var mapView:MapView
    private lateinit var naverMap : NaverMap
    private var getLongitude: Double = 127.0246126
    private var getLatitude: Double = 37.5548732
    private lateinit var locationSource: FusedLocationSource
    //todo FuserLocationSource 왜?


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMapBinding.inflate(layoutInflater)
        setContentView(binding.root)


       locationSource = FusedLocationSource(this, PERMISSION_REQUEST_CODE)

        mapView = binding.mapNavermap
        //MapView - onCreate 연결
        mapView.onCreate(savedInstanceState)

        //맵가져오기
        mapView.getMapAsync(this)
        NaverMapSdk.getInstance(this).client = NaverCloudPlatformClient(R.string.naver_maps_client_id.toString())

        val selectLocation ="서울 강서구"
        NaverMapService(this).getAddress(selectLocation)

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


    private val PERMISSION: Array<String> = arrayOf(
        Manifest.permission.ACCESS_COARSE_LOCATION,
        Manifest.permission.ACCESS_FINE_LOCATION
    )
    //위치 권한
    private val PERMISSION_REQUEST_CODE = 1000
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        if (requestCode == PERMISSION_REQUEST_CODE) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED &&
                grantResults[1] == PackageManager.PERMISSION_GRANTED
            ) {
                naverMap.locationTrackingMode = LocationTrackingMode.Follow
            }
        }
    }

    //맵가져오기
    override fun onMapReady(map: NaverMap) {
        naverMap = map
        naverMap.let {
            it.locationSource = locationSource
            ActivityCompat.requestPermissions(this, PERMISSION, PERMISSION_REQUEST_CODE)
            val uiSettings = it.uiSettings
            uiSettings.isLocationButtonEnabled = true
            uiSettings.isCompassEnabled = false
            uiSettings.isScaleBarEnabled = false
            val locationButton: LocationButtonView = findViewById(R.id.map_btn_location)
            locationButton.map = naverMap
            val cameraUpdate = CameraUpdate.scrollTo(LatLng(getLatitude, getLongitude))
            naverMap.moveCamera(cameraUpdate)
        }}

    //NaverGeoCoding 성공
    override fun onGetNaverMapSuccess(result: ArrayList<NaverMapResult>) {
        //    getLatitude = result[0].y.toDouble()
        //getLongitude = result[0].x.toDouble()

        if (result.size != null) {
            getLatitude = result[0].y.toDouble()
            getLongitude = result[0].x.toDouble()
        } else {
      //      getLatitude = mapItemList[0].hospitalLatitude.toDouble()
       //     getLongitude = mapItemList[0].hospitalLongitude.toDouble()
        }

        //지도 위치 이동
        val cameraUpdate = CameraUpdate.scrollTo(LatLng(getLatitude, getLongitude))
            .animate(CameraAnimation.Fly, 3000)
        naverMap.moveCamera(cameraUpdate)

    }

    //NaverGeoCoding 실패
    override fun onGetNaverMapFailed(message : Int) {
        Log.d("Test", "MapActivity - ${message}")
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
}