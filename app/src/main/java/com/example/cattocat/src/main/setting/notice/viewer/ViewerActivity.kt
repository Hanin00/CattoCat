package com.example.cattocat.src.main.setting.notice.viewer

import android.os.Bundle
import android.util.Log
import android.webkit.WebViewClient
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isInvisible
import com.example.cattocat.databinding.ActivityViewerBinding
import com.example.cattocat.src.main.setting.notice.viewer.info.InfoSingleService
import com.example.cattocat.src.main.setting.notice.viewer.info.InfoSingleView
import com.example.cattocat.src.main.setting.notice.viewer.info.model.InfoSingleResponse
import com.example.cattocat.src.main.setting.notice.viewer.notice.NoticeSingleService
import com.example.cattocat.src.main.setting.notice.viewer.notice.NoticeSingleView
import com.example.cattocat.src.main.setting.notice.viewer.notice.model.NoticeSingleItem
import com.example.cattocat.src.main.setting.notice.viewer.notice.model.NoticeSingleResponse
import com.example.cattocat.util.Constants.FROM_INFO
import com.example.cattocat.util.Constants.FROM_NOTICE
import com.example.cattocat.util.Constants.TEXT_ID


class ViewerActivity : AppCompatActivity(), NoticeSingleView, InfoSingleView {
    private lateinit var binding: ActivityViewerBinding
    private var noticeIdx: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityViewerBinding.inflate(layoutInflater)
        setContentView(binding.root)


        if (intent.hasExtra(TEXT_ID)) {
            val isNotice = intent.getBooleanExtra(FROM_NOTICE, false)
            val isInfo = intent.getBooleanExtra(FROM_INFO, false)
            val idx = intent.getIntExtra(TEXT_ID, 0)

            if (isNotice == true) {
                binding.viewerTvTitle.setText("공지사항")

                NoticeSingleService(this, idx).tryGetNoticeSingle()


            } else if (isInfo == true) {
                binding.viewerTvTitle.setText("소식")

                InfoSingleService(this, idx).tryGetNoticeSingle()

            } else {
                val editorTitle = intent.getStringExtra("editorTitle").toString()
                binding.viewerTvTitle.setText(editorTitle)
            }
        }

    }

    override fun onGetNoticeSingleSuccess(result: NoticeSingleResponse) {
        Toast.makeText(this, "정상연결.", Toast.LENGTH_SHORT).show()
        Log.d("Test", "정상연결")
        Log.d("Test", "${result}")

        val noticelist = result.content
        binding.viewerTvTitle.setText(noticelist[0].title)
        //todo glide 연결 binding.viewerIvImg.setText(noticelist[0].banner_image)

        val content = noticelist[0].content
        //html 연결
        if (content.length > 10) {
            /* binding.viewerWb.loadData( html,"text/html","UTF-8")
             binding.viewerWb.loadDataWithBaseURL(null, html,"text/html","UTF-8",null)
 */
            binding.viewerWb.isInvisible = true
            binding.viewerText.setText(content)


        }

    }

    override fun onGetNoticeSingleFailure(message: String) {
        Log.e("Test", "onGetNoticeSingleFailure: $message")
    }

    override fun onGetInfoSingleSuccess(result: InfoSingleResponse) {
        Toast.makeText(this, "정상연결.", Toast.LENGTH_SHORT).show()
        Log.d("Test", "정상연결")
        Log.d("Test", "${result}")

        val infolist = result.content
        binding.viewerTvTitle.setText(infolist[0].title)
        //todo glide 연결 binding.viewerIvImg.setText(noticelist[0].banner_image)

        val html = infolist[0].content
        //html 연결
        if (html.length > 10) {
/*
            binding.viewerWb.loadData( html,"text/html","UTF-8")
            binding.viewerWb.loadDataWithBaseURL(null, html,"text/html","UTF-8",null)
*/          binding.viewerText.isInvisible = false
            binding.viewerWb.webViewClient = WebViewClient()
            binding.viewerWb.loadUrl(html)
        }
    }

    override fun onGetInfoSingleFailure(message: String) {
        Log.e("Test", "onGetInfoSingleFailure: $message")
    }


}