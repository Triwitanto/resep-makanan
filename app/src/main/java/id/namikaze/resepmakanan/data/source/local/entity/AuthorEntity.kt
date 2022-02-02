package id.namikaze.resepmakanan.data.source.local.entity

import android.os.Parcelable
import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

data class AuthorEntity (
  @NonNull
  @ColumnInfo(name = "user")
  val user: String?,

  @NonNull
  @ColumnInfo(name = "datePublished")
  val datePublished : String?
)