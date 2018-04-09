package app.mumandroidassignment.lesson5.bykotlin.question2.ui.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import app.mumandroidassignment.R
import app.mumandroidassignment.lesson5.bykotlin.question2.presenter.ClothingPresenter
import app.mumandroidassignment.lesson5.bykotlin.question2.view.ClothingView
import kotlinx.android.synthetic.main.activity_clothing.*

class ClothingActivity : AppCompatActivity(), ClothingView {

    private val clothingPresenter by lazy {
        ClothingPresenter(this, this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_clothing)
        clothingPresenter.requestClothingList()
        lv_clothing.setOnItemClickListener { parent, view, position, id ->
            Toast.makeText(this,"select item: "+parent.getItemAtPosition(position),Toast.LENGTH_SHORT).show()
        }
    }

    override fun addClothingList(clothingList: Array<String>) {
        var arrayAdapt = ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, clothingList)
        lv_clothing.adapter = arrayAdapt
    }

}
