package id.namikaze.resepmakanan.data.source.remote.response

import com.google.gson.annotations.SerializedName


data class DetailRecipeResponse (

  @SerializedName("title")
  var title: String,

  @SerializedName("thumb")
  var thumb: String?,

  @SerializedName("servings")
  var servings: String?,

  @SerializedName("times")
  var times: String?,

  @SerializedName("dificulty")
  var dificulty: String?,

  @SerializedName("author")
  var author: AuthorResponse?,

  @SerializedName("desc")
  var desc: String?,

  @SerializedName("needItem")
  var needItem: List<NeedItemResponse>,

  @SerializedName("ingredient")
  var ingredient: List<String>,

  @SerializedName("step")
  var step: List<String>

)