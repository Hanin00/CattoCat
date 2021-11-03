package com.example.cattocat.src.main.setting

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import androidx.fragment.app.Fragment
import com.example.cattocat.Companion.Companion.USERCITY
import com.example.cattocat.Companion.Companion.USERID
import com.example.cattocat.Companion.Companion.USERIMAGE
import com.example.cattocat.Companion.Companion.USERNAME
import com.example.cattocat.R
import com.example.cattocat.databinding.FragmentSettingBinding
import com.example.cattocat.src.auth.SignInActivity
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


        if(USERID != 0){
            initClick()
        }else{
            binding.settingTvUserName.setText("로그인이 필요합니다.")
            binding.settingTvUserLocate.setText("")
         //   binding.settingIvUserImg.setImageResource(USERIMAGE)
           binding.settingIvUserImg.setImageResource(R.drawable.dummy_cat_01)
            LoginBtn()

        }
    }

    private fun LoginBtn(){
        binding.settingBtnInfoModify.setOnClickListener {
            val mDialogView =
                LayoutInflater.from(context).inflate(R.layout.dialog_login, null)
            val mBuilder = AlertDialog.Builder(context)
                .setView(mDialogView)
            //  .setTitle("Login Form")

            val mAlertDialog = mBuilder.show()

            val loginButton = mDialogView.findViewById<TextView>(R.id.dialog_login_login)
            val calcelButton = mDialogView.findViewById<TextView>(R.id.dialog_login_cancle)
            loginButton.setOnClickListener {
                mAlertDialog.dismiss()
                val intent = Intent(context, SignInActivity::class.java)
                startActivity(intent)
                // Fragment 클래스에서 사용 시
            }
            calcelButton.setOnClickListener {
                mAlertDialog.dismiss()
                // Fragment 클래스에서 사용 시

            }
        }
    }


    private fun initClick() {
        binding.settingTvUserName.setText(USERNAME)
        binding.settingTvUserLocate.setText(USERCITY)
        binding.settingIvUserImg.setImageResource(USERIMAGE)


        //내가 쓴 글
        binding.settingIvMenu1.setOnClickListener {
            val intent = Intent(context, MyPostActivity::class.java)
            startActivity(intent)
        }

        //내가 좋아한 글
        binding.settingIvMenu2.setOnClickListener {
         //   val intent = Intent(context, MyPostActivity::class.java)
          //  startActivity(intent)
        }

        //내가 단 댓글
        binding.settingIvMenu3.setOnClickListener {
        //    val intent = Intent(context, MyReplyActivity::class.java)
          //  startActivity(intent)
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
            intent.putExtra("isUse",true)
            startActivity(intent)
        }
        //회원설정
        binding.settingTvMenu05.setOnClickListener {
            Log.d("Test", "Clicked ")
            val intent = Intent(requireContext(), NoticeActivity::class.java)
            intent.putExtra("isUser",true)
            startActivity(intent)
        }
        //사용자정보 변경
        binding.settingBtnInfoModify.setOnClickListener {
            Log.d("Test", "Clicked ")
            val intent = Intent(requireContext(), NoticeActivity::class.java)
            intent.putExtra("isUserInfo",true)
            startActivity(intent)
        }

        //팝업설정 토글

        //로그아웃
        binding.settingInfoLogout.setOnClickListener {
            Log.d("Test", "Clicked ")
            Log.d("Test", "SettingFragment - Clicked Logout")
        }
    }
}