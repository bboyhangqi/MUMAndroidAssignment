package app.mediaapplication.view

import app.mediaapplication.bean.AudioItem

interface AudioRecView {

    fun onStartRec()

    fun onStopRec()

    fun onObtainData(saudioRecs: List<AudioItem>?)

}