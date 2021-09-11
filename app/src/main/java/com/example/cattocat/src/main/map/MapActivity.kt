package com.example.cattocat.src.main.map

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.cattocat.databinding.ActivityMapBinding
import com.naver.maps.geometry.LatLng
import com.naver.maps.map.*


//map
class MapActivity : AppCompatActivity(), OnMapReadyCallback {
    private lateinit var binding: ActivityMapBinding
    private lateinit var mapView: MapView
    private lateinit var naverMap: NaverMap
    private var getLongitude: Double = 127.0246126
    private var getLatitude: Double = 37.5548732


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMapBinding.inflate(layoutInflater)
        setContentView(binding.root)
        mapView = binding.mapNavermap
        mapView.onCreate(savedInstanceState)

        binding.mapNavermap.getMapAsync(this)

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

    override fun onMapReady(naverMap: NaverMap) {
        this.naverMap = naverMap
        val cameraPosition = CameraPosition(
            LatLng(33.38, 126.55),  // 위치 지정
            9.0 // 줌 레벨
        )
        naverMap.cameraPosition = cameraPosition
    }
}