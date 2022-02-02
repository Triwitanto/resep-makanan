package id.namikaze.resepmakanan.di

import androidx.room.Room
import id.namikaze.resepmakanan.BuildConfig
import id.namikaze.resepmakanan.data.RecipeRepository
import id.namikaze.resepmakanan.data.source.local.IRecipeLocalSource
import id.namikaze.resepmakanan.data.source.local.RecipeLocalDataSource
import id.namikaze.resepmakanan.data.source.local.room.RecipeDatabase
import id.namikaze.resepmakanan.data.source.remote.IRecipeRemoteSource
import id.namikaze.resepmakanan.data.source.remote.RecipeRemoteDataSource
import id.namikaze.resepmakanan.data.source.remote.network.ApiService
import id.namikaze.resepmakanan.domain.repository.IRecipeRepository
import id.namikaze.resepmakanan.utlis.AppExecutors
import net.sqlcipher.database.SQLiteDatabase
import net.sqlcipher.database.SupportFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val databaseModule = module {
    factory { get<RecipeDatabase>().recipeDao() }
    single {
        val passphrase: ByteArray = SQLiteDatabase.getBytes(BuildConfig.ENCRYPT_PASSWORD.toCharArray())
        val factory = SupportFactory(passphrase)
        Room.databaseBuilder(
            androidContext(),
            RecipeDatabase::class.java, BuildConfig.DATABSE_NAME
        ).fallbackToDestructiveMigration()
            .openHelperFactory(factory)
            .build()
    }
}

val networkModule = module {
    single {
        OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .connectTimeout(120, TimeUnit.SECONDS)
            .readTimeout(120, TimeUnit.SECONDS)
            .build()
    }
    single {
        val retrofit = Retrofit.Builder()
            .baseUrl("${BuildConfig.BASE_URL}${BuildConfig.API_PATH}")
            .addConverterFactory(GsonConverterFactory.create())
            .client(get())
            .build()
        retrofit.create(ApiService::class.java)
    }
}

val localDataSourceModule = module {
    single<IRecipeLocalSource> {
        RecipeLocalDataSource(get())
    }
}
val remoteDataSourceModule = module {
    single<IRecipeRemoteSource> {
        RecipeRemoteDataSource(get())
    }
}

val repositoryModule = module {
    single { RecipeLocalDataSource(get()) }
    single { RecipeRemoteDataSource(get()) }
    factory { AppExecutors() }
    single<IRecipeRepository> {
        RecipeRepository(get(), get(), get())
    }
}