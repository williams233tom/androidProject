package com.example.smartold.ui.homechild

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import com.example.smartold.R
import com.example.smartold.ui.CareInfoActivity

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

        val careLayout: LinearLayout = view.findViewById(R.id.careInfo)
        careLayout.setOnClickListener{
            val intent = Intent (context ,CareInfoActivity::class.java)
            startActivity(intent)

        }

        return view
    }


}