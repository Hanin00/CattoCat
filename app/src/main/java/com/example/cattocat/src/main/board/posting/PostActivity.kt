package com.example.cattocat.src.main.board.posting

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cattocat.R
import com.example.cattocat.databinding.ActivityPostBinding
import com.example.cattocat.src.main.board.model.ReplyItem
import com.example.cattocat.src.main.board.posting.adapter.ReplyRecyAdapter
import com.example.cattocat.src.main.board.posting.model.PostInfoItem
import com.example.cattocat.src.main.board.posting.model.PostResponse
import com.example.cattocat.src.main.board.posting.model.ReplyListItem
import com.example.cattocat.src.main.board.posting.model.UserInfoItem
import okhttp3.internal.notify
import okhttp3.internal.notifyAll
import retrofit2.adapter.rxjava2.Result.response


class PostActivity : AppCompatActivity(), PostView {
    private lateinit var binding: ActivityPostBinding
    private var replyItem = ArrayList<ReplyItem>()
    private lateinit var replyAdapter: ReplyRecyAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPostBinding.inflate(layoutInflater)
        setContentView(binding.root)


        if (intent.hasExtra("isUserIdx")) {
            val isPostIdx = intent.getIntExtra("isPostIdx", 0)
            val isUserIdx = intent.getIntExtra("isUserIdx", 0)
            Log.d("Test", "if 안 PostActivity - isUserIdx from home - ${isUserIdx}")
            Log.d("Test", "if 안 PostActivity - isPostIdx from home - ${isPostIdx}")

            PostService(this, isPostIdx, isUserIdx).tryGetPostSingle(isPostIdx, isUserIdx)

            binding.postBtnReply.setOnClickListener {
                val content = binding.postEdReply.text.toString()
                //todo User_id - 로그인 되어있는

                if(content != ""){
                    PostService(this, isPostIdx, isUserIdx).tryPostReply(
                        ReplyListItem(
                            null,
                            isUserIdx.toInt(),
                            isPostIdx.toInt(),
                            content,
                            null
                        )
                    )
                    softkeyboardHide()
                    binding.postEdReply.setText("")

                    PostService(this, isPostIdx, isUserIdx).tryGetPostSingle(isPostIdx, isUserIdx)
                }else{
                    Toast.makeText(this, "댓글을 입력해주세요.",Toast.LENGTH_SHORT).show()
                }

            }

        }
    }
    override fun onBackPressed() {
        // 뒤로가기 버튼 클릭
        finish()
    }

    private fun ReplyRecyAdapter(replyItem: ArrayList<ReplyListItem>) {
        replyAdapter = ReplyRecyAdapter(replyItem, this)
        binding.postRecyReply.apply {
            adapter = replyAdapter
            layoutManager = LinearLayoutManager(
                context,
                LinearLayoutManager.VERTICAL, false
            )
            replyAdapter.notifyDataSetChanged()
        }
    }

    override fun onGetPostInfoSuccess(result: PostResponse) {
        Log.d("Test", "정상연결")
        Log.d("Test", "${result}")


        if (result.replylist.size >= 1) {
            Log.d("test", "replylist.size >=1")
            val replyItem = result.replylist as ArrayList<ReplyListItem>
            ReplyRecyAdapter(replyItem)
            binding.postTvReply.setText(result.replylist.size.toString())
        }

        if (result.userinfo.size >= 1) {
            Log.d("test", "userinfo.size >=1")

            val userInfoItem = result.userinfo as ArrayList<UserInfoItem>
            //user
          //  userInfoItem[0].uname?.let { binding.postTvUser.setText(it) }



            /*    userInfoItem.uname?.let { binding.postTvUser.setText(it) }
                userInfoItem.city?.let { binding.postTvUserLocate.setText(it) }*/

            //binding.postIvUser.Glider esult.userinfo.city)

        }

        if (result.post.size >= 1) {
            Log.d("test", "post.size >=1")
            //post
            val postInfoItem = result.post as ArrayList<PostInfoItem>
            val created_at = postInfoItem[0].created_at
            binding.postTvDate.setText(created_at?.substring(0, 10))

            //todo glide 연결
            // binding.postIvDummy.glide
            binding.postTvTitle.setText(postInfoItem[0].title)
            binding.postTvContent.setText(postInfoItem[0].content)

            if(postInfoItem[0].image.toString().toInt() ==1){
                binding.postIvDummy.setImageResource(R.drawable.dummy_cat_14)
                binding.postIvUser.setImageResource(R.drawable.dummy_cat_04)
                binding.postTvUser.setText("멋진 캔따개")
                binding.postTvUserLocate.setText("AA 초등학교 앞")
            }else if(postInfoItem[0].image.toString().toInt() ==2){
                binding.postIvDummy.setImageResource(R.drawable.dummy_cat_15)
                binding.postIvUser.setImageResource(R.drawable.dummy_cat_05)
                binding.postTvUser.setText("멋진 캔따개")
                binding.postTvUserLocate.setText("BC 신발가게 옆")
            }else if(postInfoItem[0].image.toString().toInt() ==3){
                binding.postIvDummy.setImageResource(R.drawable.dummy_cat_16)
                binding.postIvUser.setImageResource(R.drawable.dummy_cat_06)
                binding.postTvUser.setText("가다랑어포 좋아")
                binding.postTvUserLocate.setText("CC 역 2번 출구")
            }else if(postInfoItem[0].image.toString().toInt() ==4){
                binding.postIvDummy.setImageResource(R.drawable.dummy_cat_17)
                binding.postIvUser.setImageResource(R.drawable.dummy_cat_07)
                binding.postTvUser.setText("오레오 오즈")
                binding.postTvUserLocate.setText("B 구청 앞")
            }else{
                binding.postIvDummy.setImageResource(R.drawable.dummy_cat_08)
                binding.postIvUser.setImageResource(R.drawable.dummy_cat_05)
                binding.postTvUser.setText("야생의 집사")
                binding.postTvUserLocate.setText("A 아파트 놀이터 옆")
            }
        }
    }

    override fun onGetPostInfoFailure(message: String) {
        Log.e("Test", "onGetPostInfoFailure: $message")
    }

    override fun onPostReplySuccess(result: ReplyListItem) {
        Log.d("Test", "댓글 입력됨")

    }

    override fun onPostReplyFailure(message: String) {
        Log.e("Test", "onPostReplyFailure: $message")
    }

    //키보드 내리기
    fun softkeyboardHide() {
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(currentFocus?.windowToken, 0)
    }
}