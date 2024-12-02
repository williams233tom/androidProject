package com.example.smartold.util

class Msg (val content:String, val type:Int){
    //content消息内容，type消息类型
    companion object{
        const val TYPE_RECEIVED = 0
        const val  TYPE_SENT = 1
    }
}