package app.mumandroidassignment.lesson3

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import app.mumandroidassignment.R
import kotlinx.android.synthetic.main.activity_question2_by_kotlin.*
import java.util.*

class Question2ByKotlin : AppCompatActivity() {

    var foodList = mutableListOf("Hamburger", "Pizza", "Mexican", "American", "Chinese")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question2_by_kotlin)
    }

    fun addFood(view: View) {
        var addedFood = ed_add_food.text.toString()
        if(!addedFood.isEmpty()){
            foodList.add(0, addedFood)
            tv_dish_name.text = addedFood
            ed_add_food.text = null
        }
    }

    fun decide(view: View) {
        var index = Random().nextInt(foodList.size)
        tv_dish_name.text = foodList.get(index)
        ed_add_food.text = null
    }
}
