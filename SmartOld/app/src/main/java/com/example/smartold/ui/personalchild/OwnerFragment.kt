package com.example.smartold.ui.personalchild

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.smartold.R
import com.google.android.material.button.MaterialButton

class OwnerFragment :Fragment(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.owner_fragment,container,false)

        //拨号界面
        val button = view.findViewById<MaterialButton>(R.id.connectButton)
        button.setOnClickListener{
            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse("tel:114514")
            startActivity(intent)
        }

        return view
    }
}