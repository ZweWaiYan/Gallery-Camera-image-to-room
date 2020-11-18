package com.letuse.uploadimagetoroom.Image

import androidx.lifecycle.LiveData

class ImageRepository(private val imageDao: ImageDao) {
    val allimage : LiveData<List<Image>> = imageDao.getAllImage()

    suspend fun imageInsert(image: Image){
        imageDao.insertImage(image)
    }

    suspend fun delete() {
        imageDao.deleteAll()
    }
}