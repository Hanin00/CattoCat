package com.example.cattocat.src.main.board

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cattocat.databinding.ActivityBoardBinding
import com.example.cattocat.src.main.board.adapter.BoardRecyAdapter
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
        boardRecyAdapter(boardItemList)

        BoardService(this).tryGetBoard()





      /*  boardItemList.add(BoardItem(1,1,"야생의 고양이","고양이 쉼터",
        "모현동","고양이 왈츠","2019-12-12","고양이 차차 고양이 차차",R.drawable.dummy_muner,R.drawable.dummy_cat_05))
        boardItemList.add(BoardItem(2,3,"턱시도 고양이","캣 휠 위",
            "동산동","원래 이렇게 돌아가요?","2019-12-12","우리집 고양이 다리가 안보임;",R.drawable.dummy_cat_03,R.drawable.dummy_cat_12))
        boardItemList.add(BoardItem(1,8,"야생의 고양이","자이 2차 정문",
            "영등동","한파 대비 집 설치 되었어요","2019-12-12","함께 해주신 분들 감사합니다!",R.drawable.dummy_cat_04,R.drawable.dummy_cat_15))
        boardItemList.add(BoardItem(3,1,"집에 가고시퍼","우리집 앞",
            "중앙동","이거 무슨 사료에요?","2021-12-12","코 박고 먹는데요?",R.drawable.dummy_cat_07,R.drawable.dummy_cat_03))
*/

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