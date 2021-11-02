package com.example.cattocat.src.main.board.posting.adapter

import android.content.Context
import android.text.TextUtils.substring
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cattocat.R
import com.example.cattocat.src.main.board.posting.model.ReplyListItem

class ReplyRecyAdapter(
    var replyItem: ArrayList<ReplyListItem>,
    private val context: Context
) : RecyclerView.Adapter<ReplyRecyAdapter.ReplyViewHolder>() {
    inner class ReplyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val menuBtn = itemView.findViewById<ImageView>(R.id.item_reply_iv_menu)
        private val userImg = itemView.findViewById<ImageView>(R.id.item_reply_iv_user)
        private val userName = itemView.findViewById<TextView>(R.id.item_reply_tv_user)
        private val userComment = itemView.findViewById<TextView>(R.id.item_reply_tv_user_comment)
        private val date = itemView.findViewById<TextView>(R.id.item_reply_tv_time)

        fun bind(item: ReplyListItem) {

            //    todo 사진 붙여야함.  userImg.setImageResource(item.userImg)
            userName.text = item.user_id.toString()
            val userIdx = item.user_id.toString().toInt()
            if (userIdx % 7 == 1) {
                userName.setText("야생의 집사")
                userImg.setImageResource(R.drawable.dummy_cat_05)

            } else if (userIdx % 7 == 2) {

                userName.setText("캔따개")
                userImg.setImageResource(R.drawable.dummy_cat_06)
                
            } else if (userIdx % 7 == 3) {

                userName.setText("오레오 오렌지맛")
                userImg.setImageResource(R.drawable.dummy_cat_07)
                
            } else if (userIdx % 7 == 4) {
                userName.setText("빨간츄르 파란츄르")
                userImg.setImageResource(R.drawable.dummy_cat_08)
            } else if (userIdx % 7 == 5) {
                userName.setText("카샤캬샤붕붕")
                userImg.setImageResource(R.drawable.dummy_cat_09)
            } else if (userIdx % 7 == 6) {
                userName.setText("삼다수")
                userImg.setImageResource(R.drawable.dummy_cat_10)
            } else {
                userName.setText("야생의 집사")
                userImg.setImageResource(R.drawable.dummy_cat_11)
            }


            userComment.text = item.content
            date.text = substring(item.created_at, 0, 10)

            menuBtn.setOnClickListener {
                /*    val intent = Intent(context, PostActivity::class.java)
                    intent.putExtra("isUserIdx",item.userIdx)
                    intent.putExtra("isReplyIdx",item.reply)*/
                Log.d("Test", "댓글 메뉴 클릭")
                //todo Dialog 띄우기
                // itemView.context.startActivity(intent)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReplyViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_post_reply, parent, false)
        return ReplyViewHolder(view)
    }

    override fun onBindViewHolder(holder: ReplyViewHolder, position: Int) {
        val item = replyItem[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int = replyItem.size
}