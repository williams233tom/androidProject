package com.example.smartold.ui

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.smartold.R
import com.example.smartold.ui.adapter.MsgAdapter
import com.example.smartold.util.Msg
import com.google.android.material.button.MaterialButton

class ChatDetailActivity : AppCompatActivity(), View.OnClickListener  {

    private val msgList = ArrayList<Msg>()
    private var adapter: MsgAdapter? = null

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

        //消息列表

        //初始化信息
        initMsg()
        val layoutManger = LinearLayoutManager(this)
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val send = findViewById<MaterialButton>(R.id.sendButton)

        recyclerView.layoutManager = layoutManger
        adapter = MsgAdapter(msgList)
        recyclerView.adapter = adapter
        send.setOnClickListener(this)

    }

    override fun onClick(v: View?){
        val send = findViewById<MaterialButton>(R.id.sendButton)
        when (v) {
            send -> {
                val inputText = findViewById<EditText>(R.id.inputText)
                val content = inputText.text.toString()
                val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
                if (content.isNotEmpty()) {
                    val msg = Msg(content, Msg.TYPE_SENT)
                    msgList.add(msg)
                    adapter?.notifyItemInserted(msgList.size - 1) // 当有新消息时，刷新RecyclerView中的显示
                    recyclerView.scrollToPosition(msgList.size - 1)  // 将RecyclerView 定位到最后一行
                    inputText.setText("") // 清空输入框中的内容
                }
            }
        }
    }

    private fun initMsg() {
        val msg1 = Msg("Hello guy.", Msg.TYPE_RECEIVED)
        msgList.add(msg1)
        val msg2 = Msg("Hello. Who is that?", Msg.TYPE_SENT)
        msgList.add(msg2)
        val msg3 = Msg("This is Tom. Nice talking to you. ", Msg.TYPE_RECEIVED)
        msgList.add(msg3)
    }
}