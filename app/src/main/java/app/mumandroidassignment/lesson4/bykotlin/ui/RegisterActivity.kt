package app.mumandroidassignment.lesson4.bykotlin.ui

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Toast
import app.mumandroidassignment.R
import app.mumandroidassignment.lesson4.bykotlin.presenter.RegisterPresenter
import kotlinx.android.synthetic.main.activity_create_account.*

class RegisterActivity : AppCompatActivity(), RegisterView {

    private var registerPresenter = RegisterPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_account)
    }

    fun createAccount(view: View) {
        var firstname = ed_first_name.text.toString()
        var lastname = ed_last_name.text.toString()
        var email = ed_emall.text.toString()
        var password = ed_password.text.toString()
        if (TextUtils.isEmpty(firstname) || TextUtils.isEmpty(lastname) || TextUtils.isEmpty(email) || TextUtils.isEmpty(password)) {
            Toast.makeText(this, "please fill out all forms", Toast.LENGTH_SHORT).show()
            return
        }
        registerPresenter.creatAccount(firstname, lastname, email, password)
    }

    override fun onRegistered(username: String, password: String) {
        var intent = Intent()
        intent.putExtra("username", username)
        intent.putExtra("password", password)
        setResult(Activity.RESULT_OK, intent)
        finish()
    }

}
