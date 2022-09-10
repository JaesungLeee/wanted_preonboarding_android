package jaesung.project.wanted_preonboarding_android.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import jaesung.project.wanted_preonboarding_android.data.model.SavedNews

@Database(entities = [SavedNews::class], version = 1, exportSchema = false)
abstract class NewsDatabase : RoomDatabase() {
    abstract fun newsDao(): NewsDao
}