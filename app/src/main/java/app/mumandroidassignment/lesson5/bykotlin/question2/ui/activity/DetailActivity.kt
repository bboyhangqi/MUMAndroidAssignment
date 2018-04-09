package app.mumandroidassignment.lesson5.bykotlin.question2.ui.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import app.mumandroidassignment.R
import app.mumandroidassignment.lesson5.bykotlin.question2.bean.Product
import app.mumandroidassignment.lesson5.bykotlin.question2.extension.loadImageByGlide
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        val product = intent.getSerializableExtra("product") as Product
        im_icon.loadImageByGlide(product.imageUrl)
        tv_title.text = product.title
        tv_color.text = String.format("Color : %s" + product.color)
        tv_id.text = String.format("Walmart : %s" + product.itemid)
        tv_description.text = product.desc
    }

}
