package app.mumandroidassignment.lesson5.bykotlin.question2.presenter

import android.content.Context
import app.mumandroidassignment.lesson5.bykotlin.question2.model.ProductModel
import app.mumandroidassignment.lesson5.bykotlin.question2.view.ClothingView

/**
 * Created by CodingHome on 4/5/18.
 */
class ClothingPresenter(var context: Context, var clothingView: ClothingView) {

    private var productModel = ProductModel.instance

    fun requestClothingList() {
        var clothingList = productModel.getClothingGoods(context)
        clothingView.addClothingList(clothingList)
    }
}