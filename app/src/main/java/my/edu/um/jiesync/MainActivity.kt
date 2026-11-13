package my.edu.um.jiesync

import android.os.Bundle
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var container: FrameLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        container = findViewById(R.id.nav_host_container)
        val bottomNav = findViewById<BottomNavigationView>(R.id.bottom_navigation)

        // Show Heatmap by default
        loadLayout(R.layout.fragment_heatmap)

        // Switch screens on tab click
        bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_heatmap -> {
                    loadLayout(R.layout.fragment_heatmap)
                    true
                }
                R.id.nav_report -> {
                    loadLayout(R.layout.fragment_report_incident)
                    true
                }
                R.id.nav_profile -> {
                    loadLayout(R.layout.fragment_profile)
                    true
                }
                else -> false
            }
        }
    }

    private fun loadLayout(layoutResId: Int) {
        container.removeAllViews()
        val view = layoutInflater.inflate(layoutResId, container, false)
        container.addView(view)
    }
}