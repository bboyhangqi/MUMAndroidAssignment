package app.mediaapplication.ui.fragment


import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.support.v4.app.Fragment
import android.support.v4.content.FileProvider
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast

import app.mediaapplication.R
import kotlinx.android.synthetic.main.fragment_camera_gallery.*
import java.io.File
import java.io.IOException
import java.text.SimpleDateFormat
import java.util.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class CameraGalleryFragment : Fragment() {

    lateinit var imageFilePath: String

    companion object {
        val CAMERA_REQUEST_CODE = 1
        val REQUSET_SELECT_PIC = 2
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_camera_gallery, container, false)
    }

    override fun onStart() {
        super.onStart()
        iv_camera.setOnClickListener { openCamera() }
        iv_grally.setOnClickListener { goToGrally() }
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == CAMERA_REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            iv.setImageBitmap(setScaleBitmap())
        } else if (requestCode == REQUSET_SELECT_PIC && resultCode == Activity.RESULT_OK) {
            iv.setImageURI(data?.data)
        }
    }

    private fun openCamera() {
        try {
            val imageFile = createImageFile()
            val callIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            if (callIntent.resolveActivity(activity?.packageManager) != null) {
                val authorities = activity?.packageName + ".fileprovider"
                val imageUri = FileProvider.getUriForFile(context!!, authorities, imageFile)
                callIntent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri)
                startActivityForResult(callIntent, CAMERA_REQUEST_CODE)
            }
        } catch (e: IOException) {
            Toast.makeText(activity, "Could not create file", Toast.LENGTH_SHORT).show()
        }
    }

    private fun goToGrally() {
        var intent = Intent()
        intent.setAction(Intent.ACTION_PICK)
        intent.setType("image/*")
        startActivityForResult(intent, REQUSET_SELECT_PIC)
    }


    @Throws(IOException::class)
    fun createImageFile(): File {
        val timestamp = SimpleDateFormat("yyyyMMdd_HHmmss", Locale.US).format(Date())
        val imageFileName = "JPEG" + timestamp + "_"
        val storageDir = activity?.getExternalFilesDir(Environment.DIRECTORY_PICTURES)
        if (!storageDir!!.exists()) storageDir.mkdirs()
        val imageFile = createTempFile(imageFileName, ".jpg", storageDir)
        imageFilePath = imageFile.absolutePath
        return imageFile
    }


    fun setScaleBitmap(): Bitmap {
        val imageViewWidth = iv.width
        val imageViewHeight = iv.height

        val bmOptions = BitmapFactory.Options()
        bmOptions.inJustDecodeBounds = true
        BitmapFactory.decodeFile(imageFilePath, bmOptions)
        val bitmapWidth = bmOptions.outWidth
        val bitmapHeight = bmOptions.outHeight

        val scaleFactor = Math.min(bitmapWidth / imageViewWidth, bitmapHeight / imageViewHeight)
        bmOptions.inSampleSize = scaleFactor
        bmOptions.inJustDecodeBounds = false

        return BitmapFactory.decodeFile(imageFilePath, bmOptions)
    }

}
