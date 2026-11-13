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

class OperationsQueueScreen : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_operations_queue, container, false)

        val btnAccept = view.findViewById<Button>(R.id.btn_accept_dispatch)
        val btnViewDetails = view.findViewById<Button>(R.id.btn_view_details)
        val tabStaffShift = view.findViewById<View>(R.id.tab_ops_shift)

        // Accept & Dispatch -> simulates assigning technician
        // TODO (Member 5): Update Firestore status to 'IN_PROGRESS'
        btnAccept?.setOnClickListener {
            Toast.makeText(
                requireContext(),
                "Dispatch Accepted. Technician assigned to KK10 Block B.",
                Toast.LENGTH_SHORT
            ).show()
        }

        // View Details -> shows ticket metadata dialog/toast
        btnViewDetails?.setOnClickListener {
            Toast.makeText(
                requireContext(),
                "Ticket #JS-1042: Urgent overflow reported at KK10.",
                Toast.LENGTH_SHORT
            ).show()
        }

        // Tapping Staff Shift lets the contractor sign out back to login
        tabStaffShift?.setOnClickListener {
            (activity as? MainActivity)?.loadFragment(LoginScreen(), addToBackStack = false)
        }

        return view
    }

    override fun onResume() {
        super.onResume()
        // Hide standard student bottom nav on staff screen
        activity?.findViewById<View>(R.id.bottom_navigation)?.visibility = View.GONE
    }

    override fun onStop() {
        super.onStop()
        // Restore student bottom nav when leaving staff screen
        activity?.findViewById<View>(R.id.bottom_navigation)?.visibility = View.VISIBLE
    }
}