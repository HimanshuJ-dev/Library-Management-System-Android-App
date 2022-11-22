package com.example.etpproject.bookdatabasepackage

import android.content.Context
import androidx.room.*


@Database(entities = [Books::class], version = 1)
abstract class BooksDatabase: RoomDatabase() {
    abstract fun booksDao(): BooksDao

    companion object{
        @Volatile
        private var INSTANCE: BooksDatabase?= null
        fun getDatabase(context: Context): BooksDatabase {
            val tempInstance = INSTANCE
            if(tempInstance  != null){
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext, BooksDatabase::class.java, "books_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }

    }

}