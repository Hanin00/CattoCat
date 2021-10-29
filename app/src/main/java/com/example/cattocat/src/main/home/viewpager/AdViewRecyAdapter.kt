package com.example.cattocat.src.main.home.viewpager

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.asksira.loopingviewpager.LoopingPagerAdapter
import com.example.cattocat.R
import com.example.cattocat.src.main.home.model.HomeAdItem


class AdViewRecyAdapter(
    itemList: ArrayList<HomeAdItem>,
    isInfinite: Boolean, private val context: Context, private val clickListener: (Int) -> Unit
) : LoopingPagerAdapter<HomeAdItem>(itemList, isInfinite) {
    override fun bindView(convertView: View, listPosition: Int, viewType: Int) {
        val adImgView = convertView.findViewById<ImageView>(R.id.item_ad_vp_image)
        val adImg = itemList?.get(listPosition)?.imageSrc


        adImgView.setOnClickListener {
            Log.d("Test", "AdViewRecyAdapter - 클릭됨")
            val adIdx = itemList?.get(listPosition)?.id
            if (adIdx != null) {
                clickListener(adIdx)
                Log.d("Test", "AdViewRecyAdapter - adIdx :  ${adIdx}")
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
