package app.mumandroidassignment.lesson6.byKotlin.question1


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import app.mumandroidassignment.R


/**
 * A simple [Fragment] subclass.
 */
class WorkFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_work, container, false)
    }

}
