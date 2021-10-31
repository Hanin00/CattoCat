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
import com.example.cattocat.src.main.home.model.HomeInfoItem


class InfoViewRecyAdapter(
    itemList: List<HomeInfoItem?>,
    isInfinite: Boolean, private val context: Context, private val clickListener: (Int) -> Unit
) : LoopingPagerAdapter<HomeInfoItem>(itemList as List<HomeInfoItem>, isInfinite) {

    override fun bindView(convertView: View, listPosition: Int, viewType: Int) {
        val adImgView = convertView.findViewById<ImageView?>(R.id.item_ad_vp_image)
        //val adImg = itemList?.get(listPosition)?
        val infoTitle = convertView.findViewById<TextView?>(R.id.item_ad_vp_title)
        infoTitle.setText(itemList?.get(listPosition)?.title)


        adImgView.setOnClickListener {
            Log.d("Test", "AdViewRecyAdapter - 클릭됨")
            val infoIdx = itemList?.get(listPosition)?.info_id
            if (infoIdx != null) {
                clickListener(infoIdx)
                Log.d("Test", "AdViewRecyAdapter - adIdx :  ${infoIdx}")
            }
        }

/*
        Glide.with(context)
            .load(bannerImg)
            .error(R.color.lightGray)
            .centerCrop()
            .into(adImageView)

*/
    }

    override fun inflateView(viewType: Int, container: ViewGroup, listPosition: Int): View {
        return LayoutInflater.from(container.context)
            .inflate(R.layout.item_home_vp_ad, container, false)
    }

}
