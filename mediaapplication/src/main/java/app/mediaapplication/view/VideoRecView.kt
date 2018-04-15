package app.mediaapplication.view

import app.mediaapplication.bean.AudioItem
import app.mediaapplication.bean.VideoItem

/**
 * Created by CodingHome on 4/15/18.
 */
interface VideoRecView {

    fun onStartRec()

    fun onStopRec()

    fun onObtainData(videoRecs: List<VideoItem>?)
}