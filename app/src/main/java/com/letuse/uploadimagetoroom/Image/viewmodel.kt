package com.letuse.uploadimagetoroom.Image

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class viewmodel(application: Application): AndroidViewModel(application){
    private val repository: ImageRepository
    val allItem: LiveData<List<Image>>

    init {
        val productDao = ImageDatabase.getDatabase(application).imagedao()
        repository = ImageRepository(productDao)
        allItem = repository.allimage
    }

    fun insert(item: Image) = viewModelScope.launch {
        repository.imageInsert(item)
    }

    fun delete()=viewModelScope.launch {
        repository.delete()
    }
}