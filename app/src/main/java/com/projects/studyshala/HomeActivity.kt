package com.projects.studyshala

import android.os.Bundle
import android.view.MenuItem
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.navigation.NavigationView
import com.projects.studyshala.databinding.ActivityHomeBinding
import com.projects.studyshala.fragments.AboutFragment
import com.projects.studyshala.fragments.CoursesFragment
import com.projects.studyshala.fragments.HomeFragment
import com.projects.studyshala.fragments.SettingsFragment
import com.projects.studyshala.fragments.ShareFragment

class HomeActivity : AppCompatActivity() , NavigationView.OnNavigationItemSelectedListener{
    private lateinit var binding:ActivityHomeBinding
    private lateinit var drawerLayout:DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)


        //step1--> declare and initialize drawer layout
        drawerLayout =binding.drawerLayout
        //step2--> initialize the toolbar
        setSupportActionBar(binding.toolbar)
        //step3--> initialize the navigation view
        val navigationView = findViewById<NavigationView>(R.id.nav_view)
        navigationView.setNavigationItemSelectedListener(this)
        //step4--> set the navigation menu on the actionbar toggle
        val toggle = ActionBarDrawerToggle(this, drawerLayout,binding.toolbar, R.string.open_drawer, R.string.close_drawer)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        //step5--> create replace fragment method
        //step6--> create onbackpressed method
        //step7--> set the default fragment
        if (savedInstanceState==null){
            replaceFragment(HomeFragment())
            navigationView.setCheckedItem(R.id.nav_home)
        }
        //step8--> create onNavigationItemSelected






        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_home -> {
                replaceFragment(HomeFragment())
                item.isChecked = true // Set checked state
            }
            R.id.nav_courses -> {
                replaceFragment(CoursesFragment())
                item.isChecked = true // Set checked state
            }
            R.id.nav_share -> {
                replaceFragment(ShareFragment())
                item.isChecked = true // Set checked state
            }
            R.id.nav_about -> {
                replaceFragment(AboutFragment())
                item.isChecked = true // Set checked state
            }
            R.id.nav_settings -> {
                replaceFragment(SettingsFragment())
                item.isChecked = true // Set checked state
            }
        }
        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }

    private fun replaceFragment(fragment:Fragment){
        val transaction:FragmentTransaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container, fragment)
        transaction.commit()

    }

    override fun onBackPressed() {
        super.onBackPressed()
        if (drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START)
        }else{
            onBackPressedDispatcher.onBackPressed()
        }

    }
}