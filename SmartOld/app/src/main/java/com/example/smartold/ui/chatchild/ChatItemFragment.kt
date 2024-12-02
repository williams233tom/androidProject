package com.example.smartold.ui.chatchild

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import androidx.fragment.app.Fragment
import com.example.smartold.R
import com.example.smartold.ui.ChatDetailActivity

class ChatItemFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // 加载父布局
        val view = inflater.inflate(R.layout.chatitem_fragment, container, false)

        // 获取父级ConstraintLayout
        val parentLayout: ConstraintLayout = view.findViewById(R.id.chats)

        // 假设n是从外部输入获取的数量
        val n = 20  // 这里可以替换为实际的逻辑来决定n的值

        // 创建一个ConstraintSet对象，用于设置约束
        val set = ConstraintSet()

        for (i in 0 until n) {
            // 使用LayoutInflater加载子布局
            val childLayout = inflater.inflate(R.layout.chat_item, parentLayout, false)

            // 为子布局生成唯一的ID
            if (childLayout.id == View.NO_ID) {
                childLayout.id = View.generateViewId()
            }

            // 设置点击事件
            childLayout.setOnClickListener {
                onChatItemClick(it)
            }

            // 将子布局添加到父布局
            parentLayout.addView(childLayout)

            // 使用ConstraintSet设置约束
            if (i == 0) {  // 第一个子布局
                set.clone(parentLayout)
                set.connect(childLayout.id, ConstraintSet.TOP, parentLayout.id, ConstraintSet.TOP, 16)  // 顶部距离textLayout布局16dp
                set.connect(childLayout.id, ConstraintSet.START, parentLayout.id, ConstraintSet.START, 16)  // 左侧距离父布局16dp
            } else {  // 其他子布局
                set.clone(parentLayout)
                set.connect(childLayout.id, ConstraintSet.TOP, parentLayout.getChildAt(i - 1).id, ConstraintSet.BOTTOM, 16)  // 顶部距离上一个子布局底部16dp
                set.connect(childLayout.id, ConstraintSet.START, parentLayout.id, ConstraintSet.START, 16)  // 左侧距离父布局16dp
            }
            set.applyTo(parentLayout)
        }

        return view
    }

    // 定义点击事件处理方法
    fun onChatItemClick(view: View) {
        // 启动一个新的Activity
        val intent = Intent(activity, ChatDetailActivity::class.java)
        startActivity(intent)
    }
}