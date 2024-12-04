package com.example.smartold.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import com.example.smartold.R

class CarersActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.carers_activity)

        // 处理Toolbar
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        // 返回按钮
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        // 标题（可选）
        supportActionBar?.title = ""


        // 获取父级ConstraintLayout
        val parentLayout: ConstraintLayout = findViewById(R.id.carersWrap)

        // 假设n是从外部输入获取的数量
        val n = 4  // 这里可以替换为实际的逻辑来决定n的值

        // 创建一个ConstraintSet对象，用于设置约束
        val set = ConstraintSet()

        // 获取LayoutInflater
        val inflater = LayoutInflater.from(this)

        for (i in 0 until n) {
            // 使用LayoutInflater加载子布局
            val childLayout = inflater.inflate(R.layout.carers_item, parentLayout, false)

            // 为子布局生成唯一的ID
            if (childLayout.id == View.NO_ID) {
                childLayout.id = View.generateViewId()
            }

            // 将子布局添加到父布局
            parentLayout.addView(childLayout)

            // 使用ConstraintSet设置约束
            if (i == 0) {  // 第一个子布局
                set.clone(parentLayout)
                set.connect(childLayout.id, ConstraintSet.TOP, parentLayout.id, ConstraintSet.TOP, 16)  // 顶部距离父布局16dp
                set.connect(childLayout.id, ConstraintSet.START, parentLayout.id, ConstraintSet.START, 16)  // 左侧距离父布局16dp
            } else {  // 其他子布局
                set.clone(parentLayout)
                set.connect(childLayout.id, ConstraintSet.TOP, parentLayout.getChildAt(i - 1).id, ConstraintSet.BOTTOM, 16)  // 顶部距离上一个子布局底部16dp
                set.connect(childLayout.id, ConstraintSet.START, parentLayout.id, ConstraintSet.START, 16)  // 左侧距离父布局16dp
            }
            set.applyTo(parentLayout)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            // 处理返回按钮点击事件
            onBackPressed()
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}