package com.example.etpproject

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class GenreFragment : Fragment() {

    private lateinit var fragcomm: fragcomm

    private lateinit var adapter : GenreListAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var genreArrayList: ArrayList<genreList>

    lateinit var genreImageID : Array<Int>
    lateinit var genreNameTitle : Array<String>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_genre, container, false)

        DataInitialize()
        val layoutManager = LinearLayoutManager(context)
        recyclerView = view.findViewById(R.id.recycler_view)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        adapter = GenreListAdapter(genreArrayList)
        recyclerView.adapter = adapter

        fragcomm = activity as fragcomm

        adapter.setOnItemClickListener(object : GenreListAdapter.onGenreItemClickListener{
            override fun onItemClick(position: Int){

                val title = genreNameTitle[position]
//                var homeActivity: HomeActivity = activity as HomeActivity
//                homeActivity.replaceFragment(genreSpecificFragment())

                //

                Toast.makeText(requireContext(), "$title", Toast.LENGTH_SHORT).show()

                findNavController().navigate(R.id.action_genreFragment_to_genreSpecificFragment, Bundle().apply {
                    putString("genrename", "$title")
                })

                //fragcomm.passDataCom(title)
                //view = inflater.inflate(R.layout.fragment_genre_specific, container, false)


            }


        })

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//
//        DataInitialize()
//        val layoutManager = LinearLayoutManager(context)
//        recyclerView = view.findViewById(R.id.recycler_view)
//        recyclerView.layoutManager = layoutManager
//        recyclerView.setHasFixedSize(true)
//        adapter = GenreListAdapter(genreArrayList)
//        recyclerView.adapter = adapter
//
//        fragcomm = activity as fragcomm
//
//        adapter.setOnItemClickListener(object : GenreListAdapter.onGenreItemClickListener{
//            override fun onItemClick(position: Int) {
//
//                val title = genreNameTitle[position]
////                var homeActivity: HomeActivity = activity as HomeActivity
////                homeActivity.replaceFragment(genreSpecificFragment())
////                Toast.makeText(requireContext(), "$title", Toast.LENGTH_SHORT).show()
//
//                fragcomm.passDataCom(title)
//
//
//
//            }
//
//
//        })

    }

    private fun DataInitialize(){
        genreArrayList = arrayListOf<genreList>()

        genreImageID = arrayOf(
            R.drawable.artsandentertainmentgenreimg,
            R.drawable.biographyandmemoirsgenreimg,
            R.drawable.businessandinvestinggenreimg,
            R.drawable.ic_baseline_person_24,
            R.drawable.comicsgenreimg,
            R.drawable.computerandtechnologygenreimg,
            R.drawable.foodwineandcookerygenreimg,
            R.drawable.engineeringgenreimg,
            R.drawable.ic_baseline_person_24,
            R.drawable.ic_baseline_person_24,
            R.drawable.healthmindandbosygenreimg,
            R.drawable.historygenreimg,
            R.drawable.religionandspiritualitygenreimg,
            R.drawable.romancegenreimg,
            R.drawable.selfhelpgenreimg

        )

        genreNameTitle = arrayOf(
            "Arts and Entertainment",
            "Biographies and Memoirs",
            "Business and Investing",
            "Children's Books",
            "Comics",
            "Computers and Technology",
            "Cookery, Food and Wine",
            "Engineering",
            "Fiction and Literature",
            "Foreign Language and Study Aids",
            "Health, Mind and Body",
            "History",
            "Religion and Spirituality",
            "Romance",
            "Self-Help"
        )

        for(i in genreImageID.indices){
            val genre = genreList(genreImageID[i], genreNameTitle[i])
            genreArrayList.add(genre)
        }



    }


}