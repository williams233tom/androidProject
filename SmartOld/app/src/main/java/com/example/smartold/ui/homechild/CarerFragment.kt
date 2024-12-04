package com.example.smartold.ui.homechild

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.smartold.R
import com.example.smartold.ui.CareInfoActivity
import com.example.smartold.ui.CarersActivity
import com.google.android.material.button.MaterialButton

class CarerFragment : Fragment(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.carer_fragment,container,false)

        //拨号界面
        val button = view.findViewById<ImageView>(R.id.phoneButton)
        button.setOnClickListener{
            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse("tel:114514")
            startActivity(intent)
        }

        //当前关怀者
        val careLayout: LinearLayout = view.findViewById(R.id.careInfo)
        careLayout.setOnClickListener{
            val intent = Intent (context ,CareInfoActivity::class.java)
            startActivity(intent)
        }

        //全部关怀者
        val showAllCarers = view.findViewById<TextView>(R.id.showAllCarers)
        showAllCarers.setOnClickListener{
            val intent = Intent (context ,CarersActivity::class.java)
            startActivity(intent)
        }


        return view
    }


}