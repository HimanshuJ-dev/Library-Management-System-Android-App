package com.example.etpproject

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import com.example.etpproject.bookdatabasepackage.*
import kotlinx.android.synthetic.main.fragment_home.view.*

class HomeFragment : Fragment() {

    lateinit var database: BooksDatabase

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        database = Room.databaseBuilder(requireContext(), BooksDatabase::class.java, "books_database").allowMainThreadQueries().build()

        val recyclerViewfeatured = view.recycler_viewHomeFeatured
        val recyclerViewTopSeller = view.recycler_viewHomeTopSelling
        val recyclerViewAmazingReads = view.recycler_viewHomeAmazingReads
        val recyclerViewRecommended = view.recycler_viewHomeRecommended

        val featuremorebtn = view.findViewById<Button>(R.id.featuremore)
        val topsellermorebtn = view.findViewById<Button>(R.id.topsellermore)
        val amazingmorebtn = view.findViewById<Button>(R.id.amazingmore)
        val recommendedmorebtn = view.findViewById<Button>(R.id.recommendedmore)

        recyclerViewfeatured.apply {
            val categorybooks = database.booksDao().readcategorybooks("Featured")
            layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            adapter = newAdapterforbooks(categorybooks)
        }

        recyclerViewTopSeller.apply {
            val categorybooks = database.booksDao().readcategorybooks("Top Selling")
            layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            adapter = newAdapterforbooks(categorybooks)
        }

        recyclerViewAmazingReads.apply {
            val categorybooks = database.booksDao().readcategorybooks("Amazing Reads")
            layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            adapter = newAdapterforbooks(categorybooks)
        }

        recyclerViewRecommended.apply {
            val categorybooks = database.booksDao().readcategorybooks("Recommended")
            layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            adapter = newAdapterforbooks(categorybooks)
        }

        featuremorebtn.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_categorySpecificFragment, Bundle().apply {
                putString("catname", "Featured")
            })
        }
        topsellermorebtn.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_categorySpecificFragment, Bundle().apply {
                putString("catname", "Top Selling")
            })
        }
        amazingmorebtn.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_categorySpecificFragment, Bundle().apply {
                putString("catname", "Amazing Reads")
            })
        }
        recommendedmorebtn.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_categorySpecificFragment, Bundle().apply {
                putString("catname", "Recommended")
            })
        }

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }
}