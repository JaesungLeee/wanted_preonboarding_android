package jaesung.project.wanted_preonboarding_android.data.db

import androidx.room.*
import jaesung.project.wanted_preonboarding_android.data.model.SavedNews
import kotlinx.coroutines.flow.Flow

@Dao
interface NewsDao {

    @Query("SELECT * FROM SavedNews")
    suspend fun getSavedNews(): List<SavedNews>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNews(news: SavedNews)

    @Query("DELETE FROM SavedNews WHERE SavedNews.title = :title")
    suspend fun deleteNews(title: String)
}