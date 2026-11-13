package my.edu.um.jiesync.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import my.edu.um.jiesync.R

class ProfileLeaderboardScreen : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_profile, container, false)

        val btnBack = view.findViewById<TextView>(R.id.btn_back)
        btnBack?.setOnClickListener {
            parentFragmentManager.popBackStack()
        }

        return view
    }
}