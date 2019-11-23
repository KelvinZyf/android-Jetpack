package com.cz.czclient.nacigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.cz.czclient.R
import kotlinx.android.synthetic.main.fragment_login.*

/**
 * 登录页面
 */
class LoginFragment: Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        commit.setOnClickListener {
            // 配置跳转路由
            Navigation.findNavController(it).navigate(R.id.action_loginFragment_to_mainFragment)

        }
    }
}