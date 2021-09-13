package com.example.cattocat.src.main.board.posting

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cattocat.R
import com.example.cattocat.databinding.ActivityPostBinding
import com.example.cattocat.src.main.board.model.BoardItem
import com.example.cattocat.src.main.board.model.ReplyItem
import com.example.cattocat.src.main.board.posting.adapter.ReplyRecyAdapter

class PostActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPostBinding
    private var replyItem = ArrayList<ReplyItem>()
    private lateinit var replyAdapter: ReplyRecyAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPostBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replyRecyAdapter(replyItem)





        replyItem.add(ReplyItem(1,23,"흰양말신은고양이", R.drawable.dummy_cat_05, "헐 넘넘 기여워용", "2021-09-24"))
        replyItem.add(ReplyItem(2,11,"검은 양말 턱시도", R.drawable.dummy_cat_07, "치즈 고양이 최고져", "2021-09-24"))
        replyItem.add(ReplyItem(3,7,"모자 한 번만 써주라", R.drawable.dummy_cat_08, "되게 순하네요. 우리집 고양이는 오늘도 긁었어요ㅠㅠ 스트릿 출신이 아니라서 예의가 없는 걸까요? 맨날 좋은것만 먹였더니 아주 양심도 없구ㅠㅠ 근데 또 귀여우니까 참아요ㅠㅠ", "2021-09-24"))
        replyItem.add(ReplyItem(4,2,"넥타이 한 번 만 해주라", R.drawable.dummy_cat_12, "고양이도 즐거운 추석", "2021-09-24"))




    }


    private fun replyRecyAdapter(replyItem: ArrayList<ReplyItem>) {
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
}