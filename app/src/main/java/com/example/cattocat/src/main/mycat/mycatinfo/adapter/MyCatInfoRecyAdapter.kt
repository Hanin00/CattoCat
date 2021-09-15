package com.example.cattocat.src.main.mycat.mycatinfo.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cattocat.R
import com.example.cattocat.src.main.mycat.mycatinfo.model.CatInfoItem

class MyCatInfoRecyAdapter(var myCatItem: ArrayList<CatInfoItem>,
                           private val context: Context,
                           private val clickListener:(Int)->Unit)
    : RecyclerView.Adapter<MyCatInfoRecyAdapter.CatInfoViewHolder>() {
    inner class CatInfoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val  catImg = itemView.findViewById<ImageView>(R.id.item_mycat_img)
        private val catName = itemView.findViewById<TextView>(R.id.item_mycat_name)

        fun bind(item: CatInfoItem) {
            catImg.setImageResource(item.catImg)
            catName.text = item.catName
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatInfoViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_mycat_mycat,parent, false)
        return CatInfoViewHolder(view)
    }

    override fun onBindViewHolder(holder: CatInfoViewHolder, position: Int) {
        val item = myCatItem[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int = myCatItem.size
}
