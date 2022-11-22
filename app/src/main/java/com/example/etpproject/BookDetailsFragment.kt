package com.example.etpproject

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import com.example.etpproject.bookdatabasepackage.BooksDatabase
import kotlinx.android.synthetic.main.fragment_book_details.view.*

class BookDetailsFragment : Fragment() {

    lateinit var database: BooksDatabase

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_book_details, container, false)

        database = Room.databaseBuilder(requireContext(), BooksDatabase::class.java, "books_database").allowMainThreadQueries().build()

        val writerrecyclerview = view.recycler_viewDetailsSameWriter
        val categoryrecyclerview = view.recycler_viewDetailsSameCategory



        writerrecyclerview.apply {
            val categorybooks = database.booksDao().readwriterbooks("J. K. Rowling")
            layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            adapter = newAdapterforbooks(categorybooks)
        }

        categoryrecyclerview.apply {
            val categorybooks = database.booksDao().readcategorybooks("Featured")
            layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            adapter = newAdapterforbooks(categorybooks)
        }

        return view
    }
}