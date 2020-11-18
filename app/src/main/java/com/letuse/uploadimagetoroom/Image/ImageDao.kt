package com.letuse.uploadimagetoroom.Image

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ImageDao {
    @Query(value = "SELECT * FROM Room_table")
    fun getAllImage() : LiveData<List<Image>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertImage(image: Image)

    @Query("Delete from Room_table")
    suspend fun deleteAll()
}