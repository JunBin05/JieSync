package my.edu.um.jiesync.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import my.edu.um.jiesync.MainActivity
import my.edu.um.jiesync.R

class ReportIncidentScreen : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_report_incident, container, false)

        val btnSubmit = view.findViewById<Button>(R.id.btn_submit_report)

        btnSubmit?.setOnClickListener {
            Toast.makeText(requireContext(), "Incident Submitted! +10 XP awarded.", Toast.LENGTH_SHORT).show()
            (activity as? MainActivity)?.loadFragment(HeatmapScreen())
        }

        return view
    }
}