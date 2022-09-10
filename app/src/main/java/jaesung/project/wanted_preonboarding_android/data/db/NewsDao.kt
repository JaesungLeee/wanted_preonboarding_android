package jaesung.project.wanted_preonboarding_android.data.db

import androidx.room.*
import jaesung.project.wanted_preonboarding_android.data.model.SavedNews

@Dao
interface NewsDao {

    @Query("SELECT * FROM SavedNews")
    suspend fun getSavedNews(): List<SavedNews>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNews(news: SavedNews)

    @Delete
    suspend fun deleteNews(news: SavedNews)

}