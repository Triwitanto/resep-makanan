package id.namikaze.resepmakanan.data.source.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "recipe")
data class DetailRecipeEntity (

  @PrimaryKey
  @NonNull
  @ColumnInfo(name = "title")
  var title: String,

  @NonNull
  @ColumnInfo(name = "thumb")
  var thumb: String?,

  @NonNull
  @ColumnInfo(name = "servings")
  var servings: String?,

  @NonNull
  @ColumnInfo(name = "times")
  var times: String?,

  @NonNull
  @ColumnInfo(name = "dificulty")
  var dificulty: String?,

  @NonNull
  @ColumnInfo(name = "desc")
  var desc: String?,

  @NonNull
  @ColumnInfo(name = "user")
  val user: String?,

  @NonNull
  @ColumnInfo(name = "datePublished")
  val datePublished : String?

)