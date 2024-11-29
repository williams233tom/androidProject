package com.example.smartold.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import com.example.smartold.R
import com.example.smartold.ui.chatchild.ChatItemFragment
import com.example.smartold.ui.personalchild.HospitalFragment
import com.example.smartold.ui.personalchild.OwnerFragment

class ChatFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        //使用 inflater 创建 view
        val view = inflater.inflate(R.layout.chat_fragment, container, false)

        //对现有view创建并处理toolbar
        val toolbar: Toolbar = view.findViewById(R.id.toolbar)
        val activity = activity as AppCompatActivity?
        if (activity != null) {
            activity.setSupportActionBar(toolbar)
            //返回按钮
            activity.supportActionBar!!.setDisplayHomeAsUpEnabled(true)
            //标题
            activity.supportActionBar!!.title = "" // Optional: Set a title
        }

        // 加载chatItemFragment
        val chatItemFragment = ChatItemFragment()
        val chatItemTransaction = childFragmentManager.beginTransaction()
        chatItemTransaction.replace(R.id.chat_fragment_container,chatItemFragment)
        chatItemTransaction.commit()

        // 返回view
        return view
    }
}