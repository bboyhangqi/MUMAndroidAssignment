package app.mumandroidassignment.lesson4.bykotlin.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import app.mumandroidassignment.R
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
            R.id.beauty -> Toast.makeText(this,
                    "You have chosen the Beauty category of shopping",
                    Toast.LENGTH_SHORT).show()
            R.id.clothing -> Toast.makeText(this,
                    "You have chosen the Clothing category of shopping",
                    Toast.LENGTH_SHORT).show()
            R.id.electronics -> Toast.makeText(this,
                    "You have chosen the Electronics category of shopping",
                    Toast.LENGTH_SHORT).show()
            R.id.food -> Toast.makeText(this,
                    "You have chosen the Food category of shopping",
                    Toast.LENGTH_SHORT).show()
        }
    }

}
