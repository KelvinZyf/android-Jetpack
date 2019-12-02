package com.cz.czclient

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_first.*

class FirstActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)

        addItem()
        val linearLayoutManager = LinearLayoutManager(this)
        recycle_view.layoutManager = linearLayoutManager
        val adapter = Adapter(list, this)
        recycle_view.adapter = adapter
        adapter.setOnItemClickListener(object: ItemClickListener{
            override fun itemClickListener(view: View, position: Int) {
                val intent = Intent(this@FirstActivity, Class.forName(list[position]))
                startActivity(intent)
            }
        })
    }

    private val list: ArrayList<String> = ArrayList()
    private fun addItem() {
        list.add("com.cz.czclient.MainActivity")
        list.add("com.cz.czclient.nacigation.NavigationActivity")
        list.add("com.cz.czclient.glide.GlideActivity")
        list.add("com.cz.czclient.databinding.DataBindActivity")
    }


    inner class Adapter(var list: ArrayList<String>, var context: Context): RecyclerView.Adapter<ViewHolder>() {

        private lateinit var itemClickListener: ItemClickListener
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            return ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_first_view, parent, false))
        }

        override fun getItemCount(): Int {
            return list.size
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.textView.text = list[position]
            holder.getItemView().setOnClickListener {
                itemClickListener.itemClickListener(holder.getItemView(), position)
            }
        }

        public fun setOnItemClickListener(itemClickListener: ItemClickListener) {
            this.itemClickListener = itemClickListener
        }
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val textView: TextView = itemView.findViewById(R.id.activity_name)

        public fun getItemView(): View{
            return itemView
        }
    }

}