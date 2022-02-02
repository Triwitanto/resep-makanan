package id.namikaze.resepmakanan.presenter.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import id.namikaze.resepmakanan.data.Resource
import id.namikaze.resepmakanan.data.source.remote.response.BaseResponse
import id.namikaze.resepmakanan.data.source.remote.response.RecipeResponse
import id.namikaze.resepmakanan.domain.model.Recipe
import id.namikaze.resepmakanan.domain.usecase.RecipeUseCase
import kotlinx.coroutines.flow.collect

class HomeViewModel(private val recipeUseCase: RecipeUseCase) : ViewModel() {

    private var _recipe = MutableLiveData<Resource<List<Recipe>>>()
    val recipe: LiveData<Resource<List<Recipe>>> = _recipe

    suspend fun getRecipesList() {
        recipeUseCase.getRecipesList().collect{
            _recipe.postValue(it)
        }
    }
}