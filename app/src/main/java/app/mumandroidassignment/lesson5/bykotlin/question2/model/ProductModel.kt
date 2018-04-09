package app.mumandroidassignment.lesson5.bykotlin.question2.model

import android.content.Context
import app.mumandroidassignment.R
import app.mumandroidassignment.lesson5.bykotlin.question2.bean.Product

/**
 * Created by CodingHome on 4/5/18.
 */
class ProductModel private constructor() {

    private object HOLDER {
        var INSTANCE = ProductModel()
    }

    companion object {
        val instance: ProductModel by lazy { HOLDER.INSTANCE }
    }

    fun getMoives(context: Context): List<String> {
        return context.resources.getStringArray(R.array.moives).toList()
    }

    fun getBeautyGoods(context: Context): List<String> {
        return context.resources.getStringArray(R.array.beauty).toList()
    }

    fun getClothingGoods(context: Context): Array<String> {
        return context.resources.getStringArray(R.array.clothing)
    }

    fun getFoodGoods(context: Context): List<String> {
        return context.resources.getStringArray(R.array.food).toList()
    }

    fun getElectronicGoods(): List<Product> {
        var list = mutableListOf<Product>()
        list.add(Product("RGA Voyager 7 16GB Android Tablet", 35.0f, "Black", "http://www.pcmuseum.ca/gallery/0610-02-750.JPG", "555948101",
                "Introducing the RGA Voyager 7-inch Google Certified Table"))
        list.add(Product("HP Flyer Red 15.6 Latop", 299.0f, "Black & Red", "https://ssl-product-images.www8-hp.com/digmedialib/prodimg/lowres/c05474585.png", "555948102",
                "Introducing the HP Flyer Red 1298.6-inch Laptop"))
        list.add(Product("VIZIO 70 Class 4K", 35.0f, "Black", "https://pisces.bbystatic.com/image2/BestBuy_US/images/products/5947/5947110_sd.jpg", "555948103",
                "Introducing the VIZIO 70 Class 4K TV"))
        list.add(Product("Epson WorkForce WF-2750", 69.0f, "Black", "https://assets.pcmag.com/media/images/472712-epson-expression-et-2750-ecotank-all-in-one-supertank-printer.jpg", "555948104",
                "Introducing the Epson WorkForce WF-2750 Printer"))
        return list
    }

}