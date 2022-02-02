package id.namikaze.resepmakanan.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class RecipeResponse (

    @SerializedName("title")
    var title: String,

    @SerializedName("thumb")
    var thumb: String? = null,

    @SerializedName("key")
    var key: String? = null,

    @SerializedName("times")
    var times: String? = null,

    @SerializedName("portion")
    var portion: String? = null,

    @SerializedName("dificulty")
    var dificulty: String? = null

)