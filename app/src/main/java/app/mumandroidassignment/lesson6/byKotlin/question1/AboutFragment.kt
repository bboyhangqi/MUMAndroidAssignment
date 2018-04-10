package app.mumandroidassignment.lesson6.byKotlin.question1


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

import app.mumandroidassignment.R


/**
 * A simple [Fragment] subclass.
 * Use the [AboutFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AboutFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_about, container, false)
    }


}
