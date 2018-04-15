package app.mediaapplication.ui.fragment


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import app.mediaapplication.R
import app.mediaapplication.ui.adpter.AudioItemAdpter
import app.mediaapplication.bean.AudioItem
import app.mediaapplication.presenter.AudioRecPresenter
import app.mediaapplication.view.AudioRecView
import kotlinx.android.synthetic.main.fragment_audio_rec.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class AudioRecFragment : Fragment(), AudioRecView, View.OnClickListener {

    private val audioRecPresenter by lazy { AudioRecPresenter(this, this.context) }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_audio_rec, container, false)
    }

    override fun onStart() {
        super.onStart()
        init()
    }

    override fun onClick(v: View?) {
        if (!audioRecPresenter.getRecState()) startRec() else stopRec()
    }

    private fun init() {
        iv_start_rec.setOnClickListener(this)
        rv.layoutManager = LinearLayoutManager(this.context)
        audioRecPresenter.getAudioRecList()
    }


    private fun startRec() {
        audioRecPresenter.startRec()
    }

    private fun stopRec() {
        audioRecPresenter.stopRec()
    }

    private fun loadAudioList(audioRecs: List<AudioItem>) {
        var audioItemApter = AudioItemAdpter(audioRecs)
        rv.adapter = audioItemApter
    }

    override fun onStartRec() {
        iv_start_rec.setBackgroundResource(R.mipmap.stop)
    }

    override fun onStopRec() {
        iv_start_rec.setBackgroundResource(R.mipmap.play)
        audioRecPresenter.getAudioRecList()
    }

    override fun onObtainData(audioRecs: List<AudioItem>?) {
        audioRecs ?: return
        loadAudioList(audioRecs)
    }


}
