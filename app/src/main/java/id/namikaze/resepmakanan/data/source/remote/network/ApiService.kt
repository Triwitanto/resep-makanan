package id.namikaze.resepmakanan.data.source.remote.network

import id.namikaze.resepmakanan.data.source.remote.response.BaseResponse
import id.namikaze.resepmakanan.data.source.remote.response.DetailRecipeResponse
import id.namikaze.resepmakanan.data.source.remote.response.RecipeResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("recipes")
    suspend fun getRecipesList(): BaseResponse<List<RecipeResponse>>

    @GET("recipe/{key}")
    suspend fun getRecipesDetail(@Path("key") key: String): BaseResponse<DetailRecipeResponse>
}