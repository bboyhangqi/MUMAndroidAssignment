package app.mediaapplication.ui.fragment


import android.content.ContentValues.TAG
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.SurfaceHolder
import android.view.View
import android.view.ViewGroup

import app.mediaapplication.R
import app.mediaapplication.bean.AudioItem
import app.mediaapplication.bean.VideoItem
import app.mediaapplication.presenter.VideoRecPresenter
import app.mediaapplication.ui.adpter.AudioItemAdpter
import app.mediaapplication.ui.adpter.VideoItemAdpter
import app.mediaapplication.view.VideoRecView
import kotlinx.android.synthetic.main.fragment_video_rec.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class VideoRecFragment : Fragment(), VideoRecView, View.OnClickListener, SurfaceHolder.Callback {

    private val videoRecPresenter by lazy { VideoRecPresenter(this, context) }
    private var surfaceHolder: SurfaceHolder? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_video_rec, container, false)
    }

    override fun onStart() {
        super.onStart()
        init()
    }

    fun init() {
        iv_start_rec.setOnClickListener(this)
        rv.layoutManager = LinearLayoutManager(this.context)
        videoRecPresenter.getVideoRecList()
        surfaceHolder = sv.holder
        surfaceHolder?.addCallback(this)
    }

    override fun onClick(v: View?) {
        if (!videoRecPresenter.getRecState()) startRec() else stopRec()
    }

    private fun startRec() {
        Log.d(TAG, "..startRec.....")
        sv.visibility = View.VISIBLE
        rv.visibility = View.INVISIBLE
    }

    private fun stopRec() {
        Log.d(TAG, "..stopRec.....")
        sv.visibility = View.INVISIBLE
        videoRecPresenter.stopRec()
    }

    private fun loadAudioList(videoRecs: List<VideoItem>) {
        var videoItemApter = VideoItemAdpter(videoRecs)
        rv.adapter = videoItemApter
        rv.visibility = View.VISIBLE
    }

    override fun onStartRec() {
        iv_start_rec.setBackgroundResource(R.mipmap.stop)
    }

    override fun onStopRec() {
        sv.visibility = View.INVISIBLE
        iv_start_rec.setBackgroundResource(R.mipmap.play)
        videoRecPresenter.getVideoRecList()

    }

    override fun onObtainData(videoRecs: List<VideoItem>?) {
        videoRecs ?: return
        loadAudioList(videoRecs)
    }

    override fun surfaceChanged(holder: SurfaceHolder?, format: Int, width: Int, height: Int) {
        Log.d("zhq.debug", "surfaceChanged")
        videoRecPresenter.startRec(surfaceHolder?.surface)
    }

    override fun surfaceDestroyed(holder: SurfaceHolder?) {
        Log.d("zhq.debug", "surfaceDestroyed")
    }

    override fun surfaceCreated(holder: SurfaceHolder?) {
        Log.d("zhq.debug", "surfaceCreated")
    }

}
