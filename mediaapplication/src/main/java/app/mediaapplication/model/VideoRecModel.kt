package app.mediaapplication.model

import app.mediaapplication.bean.AudioItem
import app.mediaapplication.bean.VideoItem
import app.mediaapplication.helper.MediaHelper
import app.mediaapplication.presenter.AudioRecPresenter
import app.mediaapplication.presenter.VideoRecPresenter
import java.io.File

/**
 * Created by CodingHome on 4/15/18.
 */
class VideoRecModel {

    private object HOLDER {
        var INSTANCE = VideoRecModel()
    }

    companion object {
        val instance by lazy { HOLDER.INSTANCE }
    }

    fun getVideoRecList(): List<VideoItem>? {
        val file = File(VideoRecPresenter.AUDIO_REC_DIR_PATH)
        if (!file.exists()) file.mkdir()
        val fileList = file.listFiles({ dir, name -> name.endsWith(".mp4") })
        return if (fileList != null && fileList.isNotEmpty())
            fileList.map { VideoItem(it.absolutePath, it.name, MediaHelper.getDuration(it)) }.filter { it.duration != null }
        else
            null
    }
}