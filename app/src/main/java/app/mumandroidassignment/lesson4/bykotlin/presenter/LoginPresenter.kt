package app.mumandroidassignment.lesson4.bykotlin.presenter

import app.mumandroidassignment.lesson4.bykotlin.model.AccountModel
import app.mumandroidassignment.lesson4.bykotlin.view.LoginView

/**
 * Created by CodingHome on 4/4/18.
 */
class LoginPresenter(var loginView: LoginView) {

    fun login(username: String, password: String) {
        var userList = AccountModel.instance.getUserList()
        var isVerify = userList.filter { it.username.equals(username) && it.password.equals(password) }
                .count() >= 1
        loginView.loginResult(isVerify)
    }

}