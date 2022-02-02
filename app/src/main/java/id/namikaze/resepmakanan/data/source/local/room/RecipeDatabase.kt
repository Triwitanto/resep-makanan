package id.namikaze.resepmakanan.data.source.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import id.namikaze.resepmakanan.data.source.local.entity.DetailRecipeEntity
import id.namikaze.resepmakanan.data.source.local.entity.RecipeEntity

@Database(
    entities = [
        RecipeEntity::class,
        DetailRecipeEntity::class
    ],
    version = 1,
    exportSchema = false
)

abstract class RecipeDatabase: RoomDatabase() {
    abstract fun recipeDao(): RecipeDao
}
