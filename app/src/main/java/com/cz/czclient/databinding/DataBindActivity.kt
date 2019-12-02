package com.cz.czclient.databinding

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.cz.czclient.R
import com.cz.czclient.databinding.bean.User
import kotlinx.android.synthetic.main.activity_data_bind.*

class DataBindActivity: AppCompatActivity() {

    private lateinit var binding: ActivityDataBindBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView<ActivityDataBindBinding>(this, R.layout.activity_data_bind)
        binding.user = User("重阳", "王")

        button.setOnClickListener{
            binding.user = User("无忌", "张")
        }
    }

}