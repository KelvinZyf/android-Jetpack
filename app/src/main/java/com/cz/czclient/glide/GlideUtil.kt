package com.cz.czclient.glide

import android.content.Context
import android.graphics.drawable.Drawable
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.cz.czclient.R
import jp.wasabeef.glide.transformations.BlurTransformation

class GlideUtil {

    companion object {

        /**
         * 开始加载任务栈任务
         */
        public fun startRequest(context: Context) {
            Glide.with(context).resumeRequests()
        }

        /**
         * 暂停任务栈任务
         */
        public fun pauseRequest(context: Context) {
            Glide.with(context).pauseRequests()
        }

        /**
         * 清空任务栈任务
         */
        public fun cleanRequest(context: Context) {
            Glide.with(context).pauseAllRequests()
        }

        /**
         * 加载图片
         */
        public fun loadImage(context: Context, view: ImageView,url: String) {
            Glide.with(context)
                .load(url)
                .into(view)
        }

        public fun testLoadImage(context: Context, view: ImageView,url: String) {
            Glide.with(context)
                .load(url)
                .transition(DrawableTransitionOptions.withCrossFade(500))
                .placeholder(R.mipmap.ic_launcher)// 加载中图片
                .error(R.mipmap.ic_launcher) // 加载失败图片
                .transform(CircleCrop()) // 圆形图片
                .transform(RoundedCorners(20)) // 圆角
                .transform(BlurTransformation(50,8))// 高斯模糊，参数1：模糊度；参数2：图片缩放x倍后再进行模糊
                .listener(object: RequestListener<Drawable> { // 加载监听
                    override fun onLoadFailed(
                        e: GlideException?,
                        model: Any?,
                        target: Target<Drawable>?,
                        isFirstResource: Boolean
                    ): Boolean {
                        return false
                    }

                    override fun onResourceReady(
                        resource: Drawable?,
                        model: Any?,
                        target: Target<Drawable>?,
                        dataSource: DataSource?,
                        isFirstResource: Boolean
                    ): Boolean {
                        return false
                    }


                })
                .into(view)
        }

    }
}