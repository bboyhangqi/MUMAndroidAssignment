package app.mumandroidassignment.lesson5.bykotlin.question2.ui.adpter

import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import app.mumandroidassignment.R
import app.mumandroidassignment.lesson5.bykotlin.question2.bean.Product
import app.mumandroidassignment.lesson5.bykotlin.question2.extension.loadImageByGlide
import app.mumandroidassignment.lesson5.bykotlin.question2.ui.activity.DetailActivity
import kotlinx.android.synthetic.main.item_product.view.*
import java.util.*

/**
 * Created by CodingHome on 4/8/18.
 */
class ElectronicAdpter(var data: List<Product>) : RecyclerView.Adapter<ElectronicAdpter.ViewHolder>(), View.OnClickListener {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_product, parent, false)
        view.isClickable = true
        view.setOnClickListener(this)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.title.text = data[position].title
        holder.image.loadImageByGlide(data[position].imageUrl)

        holder.price.text = String.format("Price : $%f", data[position].price)
        holder.color.text = String.format("Color : %s", data[position].color)
        holder.itemView.tag = data[position]
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var title = itemView.tv_title
        var image = itemView.im_icon
        var price = itemView.tv_price
        var color = itemView.tv_color
    }

    override fun onClick(v: View?) {
        Log.d("zhq.debug", "onClick")
        val product = v?.tag as Product
        val intent = Intent(v.context, DetailActivity::class.java)
        intent.putExtra("product", product)
        v.context.startActivity(intent)
    }

}