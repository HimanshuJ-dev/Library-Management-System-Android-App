package com.example.etpproject.bookdatabasepackage

import android.widget.TextView
import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import java.util.Locale.Category


@Dao
interface BooksDao {

    @Query("SELECT * from books ORDER BY bookid ASC")
    fun readAllData(): LiveData<List<Books>>

    @Query("SELECT * from books ORDER BY bookid ASC")
    fun readhomeData(): List<Books>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addBook(books: Books)

    @Query("SELECT * from books WHERE BookCategory like :category")
    fun readcategorybooks(category: String): List<Books>

    @Query("SELECT * from books WHERE BookGenre like :genre")
    fun readgenrebooks(genre: String): List<Books>

    @Query("SELECT * from books WHERE WriterName like :author")
    fun readwriterbooks(author: String): List<Books>

    @Query("SELECT * from books WHERE BookName like :bookname")
    fun getbookfromname(bookname: String): List<Books>
}