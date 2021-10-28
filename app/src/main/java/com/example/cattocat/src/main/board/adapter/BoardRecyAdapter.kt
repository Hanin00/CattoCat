package com.example.cattocat.src.main.board.adapter

import android.content.Context
import android.content.Intent
import android.text.Layout
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cattocat.R
import com.example.cattocat.src.main.board.model.BoardItem
import com.example.cattocat.src.main.board.posting.PostActivity

class BoardRecyAdapter (var boardItem: ArrayList<BoardItem>,
private val context: Context
):RecyclerView.Adapter<BoardRecyAdapter.BoardViewHolder>(){
    inner class BoardViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        private val  userImg = itemView.findViewById<ImageView>(R.id.item_board_iv_user)
        private val  dummyImg = itemView.findViewById<ImageView>(R.id.item_board_iv_dummy)
        private val  likeImg = itemView.findViewById<ImageView>(R.id.item_board_iv_like)
        private val  replyImg = itemView.findViewById<ImageView>(R.id.item_board_iv_reply)
        private val  menuBtn = itemView.findViewById<ImageView>(R.id.item_board_iv_menu)
        private val  userName = itemView.findViewById<TextView>(R.id.item_board_tv_user)
        private val  userLocate = itemView.findViewById<TextView>(R.id.item_board_tv_user_locate)
        private val  boardLocate = itemView.findViewById<TextView>(R.id.item_board_tv_locate)
        private val  title = itemView.findViewById<TextView>(R.id.item_board_tv_title)
        private val  date = itemView.findViewById<TextView>(R.id.item_board_tv_date)
      //  private val  imgVp = itemView.findViewById<TextView>(R.id.item_board_vp_images)
        private val  content = itemView.findViewById<TextView>(R.id.item_board_tv_content)

        fun bind(item : BoardItem){
       /*     Glide.with(context)
                .load(item.userImg)
                .fitCenter()
                .override(100, 100)
                .transforms(CenterCrop(), RoundedCorners(20))
                .into(iEventImg)*/


           // userImg.setImageResource(item.)
          //  dummyImg.setImageResource(item.dummyImg)

         //   userName.text = item.u
           // userLocate.text = item.userLocate
            title.text = item.title
            date.text = item.created_at
            //boardLocate.text = item.
            content.text = item.content

            itemView.setOnClickListener{
                val intent = Intent(context, PostActivity::class.java)
                intent.putExtra("isUserIdx",item.post_id)
                intent.putExtra("isPostIdx",item.contentIdx)
                Log.d("Test","화면전환")
                itemView.context.startActivity(intent)
            }


        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BoardViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_board, parent, false)
        return BoardViewHolder(view)
    }

    override fun onBindViewHolder(holder: BoardViewHolder, position: Int) {
        val item = boardItem[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int  = boardItem.size

    fun setItems(newItems: ArrayList<BoardItem>) {
        this.boardItem = newItems
        notifyDataSetChanged()
    }

}