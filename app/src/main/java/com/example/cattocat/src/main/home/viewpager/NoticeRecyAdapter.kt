package com.example.cattocat.src.main.home.viewpager

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.asksira.loopingviewpager.LoopingPagerAdapter
import com.example.cattocat.R
import com.example.cattocat.src.main.home.model.HomeNoticeItem

class NoticeRecyAdapter(
    itemList: List<HomeNoticeItem?>,
    isInfinite: Boolean, private val context: Context, private val clickListener: (Int) -> Unit
) : LoopingPagerAdapter<HomeNoticeItem>(
    itemList as List<HomeNoticeItem>, isInfinite
) {
    override fun bindView(convertView: View, listPosition: Int, viewType: Int) {

        val noticeImgView = convertView.findViewById<ImageView>(R.id.item_notice_vp_image)
        val noticeTv = convertView.findViewById<TextView>(R.id.notice_id)

        //val noticeImg = itemList?.get(listPosition)?.banner_image


        /*  noticeImgView.setImageResource(
              context.getResources().getIdentifier("drawable/${noticeImg}", null, context.getPackageName())
          )*/

/*
        Glide.with(context)
            .load(bannerImg)
            .error(R.color.lightGray)
            .centerCrop()
            .into(adImageView)

*/

        noticeTv.setText(itemList?.get(listPosition)?.title)

        noticeImgView.setOnClickListener {
            val noticeIdx = itemList?.get(listPosition)?.notice_id
            if (noticeIdx != null) {
                clickListener(noticeIdx)
                Log.d("Test", "AdViewRecyAdapter - adIdx :  ${noticeIdx}")
            }
        }
    }

    override fun inflateView(viewType: Int, container: ViewGroup, listPosition: Int): View {
        return LayoutInflater.from(container.context)
            .inflate(R.layout.item_home_vp_notice, container, false)
    }

}