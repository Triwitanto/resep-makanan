package id.namikaze.resepmakanan.domain.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Author (

  val user: String?,
  val datePublished : String?

) :Parcelable