package com.example.smartold.ui

import com.example.smartold.R
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.Nullable

import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment



class HomeFragment : Fragment() {
    private lateinit var drawerLayout: DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        //使用 inflater 创建 view
        val view = inflater.inflate(R.layout.home_fragment, container, false)

        //对现有view创建并处理toolbar
        val toolbar: Toolbar = view.findViewById(R.id.toolbar)
        //此处的activity是宿主activity
        val activity = activity as AppCompatActivity?
        if (activity != null) {
            activity.setSupportActionBar(toolbar)
            //标题置空
            activity.supportActionBar!!.title = ""

            toolbar.setNavigationIcon(R.drawable.menu) // 替换为您的图标资源
            toolbar.setNavigationOnClickListener {

                // 调用侧边栏菜单
                // 获取 DrawerLayout 的引用
                drawerLayout = activity.findViewById(R.id.drawer_layout)
                // 打开 DrawerLayout
                drawerLayout.openDrawer(GravityCompat.START)
            }
        }

        // 返回view
        return view
    }


}