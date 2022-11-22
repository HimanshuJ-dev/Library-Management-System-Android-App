package com.example.etpproject

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.example.etpproject.bookdatabasepackage.BooksDatabase

class genreSpecificFragment : Fragment() {

    lateinit var database: BooksDatabase

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_genre_specific, container, false)

        database = Room.databaseBuilder(requireContext(), BooksDatabase::class.java, "books_database").allowMainThreadQueries().build()



        val genreSpecificRecyclerView = view.findViewById<RecyclerView>(R.id.genrespecificrecyclerview)

        val backbtn = view.findViewById<Button>(R.id.genrespecificbackbutton)

        val titletv = view.findViewById<TextView>(R.id.genrespecifictitletv)

        val genrespename = requireArguments().getString("genrename")

        titletv.text = genrespename

        val genrebooks = genrespename?.let { database.booksDao().readgenrebooks(it) }

        genreSpecificRecyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = genrebooks?.let { genreSpecificAdapter(it) }
        }

        backbtn.setOnClickListener {
            findNavController().navigate(R.id.action_genreSpecificFragment_to_genreFragment)
        }


        return view
    }


}