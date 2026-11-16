package my.edu.um.jiesync;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import my.edu.um.jiesync.ui.HeatmapScreen;
import my.edu.um.jiesync.ui.LoginScreen;
import my.edu.um.jiesync.ui.ProfileLeaderboardScreen;
import my.edu.um.jiesync.ui.ReportIncidentScreen;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);

        // Start at Screen 01 (Login)
        if (savedInstanceState == null) {
            loadFragment(new LoginScreen(), false);
        }

        if (bottomNav != null) {
            bottomNav.setOnItemSelectedListener(item -> {
                int itemId = item.getItemId();
                if (itemId == R.id.nav_heatmap) {
                    loadFragment(new HeatmapScreen(), true);
                    return true;
                } else if (itemId == R.id.nav_report) {
                    loadFragment(new ReportIncidentScreen(), true);
                    return true;
                } else if (itemId == R.id.nav_profile) {
                    loadFragment(new ProfileLeaderboardScreen(), true);
                    return true;
                }
                return false;
            });
        }
    }

    public void loadFragment(Fragment fragment) {
        loadFragment(fragment, true);
    }

    public void loadFragment(Fragment fragment, boolean addToBackStack) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, fragment);
        if (addToBackStack) {
            transaction.addToBackStack(null);
        }
        transaction.commit();
    }
}