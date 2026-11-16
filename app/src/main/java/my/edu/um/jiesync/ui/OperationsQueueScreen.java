package my.edu.um.jiesync.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import my.edu.um.jiesync.MainActivity;
import my.edu.um.jiesync.R;

public class OperationsQueueScreen extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_operations_queue, container, false);

        Button btnAccept = view.findViewById(R.id.btn_accept_dispatch);
        Button btnViewDetails = view.findViewById(R.id.btn_view_details);
        View tabStaffShift = view.findViewById(R.id.tab_ops_shift);

        // Accept & Dispatch -> simulates assigning technician
        // TODO (Member 5): Update Firestore status to 'IN_PROGRESS'
        if (btnAccept != null) {
            btnAccept.setOnClickListener(v -> Toast.makeText(
                    requireContext(),
                    "Dispatch Accepted. Technician assigned to KK10 Block B.",
                    Toast.LENGTH_SHORT
            ).show());
        }

        // View Details -> shows ticket metadata dialog/toast
        if (btnViewDetails != null) {
            btnViewDetails.setOnClickListener(v -> Toast.makeText(
                    requireContext(),
                    "Ticket #JS-1042: Urgent overflow reported at KK10.",
                    Toast.LENGTH_SHORT
            ).show());
        }

        // Tapping Staff Shift lets the contractor sign out back to login
        if (tabStaffShift != null) {
            tabStaffShift.setOnClickListener(v -> {
                if (getActivity() instanceof MainActivity) {
                    ((MainActivity) getActivity()).loadFragment(new LoginScreen(), false);
                }
            });
        }

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        // Hide standard student bottom nav on staff screen
        if (getActivity() != null) {
            View bottomNav = getActivity().findViewById(R.id.bottom_navigation);
            if (bottomNav != null) {
                bottomNav.setVisibility(View.GONE);
            }
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        // Restore student bottom nav when leaving staff screen
        if (getActivity() != null) {
            View bottomNav = getActivity().findViewById(R.id.bottom_navigation);
            if (bottomNav != null) {
                bottomNav.setVisibility(View.VISIBLE);
            }
        }
    }
}