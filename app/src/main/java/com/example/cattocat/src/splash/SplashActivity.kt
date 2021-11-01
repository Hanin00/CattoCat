package com.example.cattocat.src.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.example.cattocat.databinding.ActivityMainBinding
import com.example.cattocat.databinding.ActivitySplashBinding
import com.example.cattocat.src.main.MainActivity
import javax.xml.datatype.DatatypeConstants.DURATION

class SplashActivity : AppCompatActivity() {
    private lateinit var binding : ActivitySplashBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.lottieAnimation.playAnimation() // 애니메이션 적용
        val DURATION : Long = 3000
        Handler().postDelayed({
            val intent = Intent(this, MainActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
            startActivity(intent)
            finish()
        },DURATION)




    }
}