package com.example.etpproject.bookdatabasepackage

import androidx.lifecycle.LiveData
import javax.inject.Inject

class BooksRepository @Inject constructor(private val booksDao: BooksDao) {

    val readAllData: LiveData<List<Books>> = booksDao.readAllData()


}