package com.example.etpproject

import android.content.Context
import androidx.room.Room
import com.example.etpproject.bookdatabasepackage.BooksDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabasecontext(
        @ApplicationContext context: Context
    ) = Room.databaseBuilder(
        context, BooksDatabase::class.java, "books_prepDb"
    ).createFromAsset("database/books.db").build()

    @Singleton
    @Provides
    fun provideDao(database: BooksDatabase) = database.booksDao()

}