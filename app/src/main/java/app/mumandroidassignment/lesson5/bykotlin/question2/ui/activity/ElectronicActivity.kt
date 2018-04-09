package app.mumandroidassignment.lesson5.bykotlin.question2.ui.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import app.mumandroidassignment.R
import app.mumandroidassignment.lesson5.bykotlin.question2.bean.Product
import app.mumandroidassignment.lesson5.bykotlin.question2.presenter.ElectronicPresenter
import app.mumandroidassignment.lesson5.bykotlin.question2.ui.adpter.ElectronicAdpter
import app.mumandroidassignment.lesson5.bykotlin.question2.view.ElectronicView
import kotlinx.android.synthetic.main.activity_electronic.*

class ElectronicActivity : AppCompatActivity(), ElectronicView {

    private val electronicPresenter by lazy { ElectronicPresenter(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_electronic)
        rv_products.layoutManager = LinearLayoutManager(this)
    }

    override fun onStart() {
        super.onStart()
        electronicPresenter.requestElectronicProducts()
    }

    override fun addElectronicProducts(products: List<Product>) {
        val adpter = ElectronicAdpter(products)
        rv_products.adapter = adpter
    }


}
