package com.example.cattocat.src.main.setting

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.cattocat.R
import com.example.cattocat.databinding.FragmentSettingBinding
import com.example.cattocat.src.main.setting.myreply.MyPostActivity
import com.example.cattocat.src.main.setting.myreply.MyReplyActivity
import com.example.cattocat.src.main.setting.notice.NoticeActivity


//설정
class SettingFragment : Fragment() {
    private lateinit var binding: FragmentSettingBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSettingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //   val versionCode: Int = BuildConfig.VERSION_CODE
        initClick()
    }

    private fun initClick() {
        //내가 쓴 글
        binding.settingIvMenu1.setOnClickListener {
            val intent = Intent(context, MyPostActivity::class.java)
            startActivity(intent)
        }

        //내가 좋아한 글
        binding.settingIvMenu2.setOnClickListener {
            val intent = Intent(context, MyPostActivity::class.java)
            startActivity(intent)
        }

        //내가 단 댓글
        binding.settingIvMenu3.setOnClickListener {
            val intent = Intent(context, MyReplyActivity::class.java)
            startActivity(intent)
        }





       //공지사항
        binding.settingTvMenu01.setOnClickListener {
            Log.d("Test", "Clicked ")
            val intent = Intent(requireContext(), NoticeActivity::class.java)
            startActivity(intent)
        }
        //문의하기 - Mail 보내기
        binding.settingTvMenu02.setOnClickListener {
            Log.d("Test", "Clicked ")
            val addr = arrayOf("cattocat@gmail.com")
            val shareIntent = Intent(Intent.ACTION_SEND)
            shareIntent.type = "text/plain"
            shareIntent.putExtra(Intent.EXTRA_EMAIL, addr)
            shareIntent.putExtra(Intent.EXTRA_TEXT, getString(R.string.setting_email_report))
            // startActivity(Intent.createChooser(shareIntent, "공유"))
            startActivity(shareIntent)
        }
        //사용안내
        binding.settingTvMenu04.setOnClickListener {
            val intent = Intent(requireContext(), NoticeActivity::class.java)
            Log.d("Test", "Clicked ")
            startActivity(intent)
        }
        //회원설정
        binding.settingTvMenu05.setOnClickListener {
            Log.d("Test", "Clicked ")
            val intent = Intent(requireContext(), NoticeActivity::class.java)
            startActivity(intent)
        }
        //사용자정보 변경
        binding.settingBtnInfoModify.setOnClickListener {
            Log.d("Test", "Clicked ")
            val intent = Intent(requireContext(), NoticeActivity::class.java)
            startActivity(intent)
        }

        //팝업설정 토글

        //로그아웃
        binding.settingInfoLogout.setOnClickListener {
            Log.d("Test", "Clicked ")
            Log.d("Test", "SettingFragment - Clicked Logout")
        }
    }


    //todo login 상태 판별 후 true인 경우 user info binding


}