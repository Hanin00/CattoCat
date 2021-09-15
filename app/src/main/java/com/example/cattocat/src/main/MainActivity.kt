package com.example.cattocat.src.main

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.cattocat.R
import com.example.cattocat.databinding.ActivityMainBinding
import com.example.cattocat.src.main.board.BoardActivity
import com.example.cattocat.src.main.home.HomeFragment
import com.example.cattocat.src.main.map.MapActivity
import com.example.cattocat.src.main.mycat.MyCatActivity
import com.example.cattocat.src.main.setting.SettingFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

//bottom Nav
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager.beginTransaction().replace(R.id.main_frm, HomeFragment())
            .commitAllowingStateLoss()

        binding.mainBottomNav.setOnNavigationItemSelectedListener(
            BottomNavigationView.OnNavigationItemSelectedListener { item ->
                when (item.itemId) {
                    R.id.menu_main_btm_nav_home -> {
                        replaceFragment(HomeFragment())
                        return@OnNavigationItemSelectedListener true
                    }

                    R.id.menu_main_btm_nav_board -> {
                        // loginCheck(BoardActivity())
                        val intent = Intent(this, BoardActivity::class.java)
                        startActivity(intent)
                        return@OnNavigationItemSelectedListener true
                    }
                    R.id.menu_main_btm_nav_mycat -> {
                        val intent = Intent(this, MyCatActivity::class.java)
                        startActivity(intent)
                    }
                    R.id.menu_main_btm_nav_map -> {
                        val intent = Intent(this, MapActivity::class.java)
                        startActivity(intent)

                        //   replaceFragment(MapActivity())
                        //  return@OnNavigationItemSelectedListener true
                    }
                    R.id.menu_main_btm_nav_setting -> {
                        replaceFragment(SettingFragment())
                        return@OnNavigationItemSelectedListener true
                    }
                }
                false
            }
        )
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(R.id.main_frm, fragment)
            .commitAllowingStateLoss()

    }

}