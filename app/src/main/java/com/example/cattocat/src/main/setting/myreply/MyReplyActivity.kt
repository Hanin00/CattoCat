package com.example.cattocat.src.main.setting.myreply


import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cattocat.Companion.Companion.USERID
import com.example.cattocat.databinding.ActivitySettingsIconBinding
import com.example.cattocat.src.main.setting.myreply.adapter.MyReplyRecyAdapter
import com.example.cattocat.src.main.setting.myreply.model.MyReplyItem
import com.example.cattocat.src.main.setting.myreply.model.MyReplyResponse

class MyReplyActivity : AppCompatActivity(), MyReplyView {
    private lateinit var binding: ActivitySettingsIconBinding
    private var replyItem = ArrayList<MyReplyItem>()
    private lateinit var replyAdapter: MyReplyRecyAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySettingsIconBinding.inflate(layoutInflater)
        setContentView(binding.root)

        MyReplyService(this, USERID).tryGetPostSingle()


    }

    private fun myReplyRecyAdapter(replyItem: ArrayList<MyReplyItem>) {
        replyAdapter = MyReplyRecyAdapter(replyItem, this){ replyItem->

        }
        binding.settingsRecyList.apply {
            adapter = replyAdapter
            layoutManager = LinearLayoutManager(
                context,
                LinearLayoutManager.VERTICAL, false
            )
            replyAdapter.notifyDataSetChanged()
        }
    }


    override fun onGetMyReplySuccess(result: MyReplyResponse) {
        Toast.makeText(this, "정상연결.", Toast.LENGTH_SHORT).show()
        Log.d("Test", "댓글 입력됨")

        if (result.content.size >= 1) {
            Log.d("test", "replylist.size >=1")
            val replylist = result.content
            myReplyRecyAdapter(replyItem)
        }


    }

    override fun onGetMyReplyFailure(message: String) {
        Log.e("Test", "onGetMyReplyFailure: $message")
    }
}