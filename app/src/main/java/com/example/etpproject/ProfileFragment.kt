package com.example.etpproject

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import kotlinx.android.synthetic.main.fragment_profile.*
import kotlinx.android.synthetic.main.fragment_profile.view.*
import kotlinx.android.synthetic.main.fragment_signup.view.*

class ProfileFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_profile, container, false)

        val fullnametv = view.findViewById<TextView>(R.id.uerfullnameprofile)
        val usernametv = view.findViewById<TextView>(R.id.usernameprofile)

        fullnametv.text = globalfullname
        usernametv.text = globalusername

        val logoutbtn = view.logoutbtn
        logoutbtn.setOnClickListener {
            val intent = Intent(requireContext(), MainActivity::class.java)
            startActivity(intent)
            HomeActivity().finish()

        }

        return view
    }
}

