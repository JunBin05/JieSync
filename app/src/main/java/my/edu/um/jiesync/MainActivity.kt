package my.edu.um.jiesync

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import my.edu.um.jiesync.ui.HeatmapScreen
import my.edu.um.jiesync.ui.LoginScreen
import my.edu.um.jiesync.ui.ProfileLeaderboardScreen
import my.edu.um.jiesync.ui.ReportIncidentScreen

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomNav = findViewById<BottomNavigationView>(R.id.bottom_navigation)

        // Start at Screen 01 (Login)
        if (savedInstanceState == null) {
            loadFragment(LoginScreen(), addToBackStack = false)
        }

        bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_heatmap -> {
                    loadFragment(HeatmapScreen())
                    true
                }
                R.id.nav_report -> {
                    loadFragment(ReportIncidentScreen())
                    true
                }
                R.id.nav_profile -> {
                    loadFragment(ProfileLeaderboardScreen())
                    true
                }
                else -> false
            }
        }
    }

    fun loadFragment(fragment: Fragment, addToBackStack: Boolean = true) {
        val transaction = supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
        if (addToBackStack) {
            transaction.addToBackStack(null)
        }
        transaction.commit()
    }
}