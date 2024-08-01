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
import com.projects.studyshala.databinding.ActivityWebDevelopmentCourseBinding

class WebDevelopmentCourseActivity : AppCompatActivity() {
    private lateinit var binding: ActivityWebDevelopmentCourseBinding

    private lateinit var listView: ListView
    private val videoTitles = arrayOf("1. Introduction",
        "2. Lecture 1", "3. Lecture 2","4. Lecture 3",
        "5. Lecture 4- Structuring a Mega Project", "6. CSS - Lecture 5","7. Lecture 6",
        "8. CSS - Lecture 7", "9. Lecture 8", "10. Lecture 9",
        "11. Lecture 10",
        "12. Lecture 11",
        "13. Lecture 12",
        "14. Lecture 13- Personal Portfolio website using HTML, CSS and JavaScript (from scratch)")
    private val videoIds = arrayOf("l1EssrLxt7E", "Rek0NWPCNOc", "2QR11oDukn4",
        "jRAZlTEZi9I","61ppyY5rUB0","sqJ6xZ9mUwE","4nC4VXHlys8","C01LeeMhwHc",
        "wKPlQkOdpFQ","6Cpd63_WXdI","bgKYobOXTZ0","EkcthUMl4","p870o46o1bM", "oFnIe-RpkE4")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWebDevelopmentCourseBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, videoTitles)
        binding.listViewWebDev.adapter = adapter

        binding.listViewWebDev.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
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