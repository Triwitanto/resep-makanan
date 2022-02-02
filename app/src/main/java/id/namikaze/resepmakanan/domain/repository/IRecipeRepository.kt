package id.namikaze.resepmakanan.domain.repository

import id.namikaze.resepmakanan.data.Resource
import id.namikaze.resepmakanan.data.source.remote.response.BaseResponse
import id.namikaze.resepmakanan.domain.model.DetailRecipe
import id.namikaze.resepmakanan.domain.model.Recipe
import kotlinx.coroutines.flow.Flow

interface IRecipeRepository {

    fun getRecipesList(): Flow<Resource<List<Recipe>>>

    fun getRecipesDetail(key: String): Flow<Resource<DetailRecipe>>

}