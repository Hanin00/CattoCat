package com.example.cattocat.src.main.setting.notice.adapter

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cattocat.R
import com.example.cattocat.src.main.setting.notice.model.NoticeItem
import com.example.cattocat.src.main.setting.notice.noticeview.NoticeViewActivity

class NoticeRecyAdapter(var noticeItem : ArrayList<NoticeItem>, private val context : Context)
    : RecyclerView.Adapter<NoticeRecyAdapter.NoticeViewHolder>(){
        inner class NoticeViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){

            private val noticeTitle = itemView.findViewById<TextView>(R.id.item_notice_title)
            fun bind(item : NoticeItem){
                noticeTitle.text = item.noticeTitle

                itemView.setOnClickListener {
                    val intent = Intent(context, NoticeViewActivity::class.java)
                    intent.putExtra("noticeIdx", item.noticeIdx)
                    Log.d("Test","NoticeRecyclerItem 클릭 후 화면전환 Idx - ${item.noticeIdx}")
                    itemView.context.startActivity(intent)
                }
            }
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoticeViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_notice, parent, false)
        return NoticeViewHolder(view)
    }

    override fun onBindViewHolder(holder: NoticeViewHolder, position: Int) {
        val item = noticeItem[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int = noticeItem.size

}