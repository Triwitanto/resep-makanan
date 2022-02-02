package id.namikaze.resepmakanan.data.source.remote.response

import com.google.gson.annotations.SerializedName


data class NeedItemResponse (

  @SerializedName("item_name")
  var itemName: String?,

  @SerializedName("thumb_item")
  var thumbItem: String?

)