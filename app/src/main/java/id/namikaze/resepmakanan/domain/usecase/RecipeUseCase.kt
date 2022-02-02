package id.namikaze.resepmakanan.domain.usecase

import id.namikaze.resepmakanan.data.Resource
import id.namikaze.resepmakanan.data.source.remote.response.BaseResponse
import id.namikaze.resepmakanan.data.source.remote.response.DetailRecipeResponse
import id.namikaze.resepmakanan.data.source.remote.response.RecipeResponse
import id.namikaze.resepmakanan.domain.model.DetailRecipe
import id.namikaze.resepmakanan.domain.model.Recipe
import kotlinx.coroutines.flow.Flow

interface RecipeUseCase {

    fun getRecipesList(): Flow<Resource<List<Recipe>>>

    fun getRecipesDetail(key: String): Flow<Resource<DetailRecipe>>
}