package com.example.cattocat.src.main.home.viewpager

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.asksira.loopingviewpager.LoopingPagerAdapter
import com.example.cattocat.R
import com.example.cattocat.src.main.home.model.HomeNoticeItem

class NoticeRecyAdapter(itemList: ArrayList<HomeNoticeItem>,
                        isInfinite: Boolean, private val context: Context, private val clickListener:(Int)->Unit) : LoopingPagerAdapter<HomeNoticeItem>(itemList, isInfinite) {
    override fun bindView(convertView: View, listPosition: Int, viewType: Int) {

        val noticeImgView= convertView.findViewById<ImageView>(R.id.item_notice_vp_image)
        val noticeImg = itemList?.get(listPosition)?.imageSrc


        noticeImgView.setImageResource(
            context.getResources()
                .getIdentifier("drawable/${noticeImg}", null, context.getPackageName())
        )

/*
        Glide.with(context)
            .load(bannerImg)
            .error(R.color.lightGray)
            .centerCrop()
            .into(adImageView)

*/

        noticeImgView.setOnClickListener {
            val noticeIdx = itemList?.get(listPosition)?.id
            if (noticeIdx != null) {
                clickListener(noticeIdx)
                Log.d("Test", "AdViewRecyAdapter - adIdx :  ${noticeIdx}")
            }
        }
    }

    override fun inflateView(viewType: Int, container: ViewGroup, listPosition: Int): View {
       return LayoutInflater.from(container.context)
            .inflate(R.layout.item_home_vp_notice, container,false)
    }

}