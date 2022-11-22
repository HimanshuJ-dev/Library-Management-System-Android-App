package com.example.etpproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.room.Room
import com.example.etpproject.bookdatabasepackage.Books
import com.example.etpproject.bookdatabasepackage.BooksDatabase
import com.example.etpproject.databinding.ActivityHomeBinding
import com.example.etpproject.userLoginAndSignUp.UserDatabase

class HomeActivity : AppCompatActivity(), fragcomm {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        replaceFragment(HomeLayouterFragment())

        binding.bottomNavigationViewHomeActivity.setOnItemSelectedListener {

            when(it.itemId){
                R.id.homeitembottomnav -> replaceFragment(HomeLayouterFragment())
                R.id.genreitembottomnav -> replaceFragment(GenreLayouterFragment())
                R.id.proflieitembottomnav -> replaceFragment(ProfileFragment())

                else ->{

                }

            }

            true

        }

    }

    fun replaceFragment(fragment: Fragment){

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frameLayoutHomeActivity, fragment)
        fragmentTransaction.commit()

    }

    override fun passDataCom(name: String) {
        val bundle = Bundle()
        bundle.putString("name", name)

        val transaction = this.supportFragmentManager.beginTransaction()
        val fraggenrespe = genreSpecificFragment()
        fraggenrespe.arguments = bundle

        transaction.replace(R.id.frameLayoutHomeActivity, fraggenrespe)
        transaction.commit()
    }
}












