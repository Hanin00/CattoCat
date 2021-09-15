package com.example.cattocat.src.main.mycat.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cattocat.R
import com.example.cattocat.src.main.board.adapter.BoardRecyAdapter
import com.example.cattocat.src.main.board.model.BoardItem
import com.example.cattocat.src.main.mycat.model.MyCatItem

class MyCatRecyAdapter(
    var myCatItem: ArrayList<MyCatItem>,
    private val context: Context
) : RecyclerView.Adapter<MyCatRecyAdapter.MyCatViewHolder>() {
    inner class MyCatViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val  catImg = itemView.findViewById<ImageView>(R.id.item_mycat_img)
        private val catName = itemView.findViewById<TextView>(R.id.item_mycat_name)

        fun bind(item: MyCatItem) {
            catImg.setImageResource(item.catImg)
            catName.text = item.catName

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyCatViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_mycat_mycat,parent, false)
        return MyCatViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyCatViewHolder, position: Int) {
        val item = myCatItem[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int = myCatItem.size
}

