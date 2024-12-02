package com.example.smartold.ui.homechild

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import com.example.smartold.R

class FunctionFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    //  创建接口
    interface OnFunctionClickListener {
        fun onFunctionClick(types:Int)
    }

    private var listener: OnFunctionClickListener? = null

    fun setOnFunctionClickListener(listener: OnFunctionClickListener) {
        this.listener = listener
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.function_fragment,container,false)

        //  创建Listener
        val functionNavigationMapping = view.findViewById<ConstraintLayout>(R.id.function_navigationMapping)
        functionNavigationMapping.setOnClickListener {
            listener?.onFunctionClick(0)
        }
        val functionChatReact = view.findViewById<ConstraintLayout>(R.id.function_chatReact)
        functionChatReact.setOnClickListener {
            listener?.onFunctionClick(1)
        }
        val functionHealthManager = view.findViewById<ConstraintLayout>(R.id.function_healthManager)
        functionHealthManager.setOnClickListener {
            listener?.onFunctionClick(2)
        }


        return view
    }
}