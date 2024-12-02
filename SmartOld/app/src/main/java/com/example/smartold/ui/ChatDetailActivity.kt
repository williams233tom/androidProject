package com.example.smartold.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.example.smartold.R

class ChatDetailActivity : AppCompatActivity()  {
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.chatdetail_activity)

        // 处理Toolbar
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        // 返回按钮
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        // 标题（可选）
        supportActionBar?.title = ""
    }
}