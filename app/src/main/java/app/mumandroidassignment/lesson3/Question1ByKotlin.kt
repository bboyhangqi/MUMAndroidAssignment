package app.mumandroidassignment.lesson3

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import app.mumandroidassignment.R
import kotlinx.android.synthetic.main.activity_question1_by_kotlin.*

class Question1ByKotlin : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question1_by_kotlin)
    }

    fun convert(view: View) {
        var lbs = ed_lbs.text.toString().toDouble()
        var kgs: String = (lbs * 0.454).toString()
        ed_kgs.setText(kgs)
    }


}
