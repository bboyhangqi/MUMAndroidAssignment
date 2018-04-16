package app.mediaapplication.ui.fragment


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.MediaController
import android.widget.VideoView

import app.mediaapplication.R
import kotlinx.android.synthetic.main.fragment_video.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class VideoFragment : Fragment() {
    private var mediaController: MediaController? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view: View = inflater!!.inflate(R.layout.fragment_video, container, false)

        val videoView = view.findViewById<VideoView>(R.id.videoView)

        configureVideoView(videoView)

        return view
    }

    private fun configureVideoView(videoView: VideoView) {

        videoView.setVideoPath(
                "http://techslides.com/demos/sample-videos/small.mp4")

        mediaController = MediaController(getActivity())
        mediaController?.setAnchorView(videoView)
        videoView.setMediaController(mediaController)
        videoView.start()
    }


}
