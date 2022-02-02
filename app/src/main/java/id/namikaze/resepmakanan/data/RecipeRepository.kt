package id.namikaze.resepmakanan.data

import android.util.Log
import com.google.gson.Gson
import id.namikaze.resepmakanan.data.source.local.IRecipeLocalSource
import id.namikaze.resepmakanan.data.source.remote.IRecipeRemoteSource
import id.namikaze.resepmakanan.data.source.remote.network.ApiResponse
import id.namikaze.resepmakanan.data.source.remote.response.DetailRecipeResponse
import id.namikaze.resepmakanan.data.source.remote.response.RecipeResponse
import id.namikaze.resepmakanan.domain.model.DetailRecipe
import id.namikaze.resepmakanan.domain.model.Recipe
import id.namikaze.resepmakanan.domain.repository.IRecipeRepository
import id.namikaze.resepmakanan.utlis.AppExecutors
import id.namikaze.resepmakanan.utlis.DataMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class RecipeRepository(
    private val recipeRemoteDataSource: IRecipeRemoteSource,
    private val recipeLocalDataSource: IRecipeLocalSource,
    private val appExecutors: AppExecutors
): IRecipeRepository {
    override fun getRecipesList(): Flow<Resource<List<Recipe>>> {
        return object: NetworkBoundResource<List<Recipe>, List<RecipeResponse>>() {
            override fun loadFromDB(): Flow<List<Recipe>> {
                return recipeLocalDataSource.getRecipesList().map {
                    Log.d("datalokalapa", Gson().toJson(it))
                    DataMapper.RecipeMapper.mapEntitiesToDomain(it)
                }
            }

            override fun shouldFetch(data: List<Recipe>?): Boolean  = true

            override suspend fun createCall(): Flow<ApiResponse<List<RecipeResponse>>> =
                recipeRemoteDataSource.getRecipesList()

            override suspend fun saveCallResult(data: List<RecipeResponse>) {
                recipeLocalDataSource.insertRecipesList(
                    DataMapper.RecipeMapper.mapResponsesToEntities(data)
                )
            }

        }.asFlow()
    }

    override fun getRecipesDetail(key: String): Flow<Resource<DetailRecipe>> {
        return object: NetworkBoundResource<DetailRecipe, DetailRecipeResponse>() {
            override fun loadFromDB(): Flow<DetailRecipe> {
                return recipeLocalDataSource.getRecipesDetail(key).map {
                    DataMapper.RecipeDetailMapper.mapEntitiesToDomain(it)
                }
            }

            override fun shouldFetch(data: DetailRecipe?): Boolean = true

            override suspend fun createCall(): Flow<ApiResponse<DetailRecipeResponse>> =
                recipeRemoteDataSource.getRecipesDetail(key)

            override suspend fun saveCallResult(data: DetailRecipeResponse) {
                recipeLocalDataSource.insertRecipesDetail(
                    DataMapper.RecipeDetailMapper.mapResponsesToEntities(data)
                )
            }

        }.asFlow()
    }
}