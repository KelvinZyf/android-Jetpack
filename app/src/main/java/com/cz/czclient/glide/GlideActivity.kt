package com.cz.czclient.glide

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cz.czclient.R
import kotlinx.android.synthetic.main.activity_glide.*

class GlideActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_glide)

        initView()
    }

    private fun initView() {
        val layoutManager = LinearLayoutManager(this@GlideActivity)
        val adapter = GlideAdapter(this)
        recycle_view.layoutManager = layoutManager
        recycle_view.adapter = adapter
        recycle_view.addOnScrollListener(ImageAutoLoadScrollListener(this))


    }

    inner class ImageAutoLoadScrollListener(val context: Context): RecyclerView.OnScrollListener() {


        override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
            super.onScrollStateChanged(recyclerView, newState)
            when (newState) {
                RecyclerView.SCROLL_STATE_IDLE ->  //当屏幕停止滚动，加载图片
                    try {
                        if (context != null){
                            GlideUtil.startRequest(context)
                        }
                    } catch (e: Exception) {
                        e.printStackTrace()
                    }
                RecyclerView.SCROLL_STATE_DRAGGING ->  //当屏幕滚动且用户使用的触碰或手指还在屏幕上，停止加载图片
                    try {
                        if (context != null) {
                            GlideUtil.pauseRequest(context)
                        }
                    } catch (e: Exception) {
                        e.printStackTrace()
                    }
                RecyclerView.SCROLL_STATE_SETTLING ->  //由于用户的操作，屏幕产生惯性滑动，停止加载图片
                    try {
                        if (context != null) {
                            GlideUtil.pauseRequest(context)
                        }
                    } catch (e: Exception) {
                        e.printStackTrace()
                    }
            }
        }
    }
}