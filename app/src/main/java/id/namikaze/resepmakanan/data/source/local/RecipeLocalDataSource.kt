package id.namikaze.resepmakanan.data.source.local

import android.util.Log
import androidx.lifecycle.lifecycleScope
import com.google.gson.Gson
import id.namikaze.resepmakanan.data.source.local.entity.DetailRecipeEntity
import id.namikaze.resepmakanan.data.source.local.entity.RecipeEntity
import id.namikaze.resepmakanan.data.source.local.room.RecipeDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class RecipeLocalDataSource(private val recipeDao: RecipeDao): IRecipeLocalSource {
    override fun getRecipesList(): Flow<List<RecipeEntity>> = recipeDao.getRecipesList()

    override fun getRecipesDetail(key: String): Flow<DetailRecipeEntity> = recipeDao.getRecipesDetail(key)

    override suspend fun insertRecipesList(data: List<RecipeEntity>) {
        GlobalScope.launch {
            recipeDao.insertRecipesList(data)
        }
    }

    override suspend fun insertRecipesDetail(data: DetailRecipeEntity) {
        recipeDao.insertRecipesDetail(data)
    }
}