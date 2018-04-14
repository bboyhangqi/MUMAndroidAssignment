package app.mediaapplication.presenter

import android.content.Context
import android.media.MediaRecorder
import android.util.Log
import app.mediaapplication.model.AudioRecModel
import app.mediaapplication.view.AudioRecView

class AudioRecPresenter(val audioRecView: AudioRecView, val context: Context?) {

    private var recState = false
    private var mediaRecord = MediaRecorder()

    companion object {
        val AUDIO_REC_DIR_PATH = "/sdcard/audioRec/"
    }

    fun getAudioRecList() {
        val audioRecList = AudioRecModel.instance.getAudioRecList()
        audioRecView.onObtainData(audioRecList)
    }

    fun startRec() {
        if (recState) return
        val path = AUDIO_REC_DIR_PATH + System.currentTimeMillis() + ".amr"
        mediaRecord = MediaRecorder()
        mediaRecord.setAudioSource(MediaRecorder.AudioSource.MIC)
        mediaRecord.setOutputFormat(MediaRecorder.OutputFormat.AMR_NB)
        mediaRecord.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB)
        mediaRecord.setOutputFile(path)
        mediaRecord.prepare()
        mediaRecord.start()
        recState = true
        audioRecView.onStartRec()
    }

    fun stopRec() {
        if (!recState) return
        mediaRecord.stop()
        mediaRecord.release()
        recState = false
        audioRecView.onStopRec()
    }

    fun getRecState() = recState

}