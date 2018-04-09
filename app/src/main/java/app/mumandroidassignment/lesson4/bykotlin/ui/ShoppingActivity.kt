package app.mumandroidassignment.lesson4.bykotlin.ui

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import app.mumandroidassignment.R
import app.mumandroidassignment.lesson5.bykotlin.question2.ui.activity.BeautyActivity
import app.mumandroidassignment.lesson5.bykotlin.question2.ui.activity.ClothingActivity
import app.mumandroidassignment.lesson5.bykotlin.question2.ui.activity.ElectronicActivity
import app.mumandroidassignment.lesson5.bykotlin.question2.ui.activity.FoodActivity
import kotlinx.android.synthetic.main.activity_shopping.*

class ShoppingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shopping)
        var username = intent.getStringExtra("username")
        tv_account.setText("welcome " + username)
    }

    fun onCategoryClick(view: View) {
        var id = view.id
        when (id) {
            R.id.beauty -> startActivity(Intent(this, BeautyActivity::class.java))
            R.id.clothing -> startActivity(Intent(this, ClothingActivity::class.java))
            R.id.electronics -> startActivity(Intent(this, ElectronicActivity::class.java))
            R.id.food -> startActivity(Intent(this, FoodActivity::class.java))
        }
    }

}
