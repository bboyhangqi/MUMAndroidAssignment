package app.mediaapplication.ui.activity

import android.Manifest
import android.content.pm.PackageManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.support.v4.app.FragmentTransaction
import android.support.v4.content.ContextCompat
import android.support.v7.app.ActionBar
import android.util.Log
import app.mediaapplication.R
import app.mediaapplication.ui.fragment.AudioRecFragment
import app.mediaapplication.ui.fragment.MusicFragment
import app.mediaapplication.ui.fragment.VideoFragment
import app.mediaapplication.ui.fragment.VideoRecFragment

class MainActivity : AppCompatActivity(), ActionBar.TabListener {

    private val musicFragment by lazy { MusicFragment() }
    private val videoFragment by lazy { VideoFragment() }
    private val audioRecFragment by lazy { AudioRecFragment() }
    private val videoRecFragment by lazy { VideoRecFragment() }


    private val REQUEST_MICROPHONE = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
        checkPermission()
    }

    private fun init() {
        supportActionBar?.navigationMode = ActionBar.NAVIGATION_MODE_TABS
        supportActionBar?.setDisplayShowTitleEnabled(true)
        supportActionBar?.addTab(supportActionBar?.newTab()?.setText("Music")?.setTabListener(this))
        supportActionBar?.addTab(supportActionBar?.newTab()?.setText("Video")?.setTabListener(this))
        supportActionBar?.addTab(supportActionBar?.newTab()?.setText("Audio Rec")?.setTabListener(this))
        supportActionBar?.addTab(supportActionBar?.newTab()?.setText("Video Rec")?.setTabListener(this))
    }

    private fun checkPermission() {
        var permissionList = arrayOf(Manifest.permission.RECORD_AUDIO,
                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.CAMERA)
        var ret = permissionList.filter { ContextCompat.checkSelfPermission(this, it) != PackageManager.PERMISSION_GRANTED }
        if (ret.size > 0) {
            ActivityCompat.requestPermissions(this, permissionList, REQUEST_MICROPHONE)
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        if (requestCode == REQUEST_MICROPHONE) {
            permissions.forEach { Log.d("zhq.debug  permissions", it) }
            grantResults.forEach { Log.d("zhq.debug  grantResults", it.toString()) }
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }

    override fun onTabReselected(tab: ActionBar.Tab?, ft: FragmentTransaction?) {
    }

    override fun onTabUnselected(tab: ActionBar.Tab?, ft: FragmentTransaction?) {
    }

    override fun onTabSelected(tab: ActionBar.Tab?, ft: FragmentTransaction?) {
        Log.d("zhq.debug", "onTabSelected ${tab?.text}")
        when (tab?.text) {
            "Music" -> supportFragmentManager.beginTransaction().replace(R.id.root, musicFragment).commit()
            "Video" -> supportFragmentManager.beginTransaction().replace(R.id.root, videoFragment).commit()
            "Audio Rec" -> supportFragmentManager.beginTransaction().replace(R.id.root, audioRecFragment).commit()
            "Video Rec" -> supportFragmentManager.beginTransaction().replace(R.id.root, videoRecFragment).commit()
        }
    }


}
