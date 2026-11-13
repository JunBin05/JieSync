package my.edu.um.jiesync.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.card.MaterialCardView
import my.edu.um.jiesync.MainActivity
import my.edu.um.jiesync.R

class HeatmapScreen : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_heatmap, container, false)

        // Tapping the nearby restroom card inspects the issue on Verify Fix (Screen 04)
        val facilityCard = view.findViewById<MaterialCardView>(R.id.card_detected_location)
            ?: view.findViewById(R.id.card_heatmap)

        facilityCard?.setOnClickListener {
            (activity as? MainActivity)?.loadFragment(VerifyFixScreen())
        }

        return view
    }
}