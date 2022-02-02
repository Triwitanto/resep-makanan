package id.namikaze.resepmakanan.domain.usecase

import id.namikaze.resepmakanan.data.Resource
import id.namikaze.resepmakanan.domain.model.DetailRecipe
import id.namikaze.resepmakanan.domain.model.Recipe
import id.namikaze.resepmakanan.domain.repository.IRecipeRepository
import kotlinx.coroutines.flow.Flow

class RecipeInteractor(private val recipeRepository: IRecipeRepository) : RecipeUseCase {
    override fun getRecipesList(): Flow<Resource<List<Recipe>>> =
        recipeRepository.getRecipesList()

    override fun getRecipesDetail(key: String): Flow<Resource<DetailRecipe>> =
        recipeRepository.getRecipesDetail(key)
}