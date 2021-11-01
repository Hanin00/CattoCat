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


            if(item.image.toString().toInt() ==1){
                userImg.setImageResource(R.drawable.dummy_cat_04)
                userName.setText("멋진 캔따개")
                userLocate.setText("AA 초등학교 앞")
            }else if(item.image.toString().toInt() ==2){
                userImg.setImageResource(R.drawable.dummy_cat_05)
                userName.setText("멋진 캔따개")
                userLocate.setText("BC 신발가게 옆")
            }else if(item.image.toString().toInt() ==3){
                userImg.setImageResource(R.drawable.dummy_cat_06)
                userName.setText("가다랑어포 좋아")
                userLocate.setText("CC 역 2번 출구")
            }else if(item.image.toString().toInt() ==4){
                userImg.setImageResource(R.drawable.dummy_cat_07)
                userName.setText("오레오 오즈")
                userLocate.setText("B 구청 앞")
            }else{
                userImg.setImageResource(R.drawable.dummy_cat_05)
                userName.setText("야생의 집사")
                userLocate.setText("A 아파트 놀이터 옆")
            }
            
            if(item.image.toString().toInt() ==1){
                dummyImg.setImageResource(R.drawable.dummy_cat_14)
            }else if(item.image.toString().toInt() ==2){
                dummyImg.setImageResource(R.drawable.dummy_cat_15)
            }else if(item.image.toString().toInt() ==3){
                dummyImg.setImageResource(R.drawable.dummy_cat_16)
            }else if(item.image.toString().toInt() ==4){
                dummyImg.setImageResource(R.drawable.dummy_cat_17)
            }else{
                dummyImg.setImageResource(R.drawable.dummy_cat_08)
            }




          //  dummyImg.setImageResource(item.dummyImg)


            //   userName.text = item.u
           // userLocate.text = item.userLocate
            title.text = item.title
            val created_at =  item.created_at

            if (created_at != null) {
                date.text = created_at.substring(0,10)
            }
            //boardLocate.text = item.
            content.text = item.content

            itemView.setOnClickListener{
                val intent = Intent(context, PostActivity::class.java)
                intent.putExtra("isUserIdx",item.user_id)
                intent.putExtra("isPostIdx",item.post_id)
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