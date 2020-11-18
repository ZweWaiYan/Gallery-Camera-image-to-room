package com.letuse.uploadimagetoroom

import android.Manifest
import android.app.Activity
import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.provider.Settings
import android.util.Log.d
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*

//https://handyopinion.com/pick-image-from-gallery-in-kotlin-android/
class MainActivity : AppCompatActivity() {

    var REQUEST_CODE: Int = 1111
    var CAMERA_REQUEST_CODE: Int = 1111

    //Everything is good

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }
//        askForPermissions()
//
//        cameraBtn.setOnClickListener {
//            capturePhoto()
//        }
//
//        galleryBtn.setOnClickListener {
//            openGalleryForImage()
//        }
//
//
//    }
//
//    private fun openGalleryForImage() {
//        val intent = Intent(Intent.ACTION_PICK)
//        intent.type = "image/*"
//        startActivityForResult(intent, REQUEST_CODE)
//    }
//
//    fun capturePhoto() {
//        val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
//        startActivityForResult(cameraIntent, REQUEST_CODE)
//    }
//
//    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        super.onActivityResult(requestCode, resultCode, data)
//
//        if (resultCode == Activity.RESULT_OK && requestCode == REQUEST_CODE) {
//            displayImageView.setImageURI(data?.data) // handle chosen image
//
//            val uriPathHelper = URIPathHelper()
//            val filePath = uriPathHelper.getPath(this, data?.data!!)
//            d("gg" , filePath.toString())
//        }
//    }
//
//    //Permission
//    fun GalleryisPermissionsAllowed(): Boolean {
//        return if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED)  { false } else true
//    }
//
//    fun askForPermissions(): Boolean {
//        if (!GalleryisPermissionsAllowed()) {
//            if (ActivityCompat.shouldShowRequestPermissionRationale(this as Activity,Manifest.permission.READ_EXTERNAL_STORAGE)) {
//                showPermissionDeniedDialog()
//            } else {
//                ActivityCompat.requestPermissions(this as Activity,arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE),REQUEST_CODE)
//            }
//            return false
//        }
//        return true
//    }
//
//    override fun onRequestPermissionsResult(requestCode: Int,permissions: Array<String>,grantResults: IntArray) {
//        when (requestCode) {
//            REQUEST_CODE -> {
//                if (grantResults.size > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
//                    // permission is granted, you can perform your operation here
//                } else {
//                    // permission is denied, you can ask for permission again, if you want
//                    //  askForPermissions()
//                }
//                return
//            }
//        }
//    }
//
//    private fun showPermissionDeniedDialog() {
//        AlertDialog.Builder(this)
//            .setTitle("Permission Denied")
//            .setMessage("Permission is denied, Please allow permissions from App Settings.")
//            .setPositiveButton("App Settings",
//                DialogInterface.OnClickListener { dialogInterface, i ->
//                    // send to app settings if permission is denied permanently
//                    val intent = Intent()
//                    intent.action = Settings.ACTION_APPLICATION_DETAILS_SETTINGS
//                    val uri = Uri.fromParts("package", getPackageName(), null)
//                    intent.data = uri
//                    startActivity(intent)
//                })
//            .setNegativeButton("Cancel",null)
//            .show()
//    }

}