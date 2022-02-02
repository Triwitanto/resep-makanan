package id.namikaze.resepmakanan.data.source.local

import id.namikaze.resepmakanan.data.source.local.entity.DetailRecipeEntity
import id.namikaze.resepmakanan.data.source.local.entity.RecipeEntity
import kotlinx.coroutines.flow.Flow

interface IRecipeLocalSource {

    fun getRecipesList(): Flow<List<RecipeEntity>>

    fun getRecipesDetail(key: String): Flow<DetailRecipeEntity>

    suspend fun insertRecipesList(data: List<RecipeEntity>)

    suspend fun insertRecipesDetail(data: DetailRecipeEntity)
}