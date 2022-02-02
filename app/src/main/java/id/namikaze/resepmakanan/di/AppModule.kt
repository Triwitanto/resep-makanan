package id.namikaze.resepmakanan.di

import id.namikaze.resepmakanan.domain.usecase.RecipeInteractor
import id.namikaze.resepmakanan.domain.usecase.RecipeUseCase
import id.namikaze.resepmakanan.presenter.viewmodel.HomeViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val useCaseModule = module {
    factory<RecipeUseCase> { RecipeInteractor(get()) }
}

val viewModelModule =  module {
    viewModel { HomeViewModel(get()) }
}