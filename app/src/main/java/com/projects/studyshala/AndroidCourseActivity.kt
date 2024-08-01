package com.projects.studyshala

import android.content.Intent
import android.os.Bundle
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.projects.studyshala.databinding.ActivityAndroidCourseBinding


class AndroidCourseActivity : AppCompatActivity() {
    private lateinit var binding:ActivityAndroidCourseBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAndroidCourseBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)

        binding.kotlinTextView.setOnClickListener() {
            val intent = Intent(this@AndroidCourseActivity, AndroidKotlinCourseDetails::class.java)
            startActivity(intent)
        }
        binding.javaTextView.setOnClickListener() {
            val intent = Intent(this@AndroidCourseActivity, AndroidJavaCourseDetails::class.java)
            startActivity(intent)
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}