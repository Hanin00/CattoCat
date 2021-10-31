package com.example.cattocat.src.main.board

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cattocat.databinding.ActivityBoardBinding
import com.example.cattocat.src.main.board.adapter.BoardRecyAdapter
import com.example.cattocat.src.main.board.createpost.CreatePostActivity
import com.example.cattocat.src.main.board.model.BoardItem
import com.example.cattocat.src.main.board.model.BoardResponse

//게시판
class BoardActivity : AppCompatActivity(),BoardView {
    private lateinit var binding : ActivityBoardBinding
    private lateinit var boardRecyAdapter: BoardRecyAdapter
    private var boardItemList = ArrayList<BoardItem>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBoardBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.boardBtnCreate.setOnClickListener {

            val intent = Intent(this, CreatePostActivity::class.java)
            startActivity(intent)

        }
    }


    override fun onResume() {
        super.onResume()
        boardRecyAdapter(boardItemList)
        BoardService(this).tryGetBoard()
    }

    fun boardRecyAdapter(boardItem: ArrayList<BoardItem>){
        boardRecyAdapter = BoardRecyAdapter(boardItem, this)
        binding.boardRecy.apply {
            adapter = boardRecyAdapter
            layoutManager = LinearLayoutManager(
                context,
                LinearLayoutManager.VERTICAL, false
            )
            boardRecyAdapter.notifyDataSetChanged()
        }
    }

    override fun onGetBoardSuccess(result: BoardResponse) {
        Toast.makeText(this, "정상연결.", Toast.LENGTH_SHORT).show()
        Log.d("Test", "정상연결")
        Log.d("Test", "${result}")

        if(result.postlist != null){
            boardRecyAdapter(result.postlist)
        }else{
            Log.d("Test","등록된 게시글 X")
        }

    }

    override fun onGetBoardFailure(message: String) {
        Log.e("Test", "onPostAddCatFailure: $message")
    }
}