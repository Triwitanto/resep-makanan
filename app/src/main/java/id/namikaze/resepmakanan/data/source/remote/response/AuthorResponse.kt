package id.namikaze.resepmakanan.data.source.remote.response

import com.google.gson.annotations.SerializedName


data class AuthorResponse (

  @SerializedName("user")
  val user: String?,

  @SerializedName("datePublished")
  val datePublished : String?

)