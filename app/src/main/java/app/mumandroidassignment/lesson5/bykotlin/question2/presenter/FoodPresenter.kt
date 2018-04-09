package app.mumandroidassignment.lesson5.bykotlin.question2.presenter

import android.content.Context
import app.mumandroidassignment.lesson5.bykotlin.question2.bean.Product
import app.mumandroidassignment.lesson5.bykotlin.question2.model.ProductModel
import app.mumandroidassignment.lesson5.bykotlin.question2.view.FoodView

/**
 * Created by CodingHome on 4/5/18.
 */
class FoodPresenter(var context: Context, var foodView: FoodView) {

    private var productModel = ProductModel.instance

    fun requestFoodList() {
        var foodList = productModel.getFoodGoods(context)
        foodView.addFoodList(foodList)
    }


}