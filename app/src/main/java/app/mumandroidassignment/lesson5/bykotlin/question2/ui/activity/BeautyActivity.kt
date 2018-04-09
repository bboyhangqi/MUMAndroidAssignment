package app.mumandroidassignment.lesson5.bykotlin.question2.ui.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.Toast
import app.mumandroidassignment.R
import app.mumandroidassignment.lesson5.bykotlin.question2.view.BeautyView
import kotlinx.android.synthetic.main.activity_beauty.*

class BeautyActivity : AppCompatActivity(), BeautyView, AdapterView.OnItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_beauty)
        spinner.onItemSelectedListener = this
    }

    override fun addBeautyList(beautyList: List<String>) {
        //reserve for fetching data from Model, for this case it is useless
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        Toast.makeText(this, "Item seleted is: ${parent?.getItemAtPosition(position)}", Toast.LENGTH_SHORT).show()
    }
}
