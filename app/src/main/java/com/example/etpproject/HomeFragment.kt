package com.example.etpproject

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import com.example.etpproject.bookdatabasepackage.*
import kotlinx.android.synthetic.main.fragment_home.view.*

class HomeFragment : Fragment() {

    lateinit var database: BooksDatabase

    private lateinit var adapter1: newAdapterforbooks
    private lateinit var adapter2: newAdapterforbooks
    private lateinit var adapter3: newAdapterforbooks
    private lateinit var adapter4: newAdapterforbooks

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

        val categoryfeaturedbooks = database.booksDao().readcategorybooks("Featured")
        val categorytopbooks = database.booksDao().readcategorybooks("Top Selling")
        val categoryamazingbooks = database.booksDao().readcategorybooks("Amazing Reads")
        val categoryrecommendedbooks = database.booksDao().readcategorybooks("Recommended")



        val layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        recyclerViewfeatured.layoutManager = layoutManager
        adapter1 = categoryfeaturedbooks?.let { newAdapterforbooks(it) }!!
        recyclerViewfeatured.adapter = adapter1

        val layoutManager1 = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        recyclerViewTopSeller.layoutManager = layoutManager1
        adapter2 = categorytopbooks?.let { newAdapterforbooks(it) }!!
        recyclerViewTopSeller.adapter = adapter2

        val layoutManager2 = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        recyclerViewAmazingReads.layoutManager = layoutManager2
        adapter3 = categoryamazingbooks?.let { newAdapterforbooks(it) }!!
        recyclerViewAmazingReads.adapter = adapter3

        val layoutManager3 = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        recyclerViewRecommended.layoutManager = layoutManager3
        adapter4 = categoryrecommendedbooks?.let { newAdapterforbooks(it) }!!
        recyclerViewRecommended.adapter = adapter4

        adapter1.setOnItemClickListener(object : newAdapterforbooks.onBookItemClickListener{
            override fun onItemClick(position: Int){

                val bookname = categoryfeaturedbooks?.get(position)?.BookName

                findNavController().navigate(R.id.action_homeFragment_to_bookDetailsFragment2, Bundle().apply {
                    putString("bookname", "$bookname")
                    putString("fromname", "Home")
                })
            }


        })
        adapter2.setOnItemClickListener(object : newAdapterforbooks.onBookItemClickListener{
            override fun onItemClick(position: Int){

                val bookname = categorytopbooks?.get(position)?.BookName

                findNavController().navigate(R.id.action_homeFragment_to_bookDetailsFragment2, Bundle().apply {
                    putString("bookname", "$bookname")
                    putString("fromname", "Home")
                })
            }


        })
        adapter3.setOnItemClickListener(object : newAdapterforbooks.onBookItemClickListener{
            override fun onItemClick(position: Int){

                val bookname = categoryamazingbooks?.get(position)?.BookName

                findNavController().navigate(R.id.action_homeFragment_to_bookDetailsFragment2, Bundle().apply {
                    putString("bookname", "$bookname")
                    putString("fromname", "Home")
                })
            }


        })
        adapter4.setOnItemClickListener(object : newAdapterforbooks.onBookItemClickListener{
            override fun onItemClick(position: Int){

                val bookname = categoryrecommendedbooks?.get(position)?.BookName

                findNavController().navigate(R.id.action_homeFragment_to_bookDetailsFragment2, Bundle().apply {
                    putString("bookname", "$bookname")
                    putString("fromname", "Home")
                })
            }


        })

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