package app.mumandroidassignment.lesson4.bykotlin.presenter

import app.mumandroidassignment.lesson4.bykotlin.bean.User
import app.mumandroidassignment.lesson4.bykotlin.model.AccountModel
import app.mumandroidassignment.lesson4.bykotlin.ui.RegisterView

/**
 * Created by CodingHome on 4/4/18.
 */
class RegisterPresenter(var registerView: RegisterView) {

    fun creatAccount(firstname: String, lastname: String, email: String, password: String) {
        AccountModel.instance.addUser(User(email, password, firstname, lastname))
        registerView.onRegistered(email, password)
    }
}