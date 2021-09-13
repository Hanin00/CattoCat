package com.example.cattocat.src.main.board.posting.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cattocat.R
import com.example.cattocat.src.main.board.model.ReplyItem
import com.example.cattocat.src.main.board.posting.PostActivity

class ReplyRecyAdapter(var replyItem: ArrayList<ReplyItem>,
                       private val context : Context) : RecyclerView.Adapter<ReplyRecyAdapter.ReplyViewHolder>() {
    inner class ReplyViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){

        private val  menuBtn = itemView.findViewById<ImageView>(R.id.item_reply_iv_menu)
        private val  userImg = itemView.findViewById<ImageView>(R.id.item_reply_iv_user)
        private val  useName = itemView.findViewById<TextView>(R.id.item_reply_tv_user)
        private val  userComment = itemView.findViewById<TextView>(R.id.item_reply_tv_user_comment)
        private val  date = itemView.findViewById<TextView>(R.id.item_reply_tv_time)

        fun bind(item : ReplyItem){
            /*     Glide.with(context)
         .load(item.userImg)
         .fitCenter()
         .override(100, 100)
         .transforms(CenterCrop(), RoundedCorners(20))
         .into(iEventImg)*/

            userImg.setImageResource(item.userImg)
            useName.text = item.userName
            userComment.text = item.reply
            date.text = item.date

            menuBtn.setOnClickListener{
            /*    val intent = Intent(context, PostActivity::class.java)
                intent.putExtra("isUserIdx",item.userIdx)
                intent.putExtra("isReplyIdx",item.reply)*/
                Log.d("Test","댓글 메뉴 클릭")
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