package com.example.cattocat.src.main.setting.myreply.adapter

import android.content.Context
import android.content.Intent
import android.text.TextUtils
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cattocat.Companion
import com.example.cattocat.R
import com.example.cattocat.src.main.board.posting.PostActivity
import com.example.cattocat.src.main.setting.myreply.model.MyReplyItem

class MyReplyRecyAdapter(
    var replyItem: ArrayList<MyReplyItem>,
    private val context: Context, val itemClick: (MyReplyItem) -> Unit
) : RecyclerView.Adapter<MyReplyRecyAdapter.MyReplyViewHolder>() {
    inner class MyReplyViewHolder(itemView: View, itemClick: (MyReplyItem) -> Unit) : RecyclerView.ViewHolder(itemView) {

        private val menuBtn = itemView.findViewById<ImageView>(R.id.item_settings_iv_menu)
        private val userName = itemView.findViewById<TextView>(R.id.item_settings_tv_user)
        private val userComment =
            itemView.findViewById<TextView>(R.id.item_settings_tv_user_comment)
        private val date = itemView.findViewById<TextView>(R.id.item_settings_tv_time)

        fun bind(item: MyReplyItem) {
            /*     Glide.with(context)
         .load(item.userImg)
         .fitCenter()
         .override(100, 100)
         .transforms(CenterCrop(), RoundedCorners(20))
         .into(iEventImg)*/

            //    todo 사진 붙여야함.  userImg.setImageResource(item.userImg)
            userName.text = Companion.USERNAME
            userComment.text = item.content
            date.text = TextUtils.substring(item.created_at, 0, 10)

            itemView.setOnClickListener {
                val intent = Intent(context, PostActivity::class.java)
                intent.putExtra("post_id",item.post_id)
                context.startActivity(intent)
            }

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

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyReplyViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_settings_list,parent, false)
        return MyReplyViewHolder(view,itemClick)
    }

    override fun onBindViewHolder(holder: MyReplyViewHolder, position: Int) {
        val item = replyItem[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int = replyItem.size


}