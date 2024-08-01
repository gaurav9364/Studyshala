package com.projects.studyshala.fragments

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.button.MaterialButton
import com.google.firebase.auth.FirebaseAuth
import com.projects.studyshala.LoginActivity
import com.projects.studyshala.R

class SettingsFragment : Fragment() {

    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_settings, container, false)
        val logoutButton : MaterialButton = view.findViewById(R.id.logoutButton)

        firebaseAuth = FirebaseAuth.getInstance()
        sharedPreferences = requireContext().getSharedPreferences("loginPrefs",
            Context.MODE_PRIVATE
        )


        logoutButton.setOnClickListener{
            // Sign out the current user from Firebase
            firebaseAuth.signOut()

            // Clear the login state from SharedPreferences
            saveLoginState(false)
            val intent = Intent(requireContext(), LoginActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
            requireActivity().finish()
        }
        return view
    }
    private fun saveLoginState(isLoggedIn: Boolean) {
        // Implement your logic to save the login state
        val editor = sharedPreferences.edit()
        editor.putBoolean("isLoggedIn", isLoggedIn)
        editor.apply()
    }
}