package com.example.etpproject

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.example.etpproject.bookdatabasepackage.BooksDatabase

class categorySpecificFragment : Fragment() {

    lateinit var database: BooksDatabase

    lateinit var adapter1: genreSpecificAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_category_specific, container, false)

        database = Room.databaseBuilder(requireContext(), BooksDatabase::class.java, "books_database").allowMainThreadQueries().build()

        val genreSpecificRecyclerView = view.findViewById<RecyclerView>(R.id.catspecificrecyclerview)

        val backbtn = view.findViewById<Button>(R.id.catspecificbackbutton)

        val titletv = view.findViewById<TextView>(R.id.catspecifictitletv)

        val catspename = requireArguments().getString("catname")

        titletv.text = catspename

        val genrebooks = catspename?.let { database.booksDao().readcategorybooks(it) }

        genreSpecificRecyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = genrebooks?.let { genreSpecificAdapter(it) }
        }

        adapter1 = genrebooks?.let { genreSpecificAdapter(it) }!!

        adapter1.setOnItemClickListener(object : genreSpecificAdapter.onGenreItemClickListener{
            override fun onItemClick(position: Int){

                //val bookid = genrebooks?.get(position)?.bookid

                findNavController().navigate(R.id.action_categorySpecificFragment_to_bookDetailsFragment2)
            }


        })


        backbtn.setOnClickListener {
            findNavController().navigate(R.id.action_categorySpecificFragment_to_homeFragment)
        }

        return view
    }
}