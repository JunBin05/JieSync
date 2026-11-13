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

class VerifyFixScreen : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_verify_fix, container, false)

        val btnConfirm = view.findViewById<Button>(R.id.btn_confirm_fixed)
        val btnStillBroken = view.findViewById<Button>(R.id.btn_still_broken)

        btnConfirm?.setOnClickListener {
            Toast.makeText(requireContext(), "Fix Confirmed! +5 XP awarded.", Toast.LENGTH_SHORT).show()
            (activity as? MainActivity)?.loadFragment(ProfileLeaderboardScreen())
        }

        btnStillBroken?.setOnClickListener {
            Toast.makeText(requireContext(), "Reported still broken. Ticket re-opened.", Toast.LENGTH_SHORT).show()
            parentFragmentManager.popBackStack()
        }

        return view
    }
}