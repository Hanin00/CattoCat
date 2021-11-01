package com.example.cattocat.src.main.setting.myreply.adapter

import android.content.Context
import android.content.Intent
import android.text.TextUtils.substring
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cattocat.Companion.Companion.USERID
import com.example.cattocat.Companion.Companion.USERNAME
import com.example.cattocat.R
import com.example.cattocat.src.main.board.posting.PostActivity
import com.example.cattocat.src.main.setting.myreply.model.MyPostItem

class MyPostRecyAdapter(
    var replyItem: ArrayList<MyPostItem>,
    private val context: Context, val itemClick: (MyPostItem) -> Unit
) : RecyclerView.Adapter<MyPostRecyAdapter.MyReplyViewHolder>() {
    inner class MyReplyViewHolder(itemView: View, itemClick: (MyPostItem) -> Unit) : RecyclerView.ViewHolder(itemView) {

        private val menuBtn = itemView.findViewById<ImageView>(R.id.item_settings_iv_menu)
        private val userName = itemView.findViewById<TextView>(R.id.item_settings_tv_user)
        private val userComment =
            itemView.findViewById<TextView>(R.id.item_settings_tv_user_comment)
        private val date = itemView.findViewById<TextView>(R.id.item_settings_tv_time)

        fun bind(item: MyPostItem) {
            /*     Glide.with(context)
         .load(item.userImg)
         .fitCenter()
         .override(100, 100)
         .transforms(CenterCrop(), RoundedCorners(20))
         .into(iEventImg)*/

            //    todo 사진 붙여야함.  userImg.setImageResource(item.userImg)
            userName.text = USERNAME
            userComment.text = item.content
            date.text = substring(item.created_at,0, 10)

            itemView.setOnClickListener {
                val intent = Intent(context, PostActivity::class.java)
                intent.putExtra("isPostIdx",item.post_id)
                intent.putExtra("isUserIdx",USERID)
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