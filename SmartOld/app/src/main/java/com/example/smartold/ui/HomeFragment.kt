package com.example.smartold.ui

import android.content.Context
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
import androidx.fragment.app.FragmentTransaction
import com.example.smartold.ui.homechild.CarerFragment
import com.example.smartold.ui.homechild.FunctionFragment


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

            //菜单栏
            toolbar.setNavigationIcon(R.drawable.menu) // 替换为您的图标资源

            toolbar.setNavigationOnClickListener {
                // 调用侧边栏菜单
                // 获取 DrawerLayout 的引用
                drawerLayout = activity.findViewById(R.id.drawer_layout)
                // 打开 DrawerLayout
                drawerLayout.openDrawer(GravityCompat.START)
            }
        }

        // 加载CareFragment
        val carerFragment = CarerFragment()
        val careTransaction = childFragmentManager.beginTransaction()
        careTransaction.replace(R.id.carer_fragment_container,carerFragment)
        careTransaction.commitNow()

        // 加载FunctionFragment
        val functionFragment = FunctionFragment()
        val functionTransaction = childFragmentManager.beginTransaction()
        functionTransaction.replace(R.id.function_fragment_container,functionFragment)
        functionTransaction.commitNow()

        // 返回view
        return view
    }

    //  Fragment附加到Activity时调用
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (context is MainActivity) {
            val functionFragment = childFragmentManager.findFragmentById(R.id.function_fragment_container) as FunctionFragment
            functionFragment.setOnFunctionClickListener(context as MainActivity)
        }
    }
}