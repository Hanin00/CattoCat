package com.example.cattocat.src.main.home.viewpager

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cattocat.Companion
import com.example.cattocat.R
import com.example.cattocat.src.main.board.posting.PostActivity
import com.example.cattocat.src.main.home.model.HomePostItem
import kotlinx.android.synthetic.main.item_viewpager_home_post.view.*

class MyIntroPagerRecyAdapter(private val homePostList: ArrayList<HomePostItem?>, private val context: Context, private val clickListener:(Int)->Unit)
    : RecyclerView.Adapter<MyIntroPagerRecyAdapter.MyIntroPagerViewHolder>() {
    inner class MyIntroPagerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val itemImage = itemView.home_pager_item_image
        private val itemtitle = itemView.home_pager_item_tv_title
        private val itemContent = itemView.home_pager_item_tv_content
        private val userNickname = itemView.home_pager_item_tv_user

        //   private val itemBg = itemView.pager_item_bg
        fun bind(homePostItem: HomePostItem) {
           //todo 사진 연결, 유저 이름 연결
         //   itemImage.setImageResource(homePostItem.imageSrc)
            itemImage.setImageResource(R.drawable.dummy_cat_01)
            itemtitle?.text = homePostItem.title
            itemContent?.text = homePostItem.content
            //userNickname.text = homePostItem.user_id
            val itemIdx = homePostItem.post_id

            itemView.setOnClickListener {
                val intent = Intent(context, PostActivity::class.java)
                intent.putExtra("isPostIdx", homePostItem.post_id)
                intent.putExtra("isUserIdx", Companion.USERID)
                Log.d("Test","MyIntroPagerRecyAdpater - clicked post id : ${homePostItem.post_id}")
                Log.d("Test","MyIntroPagerRecyAdpater - clicked post id : ${itemIdx}")
                itemView.context.startActivity(intent)
            }

          /*  if(pageItem.itemImage != "-1")
            {
                Glide.with(hospitalLogo.context)
                    .load(mapItem.hospitalImg)
                    .fitCenter()
                    .override(100, 100)
                    .transforms(CenterCrop(), RoundedCorners(360))
                    .into(hospitalLogo)
            }else{
                hospitalLogo.setImageResource(R.drawable.ic_map_default_gray)
            }*/
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyIntroPagerViewHolder {
        return MyIntroPagerViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_viewpager_home_post, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return homePostList.size
    }

    override fun onBindViewHolder(
        holder: MyIntroPagerViewHolder,
        position: Int
    ) {
        homePostList[position]?.let { holder.bind(it) }
    }
}