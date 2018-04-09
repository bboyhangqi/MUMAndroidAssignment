package app.mumandroidassignment.lesson5.bykotlin.question2.bean

import java.io.Serializable

/**
 * Created by CodingHome on 4/5/18.
 */
data class Product(var title: String, var price: Float, var color: String, var imageUrl: String, var itemid: String, var desc: String) : Serializable