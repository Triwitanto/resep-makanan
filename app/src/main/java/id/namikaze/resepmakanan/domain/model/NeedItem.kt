package id.namikaze.resepmakanan.domain.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class NeedItem (

  var itemName: String?,
  var thumbItem: String?

) : Parcelable