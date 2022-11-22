package com.example.etpproject

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.room.Room
import com.example.etpproject.bookdatabasepackage.BooksDatabase

class categorySpecificFragment : Fragment() {

    lateinit var database: BooksDatabase

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_category_specific, container, false)

        database = Room.databaseBuilder(requireContext(), BooksDatabase::class.java, "books_database").allowMainThreadQueries().build()

        return view
    }
}