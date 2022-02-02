package id.namikaze.resepmakanan.utlis

import id.namikaze.resepmakanan.data.source.local.entity.AuthorEntity
import id.namikaze.resepmakanan.data.source.local.entity.DetailRecipeEntity
import id.namikaze.resepmakanan.data.source.local.entity.NeedItemEntity
import id.namikaze.resepmakanan.data.source.local.entity.RecipeEntity
import id.namikaze.resepmakanan.data.source.remote.response.DetailRecipeResponse
import id.namikaze.resepmakanan.data.source.remote.response.RecipeResponse
import id.namikaze.resepmakanan.domain.model.Author
import id.namikaze.resepmakanan.domain.model.DetailRecipe
import id.namikaze.resepmakanan.domain.model.NeedItem
import id.namikaze.resepmakanan.domain.model.Recipe

object DataMapper {

    object RecipeMapper {
        fun mapResponsesToEntities(input: List<RecipeResponse>): List<RecipeEntity> {
            val dataList = ArrayList<RecipeEntity>()
            input.map {
                val data = RecipeEntity(
                    title = it.title,
                    thumb = it.thumb,
                    key = it.key,
                    times = it.times,
                    portion = it.portion,
                    dificulty = it.dificulty
                )
                dataList.add(data)
            }
            return dataList
        }

        fun mapEntitiesToDomain(input: List<RecipeEntity>): List<Recipe> {
            return input.map {
                Recipe(
                    title = it.title,
                    thumb = it.thumb,
                    key = it.key,
                    times = it.times,
                    portion = it.portion,
                    dificulty = it.dificulty
                )
            }
        }
    }

    object RecipeDetailMapper {
        fun mapResponsesToEntities(input: DetailRecipeResponse): DetailRecipeEntity {
//            val author = AuthorEntity(
//                user = input.author?.user,
//                datePublished = input.author?.datePublished
//            )
//
//            val needList = ArrayList<NeedItemEntity>()
//            input.needItem.map {
//                val data = NeedItemEntity(
//                    itemName = it.itemName,
//                    thumbItem = it.thumbItem
//                )
//                needList.add(data)
//            }

            return DetailRecipeEntity(
                title = input.title,
                thumb = input.thumb,
                servings = input.servings,
                times = input.times,
                dificulty = input.dificulty,
                desc = input.desc,
                user = input.author?.user,
                datePublished = input.author?.datePublished

            )
        }
        fun mapEntitiesToDomain(input: DetailRecipeEntity?): DetailRecipe {
            return DetailRecipe(
                title = input?.title,
                thumb = input?.thumb,
                servings = input?.servings,
                times = input?.times,
                dificulty = input?.dificulty,
                desc = input?.desc,
                user = input?.user,
                datePublished = input?.datePublished
//                needItem = needList,
//                ingredient = input?.ingredient.orEmpty(),
//                step = input?.step.orEmpty()
            )
        }
    }

}