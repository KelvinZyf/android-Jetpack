package com.cz.czclient.nacigation

import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.cz.czclient.R
import kotlinx.android.synthetic.main.fragment_welcome.*

class WelComeFragment: Fragment() {

    var tag: Int = 0

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_welcome, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        go_where.setOnClickListener {

            val s = edit.text.toString()
            if (!TextUtils.isEmpty(s)) {
                tag = s.toInt()
            }
            // 更具不同的类型跳转不同的目标
            if (1 == tag) {

                Navigation.findNavController(it).navigate(R.id.action_welComeFragment_to_loginFragment2)

            } else {
                Navigation.findNavController(it).navigate(R.id.action_welComeFragment_to_mainFragment)

            }
        }


    }
}