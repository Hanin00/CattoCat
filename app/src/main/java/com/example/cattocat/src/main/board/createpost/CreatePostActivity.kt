package com.example.cattocat.src.main.board.createpost

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.cattocat.databinding.ActivityBoardBinding
import com.example.cattocat.databinding.ActivityCreatepostBinding
import com.example.cattocat.src.main.board.BoardView
import com.example.cattocat.src.main.board.adapter.BoardRecyAdapter
import com.example.cattocat.src.main.board.createpost.model.CreatePostRequest
import com.example.cattocat.src.main.board.model.BoardItem

class CreatePostActivity : AppCompatActivity(), CreatePostView {
    private lateinit var binding: ActivityCreatepostBinding

    private var image = "1"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCreatepostBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.crpostBtnSend.setOnClickListener {


            val title = binding.crpostEdTitle.text.toString()
            val content = binding.crpostEdContent.text.toString()
            val user_id = 1

            if(binding.crpostEdContent.length() <= 5){
                image = "1"
            }else if(binding.crpostEdContent.length() <= 10){
                image = "2"
            }else if(binding.crpostEdContent.length() <= 25){
                image = "3"
            }else{
                if(binding.crpostEdContent.length() % 2 == 1){
                    image = "4"
                }else {
                    image = "3"
                }
            }




            val request = CreatePostRequest(user_id, title, content, image, null)

            if (title != "") {
                if (content != "") {

                    //retrofit 달기
                    CreatePostService(this, request).tryPostCreatePost()
                } else {
                    Toast.makeText(this, "내용을 입력해주세요", Toast.LENGTH_SHORT).show()
                }

            } else {
                Toast.makeText(this, "제목을 입력해주세요", Toast.LENGTH_SHORT).show()
            }


        }
        binding.crpostBtnUpload

    }

    override fun onPostPostingSuccess(result: CreatePostRequest) {
        Toast.makeText(this, "등록되었습니다.", Toast.LENGTH_SHORT).show()
        Log.d("Test", "정상연결")
        Log.d("Test", "${result}")
        finish()

    }

    override fun onPostPostingFailure(message: String) {
        Log.e("Test", "onPostAddCatFailure: $message")
    }
}