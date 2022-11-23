package com.example.etpproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.room.Room
import com.example.etpproject.databinding.ActivityHomeBinding
import com.example.etpproject.userLoginAndSignUp.UserDatabase
import kotlinx.android.synthetic.main.fragment_profile.*

var globalusername = ""
var globalfullname = ""

class HomeActivity : AppCompatActivity(){

    private lateinit var binding: ActivityHomeBinding

    lateinit var database1: UserDatabase

    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        replaceFragment(HomeLayouterFragment())

        val usernametext = intent.getStringExtra("username")

        database1 = Room.databaseBuilder(this, UserDatabase::class.java, "user_database").allowMainThreadQueries().build()

        val fullname = database1.userDao().getfullname(usernametext)

        if (usernametext != null) {
            globalusername = usernametext
        }
        globalfullname = fullname

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
}












