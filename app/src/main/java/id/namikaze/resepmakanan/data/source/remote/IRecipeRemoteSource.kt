package id.namikaze.resepmakanan.data.source.remote

import id.namikaze.resepmakanan.data.source.remote.network.ApiResponse
import id.namikaze.resepmakanan.data.source.remote.response.DetailRecipeResponse
import id.namikaze.resepmakanan.data.source.remote.response.RecipeResponse
import kotlinx.coroutines.flow.Flow

interface IRecipeRemoteSource {
    fun getRecipesList(): Flow<ApiResponse<List<RecipeResponse>>>

    fun getRecipesDetail(key: String): Flow<ApiResponse<DetailRecipeResponse>>
}