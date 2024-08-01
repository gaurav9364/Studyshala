package com.projects.studyshala

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.projects.studyshala.databinding.ActivityAndroidKotlinCourseDetailsBinding

class AndroidKotlinCourseDetails : AppCompatActivity() {
    private lateinit var binding: ActivityAndroidKotlinCourseDetailsBinding

    private lateinit var listView: ListView
    private val videoTitles = arrayOf("1. Splash Screen",
        "2. Intents", "3. ListView","4. RecyclerView",
        "5. Spinner", "6. Alert Dialog Box","7. Fragments",
        "8. ViewPager2", "9. Navigation Drawer", "10. Bottom Navigation",
        "11. Login and Signup using Firebase Authentication",
        "12. Login and Signup using SQLite",
        "13. Login and Signup using Firebase Realtime Database",
        "14. Weather App with Retrofit")
    private val videoIds = arrayOf("Eu7lkrDjBq8", "CAPlP2QcHnM", "BntLlH4eSYA",
        "UDfyZLWyyVM","JDbsuACIoQE","uhXn8RcKKbI","fT4MVQZWPRg","K36QqLnXqG8",
        "zBETkYi9Z4E","zBETkYi9Z4E","A4Vj4cHsQjE","zz659HPTe6M","MhLkezKsHbY", "Kn6vUH1uJT4")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAndroidKotlinCourseDetailsBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, videoTitles)
        binding.listViewAndroidKotlin.adapter = adapter

        binding.listViewAndroidKotlin.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
            val videoId = videoIds[position]
            openYouTubeVideo(videoId)
        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun openYouTubeVideo(videoId: String) {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/$videoId"))
        startActivity(intent)
    }
}