package com.example.etpproject

import android.graphics.BitmapFactory
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import com.example.etpproject.bookdatabasepackage.BooksDatabase
import kotlinx.android.synthetic.main.fragment_book_details.view.*

class BookDetailsFragment : Fragment() {

    lateinit var database: BooksDatabase

    private lateinit var adapter1: newAdapterforbooks
    private lateinit var adapter2: newAdapterforbooks

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_book_details, container, false)

        database = Room.databaseBuilder(requireContext(), BooksDatabase::class.java, "books_database").allowMainThreadQueries().build()

        val bookname = requireArguments().getString("bookname")
        val fromdetails = requireArguments().getString("fromname")

        val backbtn = view.detailsbackbtn

        val bookdetails = bookname?.let { database.booksDao().getbookfromname(it) }

        val bookimagedetails = view.detailsBookImage
        val booknamedetails = view.detailsBookNametv
        val bookwriterdetails = view.detailsWriterNametv
        val bookpublisherdetails = view.DetailsPublisherNametv
        val bookratingdetails = view.detailsBookRatingtv
        val bookpagesdetails = view.detailsBookPagestv
        val bookaboutdetails = view.detailsAboutThisBooktv

        val categorydetails = bookdetails?.get(0)?.BookCategory
        val genredetails = bookdetails?.get(0)?.BookGenre

        backbtn.setOnClickListener {
            if(fromdetails == "Home"){
                findNavController().navigate(R.id.action_bookDetailsFragment2_to_homeFragment)
            }else if(fromdetails == "genre"){
                findNavController().navigate(R.id.action_bookDetailsFragment_to_genreSpecificFragment, Bundle().apply {
                    putString("genrename", "$genredetails")
                })
            }else if(fromdetails == "category"){
                findNavController().navigate(R.id.action_bookDetailsFragment2_to_categorySpecificFragment, Bundle().apply {
                    putString("catname", "$categorydetails")
                })
            }
        }

        val writerdetails = bookdetails?.get(0)?.WriterName

        val img = bookdetails?.get(0)?.BookImage
        if (img != null) {
            bookimagedetails.setImageBitmap(BitmapFactory.decodeByteArray(img, 0, img.size))
        }
        booknamedetails.text = bookdetails?.get(0)?.BookName
        bookwriterdetails.text = bookdetails?.get(0)?.WriterName
        bookpublisherdetails.text = bookdetails?.get(0)?.BookPublisher
        val ratingsdetails = bookdetails?.get(0)?.BookRating.toString()
        bookratingdetails.text = "$ratingsdetails / 5"
        val pagesdetails = bookdetails?.get(0)?.BookPagesCount.toString()
        bookpagesdetails.text = "$pagesdetails Pages"
        bookaboutdetails.text = bookdetails?.get(0)?.BookAbout

        val writerrecyclerview = view.recycler_viewDetailsSameWriter
        val categoryrecyclerview = view.recycler_viewDetailsSameCategory

        val writerbooks = writerdetails?.let { database.booksDao().readwriterbooks(it) }
        val categorybooks = categorydetails?.let { database.booksDao().readcategorybooks(it) }

        val layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        writerrecyclerview.layoutManager = layoutManager
        adapter1 = writerbooks?.let { newAdapterforbooks(it) }!!
        writerrecyclerview.adapter = adapter1

        val layoutManager1 = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        categoryrecyclerview.layoutManager = layoutManager1
        adapter2 = categorybooks?.let { newAdapterforbooks(it) }!!
        categoryrecyclerview.adapter = adapter2

        if(fromdetails == "Home" || fromdetails == "category") {

            adapter1.setOnItemClickListener(object : newAdapterforbooks.onBookItemClickListener {
                override fun onItemClick(position: Int) {

                    val bookname = writerbooks?.get(position)?.BookName

                    findNavController().navigate(
                        R.id.action_bookDetailsFragment2_self,
                        Bundle().apply {
                            putString("bookname", "$bookname")
                            putString("fromname", "$fromdetails")
                        })
                }


            })

            adapter2.setOnItemClickListener(object : newAdapterforbooks.onBookItemClickListener {
                override fun onItemClick(position: Int) {

                    val bookname = categorybooks?.get(position)?.BookName

                    findNavController().navigate(
                        R.id.action_bookDetailsFragment2_self,
                        Bundle().apply {
                            putString("bookname", "$bookname")
                            putString("fromname", "$fromdetails")
                        })
                }


            })
        }else{
            adapter1.setOnItemClickListener(object : newAdapterforbooks.onBookItemClickListener {
                override fun onItemClick(position: Int) {

                    val bookname = writerbooks?.get(position)?.BookName

                    findNavController().navigate(
                        R.id.action_bookDetailsFragment_self,
                        Bundle().apply {
                            putString("bookname", "$bookname")
                            putString("fromname", "$fromdetails")
                        })
                }


            })

            adapter2.setOnItemClickListener(object : newAdapterforbooks.onBookItemClickListener {
                override fun onItemClick(position: Int) {

                    val bookname = categorybooks?.get(position)?.BookName

                    findNavController().navigate(
                        R.id.action_bookDetailsFragment_self,
                        Bundle().apply {
                            putString("bookname", "$bookname")
                            putString("fromname", "$fromdetails")
                        })
                }


            })

        }

        return view
    }
}