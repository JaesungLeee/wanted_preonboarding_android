package jaesung.project.wanted_preonboarding_android.di

import androidx.room.Room
import jaesung.project.wanted_preonboarding_android.data.db.NewsDao
import jaesung.project.wanted_preonboarding_android.data.db.NewsDatabase
import org.koin.dsl.module

val dbModule = module {
    single<NewsDatabase> {
        Room.databaseBuilder(
            get(),
            NewsDatabase::class.java,
            "article"
        ).build()
    }

    single<NewsDao> {
        get<NewsDatabase>().newsDao()
    }

}