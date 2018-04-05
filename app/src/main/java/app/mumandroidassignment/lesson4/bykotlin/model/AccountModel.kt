package app.mumandroidassignment.lesson4.bykotlin.model

import app.mumandroidassignment.lesson4.bykotlin.bean.User

/**
 * Created by CodingHome on 4/4/18.
 */
class AccountModel {

    object instance {
        private val users = mutableListOf<User>()

        fun getUserList(): List<User> {
            users.forEach { println(it.toString()) }
            return users
        }

        fun addUser(user: User) {
            users.add(0, user)
        }

        init {
            users.add(User("ZMM1@gmail.com", "12345678"))
            users.add(User("ZMM2@gmail.com", "12345678"))
            users.add(User("ZMM3@gmail.com", "12345678"))
            users.add(User("ZMM4@gmail.com", "12345678"))
            users.add(User("ZMM5@gmail.com", "12345678"))
            users.add(User("ZMM6@gmail.com", "12345678"))
        }
    }

}