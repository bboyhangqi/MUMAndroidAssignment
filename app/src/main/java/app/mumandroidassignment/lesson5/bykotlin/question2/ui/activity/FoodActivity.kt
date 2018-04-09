package app.mumandroidassignment.lesson5.bykotlin.question2.ui.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import app.mumandroidassignment.R
import app.mumandroidassignment.lesson5.bykotlin.question2.presenter.FoodPresenter
import app.mumandroidassignment.lesson5.bykotlin.question2.ui.adpter.SimpleFoodAdpter
import app.mumandroidassignment.lesson5.bykotlin.question2.view.FoodView
import kotlinx.android.synthetic.main.activity_food.*
import kotlinx.android.synthetic.main.item_food.view.*

class FoodActivity : AppCompatActivity(), FoodView {

    private val foodPresenter by lazy { FoodPresenter(this, this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_food)
        rv_foods.layoutManager = LinearLayoutManager(this)
        foodPresenter.requestFoodList()
    }

    override fun addFoodList(foodList: List<String>) {
        var simpleFoodAdpter = SimpleFoodAdpter(foodList)
        rv_foods.adapter = simpleFoodAdpter
    }



}
