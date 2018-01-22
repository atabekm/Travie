package com.example.travie.presentation.ui.recent

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.travie.R
import kotlinx.android.synthetic.main.fragment_other.*

/**
 * Created by atabek on 01/22/2018.
 */

class OtherFragment: Fragment() {
    private var titleResId = -1

    companion object {
        const val TITLE = "title"

        fun getInstance(resId: Int): OtherFragment {
            val fragment = OtherFragment()
            val args = Bundle()
            args.putInt(TITLE, resId)
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val args = arguments
        titleResId = args.getInt(TITLE)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.fragment_other, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        otherTitle.setText(titleResId)
    }

}