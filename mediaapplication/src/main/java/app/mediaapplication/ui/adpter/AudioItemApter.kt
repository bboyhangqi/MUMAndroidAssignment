package app.mediaapplication.ui.adpter

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import app.mediaapplication.R
import app.mediaapplication.bean.AudioItem
import kotlinx.android.synthetic.main.audio_item.view.*
import java.text.SimpleDateFormat



class AudioItemApter(var data: List<AudioItem>) : RecyclerView.Adapter<AudioItemApter.ViewHold>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHold {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.audio_item, parent, false)
        return ViewHold(view)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ViewHold, position: Int) {
        holder.icon.setImageResource(R.mipmap.icon)
        holder.title.text = data[position].name
        holder.duration.text = getDurationStr(data[position].duration)
        holder.audioItem = data[position]
    }


    private fun getDurationStr(duration: String?): String {
        return SimpleDateFormat("mm:ss").format(duration?.toLong())
    }


    class ViewHold(itemView: View) : RecyclerView.ViewHolder(itemView) {
        init {
            var rootView = itemView.findViewById<View>(R.id.ll_root)
            rootView.setOnClickListener { play(rootView.context) }
        }

        @SuppressLint("NewApi")
        private fun play(context: Context) {
//            val intent = Intent()
//            intent.action = android.content.Intent.ACTION_VIEW
//            intent.setDataAndType(Uri.parse(audioItem?.path), "audio/*")
//            context.startActivity(intent)
        }

        var audioItem: AudioItem? = null
        var icon = itemView.iv_icon
        var title = itemView.tv_title
        var duration = itemView.tv_duration
    }
}