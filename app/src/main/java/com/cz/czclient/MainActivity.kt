package com.cz.czclient

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.LruCache
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        lru_button.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v?.id) {
            R.id.lru_button -> {
                setLruCache()
            }
        }
    }

    private fun setLruCache() {
        val lruCache = LruCache<Int, Int>(5)
        lruCache.put(1,1)
        lruCache.put(2,2)
        lruCache.put(3,3)
        lruCache.put(4,4)
        lruCache.put(5,5)

        val sets = lruCache.snapshot().entries
        for (i in sets) {
            println("LRU${i.key}:${i.value}")
        }

        println("LRU已满")


        lruCache.put(6,6)
        val set1 = lruCache.snapshot().entries
        for (i in set1) {
            println("LRU${i.key}:${i.value}")
        }
    }
}
