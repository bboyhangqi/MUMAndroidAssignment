package app.mumandroidassignment.lesson5.bykotlin.question2.presenter

import android.content.Context
import app.mumandroidassignment.lesson5.bykotlin.question2.model.ProductModel
import app.mumandroidassignment.lesson5.bykotlin.question2.view.ElectronicView

/**
 * Created by CodingHome on 4/5/18.
 */
class ElectronicPresenter(var electronicView: ElectronicView) {

    private var productModel = ProductModel.instance

    fun requestElectronicProducts() {
        var products = productModel.getElectronicGoods()
        electronicView.addElectronicProducts(products)
    }


}