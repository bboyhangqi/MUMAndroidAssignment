package app.mumandroidassignment.lesson5.bykotlin.question2.extension

import android.widget.ImageView
import com.bumptech.glide.Glide

/**
 * Created by CodingHome on 4/8/18.
 */
fun ImageView.loadImageByGlide(url: String) {
    Glide.with(this.context)
            .asBitmap()
            .load(url)
            .into(this)
}