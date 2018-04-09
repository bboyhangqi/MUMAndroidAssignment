package app.mumandroidassignment.lesson5.bykotlin.question2.presenter

import android.content.Context
import app.mumandroidassignment.lesson5.bykotlin.question2.model.ProductModel
import app.mumandroidassignment.lesson5.bykotlin.question2.view.BeautyView

/**
 * Created by CodingHome on 4/5/18.
 */
class BeautyPresenter(var context: Context, var beautyView: BeautyView) {

    private var productModel = ProductModel.instance

    fun requsetBeautyList() {
        var beautyList = productModel.getBeautyGoods(context)
        beautyView.addBeautyList(beautyList)
    }

}