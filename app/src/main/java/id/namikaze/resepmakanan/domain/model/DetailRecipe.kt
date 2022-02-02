package id.namikaze.resepmakanan.domain.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class DetailRecipe (

  var title: String?,
  var thumb: String?,
  var servings: String?,
  var times: String?,
  var dificulty: String?,
  var desc: String?,
  val user: String?,
  val datePublished : String?

) : Parcelable