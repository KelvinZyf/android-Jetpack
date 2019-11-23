package com.cz.czclient.fragment

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import com.cz.czclient.R

class NavigationActivity: AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navigation)

        setNavHostFragment()

    }

    /**
     * 代码设置跳转路由表
     */
    private fun setNavHostFragment() {
        val navHostFragment = NavHostFragment.create(R.navigation.navi)
        supportFragmentManager.beginTransaction().replace(R.id.container, navHostFragment).setPrimaryNavigationFragment(navHostFragment).commit()
    }

    /**
     * AppCompatActivity需要重写此方法？
     */
//    override fun onSupportNavigateUp(): Boolean {
//        return Navigation.findNavController(this, R.id.action_welComeFragment_to_loginFragment2).navigateUp()
//    }
}