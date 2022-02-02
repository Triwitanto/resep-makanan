package id.namikaze.resepmakanan.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class BaseResponse<T> (

    @SerializedName("method")
    var method: String?,

    @SerializedName("status")
    var status: Boolean?,

    @SerializedName("results")
    var results: T

)