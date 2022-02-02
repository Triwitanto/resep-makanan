package id.namikaze.resepmakanan.data.source.local.entity

import android.os.Parcelable
import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import kotlinx.android.parcel.Parcelize

data class NeedItemEntity (

  @NonNull
  @ColumnInfo(name = "itemName")
  var itemName: String?,

  @NonNull
  @ColumnInfo(name = "thumbItem")
  var thumbItem: String?

)