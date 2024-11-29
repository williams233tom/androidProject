package com.example.smartold.ui

//要导入自己的R包
import com.example.smartold.R

import android.os.Bundle
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import androidx.viewpager.widget.ViewPager.OnPageChangeListener
import com.example.smartold.ui.homechild.FunctionFragment


//  继承接口
class MainActivity : AppCompatActivity(), FunctionFragment.OnFunctionClickListener {

    private var view_pager: ViewPager? = null // ViewPager控件
    private var radio_group: RadioGroup? = null // 单选按钮组
    private var radio_home: RadioButton? = null
    private var radio_map:RadioButton? = null
    private var radio_chat:RadioButton? = null
    private var radio_personal:RadioButton? = null // 按钮首页，分类，个人中心


    // 绑定控件
    private fun initView() {
        view_pager = findViewById<ViewPager>(com.example.smartold.R.id.view_pager)
        radio_group = findViewById<RadioGroup>(R.id.radio_group)
        radio_home = findViewById<RadioButton>(R.id.radio_home)
        radio_map = findViewById<RadioButton>(R.id.radio_map)
        radio_chat = findViewById<RadioButton>(R.id.radio_chat)
        radio_personal = findViewById<RadioButton>(R.id.radio_personal)

    }

    private lateinit var homeFragment: Fragment
    private lateinit var mapFragment:Fragment
    private lateinit var chatFragment:Fragment
    private lateinit var personalFragment:Fragment
    private val fragmentList: MutableList<Fragment> = ArrayList<Fragment>() // 用于存放碎片列表
    private var position = 0 // 用于记录当前所在的页面，默认值为0表示选中第一页

    //初始化fragment
    private fun initData() {
        homeFragment = HomeFragment()
        mapFragment = MapFragment()
        chatFragment = ChatFragment()
        personalFragment = PersonalFragment()
        fragmentList.add(homeFragment)
        fragmentList.add(mapFragment)
        fragmentList.add(chatFragment)
        fragmentList.add(personalFragment)

        val adapter = MyFragmentAdapter(this.supportFragmentManager, fragmentList)
        //为ViewPager绑定适配器
        view_pager!!.adapter = adapter
    }

    private fun initMove() {
        //滑屏监听
        view_pager!!.addOnPageChangeListener(object : OnPageChangeListener {
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
            }

            override fun onPageSelected(position: Int) {
                (radio_group!!.getChildAt(position) as RadioButton).isChecked = true
            }

            override fun onPageScrollStateChanged(state: Int) {
            }
        })
    }

    //底部导航点击
    private fun initOnclick() {
        radio_group!!.setOnCheckedChangeListener { group, checkedId ->
            when (checkedId) {
                R.id.radio_home -> {
                    position = 0
                    view_pager!!.currentItem = position
                }

                R.id.radio_map -> {
                    position = 1
                    view_pager!!.currentItem = position
                }

                R.id.radio_chat -> {
                    position = 2
                    view_pager!!.currentItem = position
                }

                R.id.radio_personal -> {
                    position = 3
                    view_pager!!.currentItem = position
                }

                else -> {
                    position = 0
                    view_pager!!.currentItem = position
                }
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.jumpbar_fragment)
        initView(); // 绑定控件
        initData(); // 将碎片类添加到ViewPager容器中
        initMove(); // 滑屏时按钮随着变化
        initOnclick(); // 单击按钮，碎片随着变化
        enableEdgeToEdge()
    }


    // 实现functionOnclick接口
    override fun onFunctionClick() {
        position = 1
        view_pager!!.currentItem = position
    }
}