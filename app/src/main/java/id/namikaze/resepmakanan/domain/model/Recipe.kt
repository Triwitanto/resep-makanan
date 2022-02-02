package id.namikaze.resepmakanan.domain.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Recipe (

    var title: String?,
    var thumb: String?,
    var key: String?,
    var times: String?,
    var portion: String?,
    var dificulty: String?

) : Parcelable