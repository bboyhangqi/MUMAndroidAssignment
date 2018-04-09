package app.mumandroidassignment.lesson5.bykotlin.question2.ui.adpter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import app.mumandroidassignment.R
import kotlinx.android.synthetic.main.item_food.view.*

/**
 * Created by CodingHome on 4/6/18.
 */
class SimpleFoodAdpter(var data: List<String>) : RecyclerView.Adapter<SimpleFoodAdpter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_food, parent, false)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.title.text = data[position]
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var icon = itemView.im_icon
        var title = itemView.tv_title
    }
}