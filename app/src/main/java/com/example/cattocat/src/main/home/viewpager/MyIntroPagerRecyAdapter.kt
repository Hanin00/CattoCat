package com.example.cattocat.src.main.home.viewpager

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cattocat.R
import kotlinx.android.synthetic.main.item_viewpager_home_post.view.*

class MyIntroPagerRecyAdapter(private val pageList: ArrayList<PageItem>)
    : RecyclerView.Adapter<MyIntroPagerRecyAdapter.MyIntroPagerViewHolder>() {
    inner class MyIntroPagerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val itemImage = itemView.home_pager_item_image
        private val itemtitle = itemView.home_pager_item_tv_title
        private val itemContent = itemView.home_pager_item_tv_content
        private val userNickname = itemView.home_pager_item_tv_user

        //   private val itemBg = itemView.pager_item_bg
        fun bind(pageItem: PageItem) {
            itemImage.setImageResource(pageItem.imageSrc)
            itemtitle.text = pageItem.title
            itemContent.text = pageItem.content
            userNickname.text = pageItem.userNickname
            val itemId = pageItem.id
            itemView.setOnClickListener {

                Log.d("Test","MyIntroPagerRecyAdpater - clicked post id : $itemId")
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
        return pageList.size
    }

    override fun onBindViewHolder(
        holder: MyIntroPagerViewHolder,
        position: Int
    ) {
        holder.bind(pageList[position])
    }
}