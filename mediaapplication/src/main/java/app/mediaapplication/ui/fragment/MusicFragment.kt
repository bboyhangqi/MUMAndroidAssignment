package app.mediaapplication.ui.fragment


import android.media.MediaPlayer
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

import app.mediaapplication.R
import kotlinx.android.synthetic.main.fragment_music.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class MusicFragment : Fragment() {
    private lateinit var mp : MediaPlayer

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment

        val view: View = inflater!!.inflate(R.layout.fragment_music, container, false)

        mp = MediaPlayer.create (getActivity(), R.raw.music)
        var position = 0


        val playBTN = view.findViewById<Button>(R.id.playBTN)
        playBTN.setOnClickListener {
            mp.start()
        }

        val pauseBTN = view.findViewById<Button>(R.id.pauseBTN)
        pauseBTN.setOnClickListener {
            if (mp.isPlaying ()) {
                position = mp.getCurrentPosition ()
                mp.pause ()
            }
        }

        val contBTN = view.findViewById<Button>(R.id.contBNT)
        contBTN.setOnClickListener {
            if (mp.isPlaying () == false) {
                mp.seekTo (position)
                mp.start ()
            }
        }

        val stopBTN = view.findViewById<Button>(R.id.stopBTN)
        stopBTN.setOnClickListener {
            mp.pause ()
            position = 0
            mp.seekTo (0)
        }

        return view
    }

    override fun onDestroy () {
        super.onDestroy ()
        mp.release ()
    }
}
