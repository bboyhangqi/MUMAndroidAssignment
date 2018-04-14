package app.mediaapplication.model

import app.mediaapplication.bean.AudioItem
import app.mediaapplication.helper.MediaHelper
import app.mediaapplication.presenter.AudioRecPresenter
import java.io.File

class AudioRecModel {


    private object HOLDER {
        var INSTANCE = AudioRecModel()
    }

    companion object {
        val instance by lazy { HOLDER.INSTANCE }
    }

    fun getAudioRecList(): List<AudioItem>? {
        val file = File(AudioRecPresenter.AUDIO_REC_DIR_PATH)
        if (!file.exists()) file.mkdir()
        val fileList = file.listFiles({ dir, name -> name.endsWith(".amr") })
        return if (fileList != null && fileList.isNotEmpty())
            fileList.map { AudioItem(it.absolutePath, it.name, MediaHelper.getDuration(it)) }.filter { it.duration != null }
        else
            null
    }
}