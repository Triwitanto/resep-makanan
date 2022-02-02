package id.namikaze.resepmakanan.data.source.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "recipes")
data class RecipeEntity (

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "title")
    var title: String,

    @NonNull
    @ColumnInfo(name = "thumb")
    var thumb: String?,

    @NonNull
    @ColumnInfo(name = "key")
    var key: String?,

    @NonNull
    @ColumnInfo(name = "times")
    var times: String?,

    @NonNull
    @ColumnInfo(name = "portion")
    var portion: String?,

    @NonNull
    @ColumnInfo(name = "dificulty")
    var dificulty: String?

)