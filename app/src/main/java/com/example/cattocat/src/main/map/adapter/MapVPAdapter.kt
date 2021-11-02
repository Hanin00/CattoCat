package com.example.cattocat.src.main.map.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.cattocat.R
import com.example.cattocat.src.main.map.catmarker.model.CatMarkerItem


class MapVPAdapter(val itemClicked: (CatMarkerItem) -> Unit) :
    ListAdapter<CatMarkerItem, MapVPAdapter.ItemViewHolder>(differ) {
    inner class ItemViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        @SuppressLint("ResourceAsColor", "SetTextI18n")
        fun bind(mapItem: CatMarkerItem) {

            val chair = view.findViewById<TextView>(R.id.item_map_tv_cathair)
            val cname = view.findViewById<TextView>(R.id.item_map_tv_name)
            val clocation = view.findViewById<TextView>(R.id.item_map_tv_location)
            val cprefer = view.findViewById<TextView>(R.id.item_map_tv_prefer)
            val menu = view.findViewById<ImageView>(R.id.item_map_iv_menu)
            val cImage = view.findViewById<ImageView>(R.id.item_map_iv)

            chair.text = mapItem.cat_hair
            cname.text = mapItem.cat_name
            cprefer.text = mapItem.cat_prefer
            clocation.text = mapItem.cat_locate


            view.setOnClickListener {
                itemClicked(mapItem)
            }

            val imagenum = mapItem.cat_image.toString().toInt()

            if(mapItem.cat_id != -1)
            {
                if(imagenum == 1){
                    cImage.setImageResource(R.drawable.dummy_cat_03)

                }else if(imagenum == 2){
                    cImage.setImageResource(R.drawable.dummy_cat_04)

                }else if(imagenum == 3){
                    cImage.setImageResource(R.drawable.dummy_cat_06)

                }else{
                    cImage.setImageResource(R.drawable.dummy_cat_06)

                }


            }else{
                cImage.setImageResource(R.drawable.ic_map_default_gray)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ItemViewHolder(
            inflater.inflate(
                R.layout.item_map_description,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(currentList[position])
    }

    companion object {
        val differ = object : DiffUtil.ItemCallback<CatMarkerItem>() {
            override fun areItemsTheSame(oldItem: CatMarkerItem, newItem: CatMarkerItem): Boolean {
                return oldItem.cat_id == newItem.cat_id
            }

            override fun areContentsTheSame(oldItem: CatMarkerItem, newItem: CatMarkerItem): Boolean {
                return oldItem == newItem
            }
        }
    }
}
