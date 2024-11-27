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
import com.example.smartold.ui.homechild.CarerFragment
import com.example.smartold.ui.homechild.FunctionFragment
import com.example.smartold.ui.personalchild.HospitalFragment
import com.example.smartold.ui.personalchild.OwnerFragment

class PersonalFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        //使用 inflater 创建 view
        val view = inflater.inflate(R.layout.personal_fragment, container, false)

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

        // 加载OwnerFragment
        val ownerFragment = OwnerFragment()
        val ownerTransaction = childFragmentManager.beginTransaction()
        ownerTransaction.replace(R.id.owner_fragment_container,ownerFragment)
        ownerTransaction.commit()

        // 加载hospitalFragment
        val hospitalFragment = HospitalFragment()
        val hospitalTransaction = childFragmentManager.beginTransaction()
        hospitalTransaction.replace(R.id.hospital_fragment_container,hospitalFragment)
        hospitalTransaction.commit()

        // 返回view
        return view
    }
}