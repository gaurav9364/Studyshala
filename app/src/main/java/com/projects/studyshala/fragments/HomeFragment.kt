package com.projects.studyshala.fragments

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.google.android.material.button.MaterialButton
import com.projects.studyshala.AndroidCourseActivity
import com.projects.studyshala.R
import com.projects.studyshala.WebDevelopmentCourseActivity

class HomeFragment : Fragment() {


    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        // Find the ImageView by ID
        val imageViewAndroid: ImageView = view.findViewById(R.id.imageViewAndroid)
        val androidTextView: TextView = view.findViewById(R.id.androidTextView)
        val imageViewWeb: ImageView = view.findViewById(R.id.imageViewWeb)
        val webTextView: TextView = view.findViewById(R.id.webTextView)
        val seeAllCoursesButton: MaterialButton = view.findViewById(R.id.see_all_courses)

        //ANDROID COURSE CLICK LISTENER
        imageViewAndroid.setOnClickListener {
            val intent = Intent(requireContext(), AndroidCourseActivity::class.java)
            startActivity(intent)
        }
        androidTextView.setOnClickListener {
            val intent = Intent(requireContext(), AndroidCourseActivity::class.java)
            startActivity(intent)
        }


        //WEB DEVELOPMENT COURSE CLICK LISTENER
        imageViewWeb.setOnClickListener {
            val intent = Intent(requireContext(), WebDevelopmentCourseActivity::class.java)
            startActivity(intent)
        }
        webTextView.setOnClickListener {
            val intent = Intent(requireContext(), WebDevelopmentCourseActivity::class.java)
            startActivity(intent)
        }

        //CLICK LISTENER FOR SEE ALL COURSES BUTTON
        seeAllCoursesButton.setOnClickListener {
            // Create a new instance of the CoursesFragment
            val fragment = CoursesFragment()
            // Replace the current fragment with the CoursesFragment
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .addToBackStack("my_fragment_transaction") // Optional: Add fragment to back stack for back navigation
                .commit()

        }
        return view
    }

}