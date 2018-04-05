package app.mumandroidassignment.lesson4.bykotlin.ui

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Toast
import app.mumandroidassignment.R
import app.mumandroidassignment.lesson4.bykotlin.presenter.LoginPresenter
import kotlinx.android.synthetic.main.activity_walmart_login.*

class LoginActivity : AppCompatActivity(), LoginView {

    private var loginPresenter = LoginPresenter(this)
    private val REQUEST_CODE = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_walmart_login)
    }

    override fun loginResult(result: Boolean) {
        var username = ed_username.text.toString()
        if (result) {
            var intent = Intent(this, ShoppingActivity::class.java)
            intent.putExtra("username", username)
            startActivity(intent)
        } else {
            Toast.makeText(this, "username or password illegal", Toast.LENGTH_SHORT).show()
        }
    }

    fun goToCreateAccount(view: View) {
        var intent = Intent(this, RegisterActivity::class.java)
        startActivityForResult(intent, REQUEST_CODE)
    }

    fun login(view: View) {
        var username = ed_username.text.toString()
        var password = ed_password.text.toString()
        if (TextUtils.isEmpty(username) || TextUtils.isEmpty(password)) {
            Toast.makeText(this, "please fill out all forms", Toast.LENGTH_SHORT).show()
            return
        } else {
            loginPresenter.login(username = username, password = password)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_CODE) {
            if (resultCode == Activity.RESULT_OK) {
                var username = data?.getStringExtra("username")
                var password = data?.getStringExtra("password")
                ed_username.setText(username)
                ed_password.setText(password)
            }
        }
    }

}
