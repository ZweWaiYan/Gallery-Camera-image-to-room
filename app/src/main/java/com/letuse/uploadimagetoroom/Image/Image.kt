package com.letuse.uploadimagetoroom.Image

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Room_table")
class Image(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "ID")
    var id: Int,

    @ColumnInfo(name = "Image")
    var image: String
)