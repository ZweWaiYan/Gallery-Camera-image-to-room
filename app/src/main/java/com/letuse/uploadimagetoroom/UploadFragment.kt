package com.letuse.uploadimagetoroom

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import android.provider.Settings
import android.util.Log.d
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.letuse.uploadimagetoroom.Image.Image
import com.letuse.uploadimagetoroom.Image.viewmodel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_upload.*

class UploadFragment : Fragment() {

    var ONE_REQUEST_CODE: Int = 1111
    var TWO_REQUEST_CODE: Int = 2222

    private var ID : Int = 0
    lateinit var filePath : String

    lateinit var vm: viewmodel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_upload, container, false)
    }

    //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    //need manual permission => app >> app info >> app permissions >> allow(camera)
    //refer => https://handyopinion.com/pick-image-from-gallery-in-kotlin-android/

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        askForPermissions()
        vm =  ViewModelProvider(this).get(viewmodel::class.java)

        frg_galleryBtn.setOnClickListener {
            openGalleryForImage()
        }

        frg_cameraBtn.setOnClickListener {
            capturePhoto()
        }

        btn_send.setOnClickListener{
            var data = Image(ID,filePath)
            vm.insert(data)
            Toast.makeText(context,"Successfully",Toast.LENGTH_LONG).show()
        }

        btn_next.setOnClickListener {
            findNavController().navigate(UploadFragmentDirections.actionUploadFragmentToNextFragment())
        }

        btn_delete.setOnClickListener {
            vm.delete()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        //for galley
        if (resultCode == Activity.RESULT_OK && requestCode == ONE_REQUEST_CODE) {
            frg_displayImageView.setImageURI(data?.data).toString() // handle chosen image
            val uriPathHelper = URIPathHelper()
            filePath = uriPathHelper.getPath(requireContext(), data?.data!!).toString()

        }

        //for camera
        if (resultCode == Activity.RESULT_OK && requestCode == TWO_REQUEST_CODE && data != null){
            frg_displayImageView.setImageBitmap(data.extras?.get("data") as Bitmap)
        }
    }

    fun openGalleryForImage() {
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = "image/*"
        startActivityForResult(intent, ONE_REQUEST_CODE)
    }

    fun capturePhoto() {
        val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        startActivityForResult(cameraIntent, TWO_REQUEST_CODE)
    }

    //Permission
    fun GalleryisPermissionsAllowed(): Boolean {
        return if (ContextCompat.checkSelfPermission(requireContext(), Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED)  { false } else true
    }

    fun askForPermissions(): Boolean {
        if (!GalleryisPermissionsAllowed()) {
                ActivityCompat.requestPermissions(requireActivity(),arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE),ONE_REQUEST_CODE)
            return false
        }
        return true
    }

    override fun onRequestPermissionsResult(requestCode: Int,permissions: Array<String>,grantResults: IntArray) {
        when (requestCode) {
            ONE_REQUEST_CODE -> {
                if (grantResults.size > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                } else {
                    // permission is denied, you can ask for permission again, if you want
                    askForPermissions()
                }
                return
            }
        }
    }
}