package app.mediaapplication.presenter

import android.content.Context
import android.media.CamcorderProfile
import android.media.MediaRecorder
import android.os.Environment
import app.mediaapplication.model.AudioRecModel
import app.mediaapplication.view.AudioRecView
import app.mediaapplication.view.VideoRecView
import android.os.Environment.getExternalStorageDirectory
import android.view.Surface
import app.mediaapplication.model.VideoRecModel


/**
 * Created by CodingHome on 4/15/18.
 */
class VideoRecPresenter(val videoRecView: VideoRecView, val context: Context?) {

    private var recState = false
    private var mediaRecord = MediaRecorder()

    companion object {
        val AUDIO_REC_DIR_PATH = "/sdcard/videoRec/"
    }

    fun getVideoRecList() {
        val videoRecList = VideoRecModel.instance.getVideoRecList()
        videoRecView.onObtainData(videoRecList)
    }

    fun startRec(surface: Surface?) {
        if (recState) return
        mediaRecord = MediaRecorder()
        mediaRecord.setAudioSource(MediaRecorder.AudioSource.MIC)
        mediaRecord.setVideoSource(MediaRecorder.VideoSource.CAMERA)
        val profile = CamcorderProfile.get(CamcorderProfile.QUALITY_HIGH)
        mediaRecord.setProfile(profile)
        val path = AUDIO_REC_DIR_PATH + System.currentTimeMillis() + ".mp4"
        mediaRecord.setOutputFile(path)
        mediaRecord.setPreviewDisplay(surface)
        mediaRecord.prepare()
        mediaRecord.start()
        recState = true
        videoRecView.onStartRec()
    }

    fun stopRec() {
        if (!recState) return
        mediaRecord.stop()
        mediaRecord.release()
        recState = false
        videoRecView.onStopRec()
    }

    fun getRecState() = recState

}