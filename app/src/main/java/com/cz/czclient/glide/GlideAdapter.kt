package com.cz.czclient.glide

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.cz.czclient.R

class GlideAdapter(private val context: Context): RecyclerView.Adapter<GlideAdapter.ViewHolder>() {

    private val url = "http://img5.imgtn.bdimg.com/it/u=3180497685,3912594882&fm=26&gp=0.jpg"



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_view, parent, false))

    }

    override fun getItemCount(): Int {
        return 1000
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.name.text = position.toString()
        GlideUtil.loadImage(context, holder.imageView, url)

    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.image_view)!!
        val name: TextView = itemView.findViewById(R.id.name)!!
    }
}