package com.example.etpproject.bookdatabasepackage

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.etpproject.userLoginAndSignUp.User
import com.example.etpproject.userLoginAndSignUp.UserDatabase
import com.example.etpproject.userLoginAndSignUp.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BooksViewModel @Inject constructor(booksRepository: BooksRepository): ViewModel() {

    val readAllData: LiveData<List<Books>> = TODO()
    val readHomeData: LiveData<List<Books>>
    private val repository: UserRepository
        get() {
            TODO()
        }

}