package com.example.smartold.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.FragmentTransaction
import com.example.smartold.R
import com.example.smartold.ui.careinfochild.HeadFragment
import com.example.smartold.ui.careinfochild.HealthDataFragment
import com.example.smartold.ui.careinfochild.TimeMessageFragment

class CareInfoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.careinfo_activity)

        // 处理Toolbar
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        // 返回按钮
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        // 标题（可选）
        supportActionBar?.title = ""

        // 加载HeadFragment
        val headFragment = HeadFragment()
        val headTransaction: FragmentTransaction = supportFragmentManager.beginTransaction()
        headTransaction.replace(R.id.head_fragment_container, headFragment)
        headTransaction.commit()

        // 加载HealthDataFragment
        val healthDataFragment = HealthDataFragment()
        val healthDataTransaction: FragmentTransaction = supportFragmentManager.beginTransaction()
        healthDataTransaction.replace(R.id.healthData_fragment_container, healthDataFragment)
        healthDataTransaction.commit()

        // 加载TimeMessageFragment
        val timeMessageFragment = TimeMessageFragment()
        val timeMessageTransaction: FragmentTransaction = supportFragmentManager.beginTransaction()
        timeMessageTransaction.replace(R.id.timeMessage_fragment_container, timeMessageFragment)
        timeMessageTransaction.commit()
    }
}