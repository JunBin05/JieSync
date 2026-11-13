package my.edu.um.jiesync.ui

import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.google.android.material.button.MaterialButton
import my.edu.um.jiesync.MainActivity
import my.edu.um.jiesync.R

class LoginScreen : Fragment() {

    private enum class UserRole { COMMUNITY, OPERATIONS }
    private var selectedRole = UserRole.COMMUNITY

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_login, container, false)

        val btnRoleCommunity = view.findViewById<MaterialButton>(R.id.btn_role_community)
        val btnRoleOperations = view.findViewById<MaterialButton>(R.id.btn_role_operations)
        val btnLogin = view.findViewById<Button>(R.id.btn_login)

        // Helper to update the pill button visuals based on active role
        fun updateRoleUI() {
            val cobaltBlue = ContextCompat.getColor(requireContext(), R.color.cobalt_blue)
            val slateGray = ContextCompat.getColor(requireContext(), R.color.slate_gray)
            val pureWhite = ContextCompat.getColor(requireContext(), R.color.pure_white)

            if (selectedRole == UserRole.COMMUNITY) {
                // Active Community
                btnRoleCommunity?.backgroundTintList = ColorStateList.valueOf(cobaltBlue)
                btnRoleCommunity?.setTextColor(pureWhite)
                // Inactive Operations
                btnRoleOperations?.backgroundTintList = ColorStateList.valueOf(Color.TRANSPARENT)
                btnRoleOperations?.setTextColor(slateGray)
            } else {
                // Active Operations
                btnRoleOperations?.backgroundTintList = ColorStateList.valueOf(cobaltBlue)
                btnRoleOperations?.setTextColor(pureWhite)
                // Inactive Community
                btnRoleCommunity?.backgroundTintList = ColorStateList.valueOf(Color.TRANSPARENT)
                btnRoleCommunity?.setTextColor(slateGray)
            }
        }

        // Tap Community (Student) Role
        btnRoleCommunity?.setOnClickListener {
            selectedRole = UserRole.COMMUNITY
            updateRoleUI()
        }

        // Tap Operations Role
        btnRoleOperations?.setOnClickListener {
            selectedRole = UserRole.OPERATIONS
            updateRoleUI()
        }

        // Tap Log In Button -> Routes based on selected role
        btnLogin?.setOnClickListener {
            when (selectedRole) {
                UserRole.COMMUNITY -> {
                    Toast.makeText(requireContext(), "Logged in as Student", Toast.LENGTH_SHORT).show()
                    (activity as? MainActivity)?.loadFragment(HeatmapScreen())
                }
                UserRole.OPERATIONS -> {
                    Toast.makeText(requireContext(), "Logged in as Operator / Contractor", Toast.LENGTH_SHORT).show()
                    (activity as? MainActivity)?.loadFragment(OperationsQueueScreen())
                }
            }
        }

        return view
    }
}