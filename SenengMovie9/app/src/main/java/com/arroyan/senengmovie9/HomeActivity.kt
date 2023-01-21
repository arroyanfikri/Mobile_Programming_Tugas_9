package com.arroyan.senengmovie9

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.arroyan.senengmovie9.fragments.MovieFragment
import com.arroyan.senengmovie9.fragments.TvShowFragment
import com.arroyan.senengmovie9.fragments.ProfileFragment

class HomeActivity : AppCompatActivity() {

    private val movieFragment = MovieFragment()
    private val tvShowFragment = TvShowFragment()
    private val profileFragment = ProfileFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        replaceFragment(MovieFragment())

        val bottomNav = findViewById<BottomNavigationView>(R.id.bot_nav_menu)
        bottomNav.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.ic_movie -> replaceFragment(movieFragment)
                R.id.ic_tvShow -> replaceFragment(tvShowFragment)
                R.id.ic_profile -> replaceFragment(profileFragment)
            }
            true
        }

    }

    private fun replaceFragment(fragment: Fragment) {

        if (fragment != null) {
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.nav_host_controller, fragment)
            transaction.commit()
        }
    }
}