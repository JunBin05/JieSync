package my.edu.um.jiesync.ui;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import com.google.android.material.button.MaterialButton;
import my.edu.um.jiesync.MainActivity;
import my.edu.um.jiesync.R;

public class LoginScreen extends Fragment {

    private enum UserRole { COMMUNITY, OPERATIONS }
    private UserRole selectedRole = UserRole.COMMUNITY;

    private MaterialButton btnRoleCommunity;
    private MaterialButton btnRoleOperations;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);

        btnRoleCommunity = view.findViewById(R.id.btn_role_community);
        btnRoleOperations = view.findViewById(R.id.btn_role_operations);
        Button btnLogin = view.findViewById(R.id.btn_login);

        // Tap Community (Student) Role
        if (btnRoleCommunity != null) {
            btnRoleCommunity.setOnClickListener(v -> {
                selectedRole = UserRole.COMMUNITY;
                updateRoleUI();
            });
        }

        // Tap Operations Role
        if (btnRoleOperations != null) {
            btnRoleOperations.setOnClickListener(v -> {
                selectedRole = UserRole.OPERATIONS;
                updateRoleUI();
            });
        }

        // Tap Log In Button -> Routes based on selected role
        if (btnLogin != null) {
            btnLogin.setOnClickListener(v -> {
                if (getActivity() instanceof MainActivity) {
                    MainActivity activity = (MainActivity) getActivity();
                    if (selectedRole == UserRole.COMMUNITY) {
                        Toast.makeText(requireContext(), "Logged in as Student", Toast.LENGTH_SHORT).show();
                        activity.loadFragment(new HeatmapScreen());
                    } else if (selectedRole == UserRole.OPERATIONS) {
                        Toast.makeText(requireContext(), "Logged in as Operator / Contractor", Toast.LENGTH_SHORT).show();
                        activity.loadFragment(new OperationsQueueScreen());
                    }
                }
            });
        }

        return view;
    }

    private void updateRoleUI() {
        int cobaltBlue = ContextCompat.getColor(requireContext(), R.color.cobalt_blue);
        int slateGray = ContextCompat.getColor(requireContext(), R.color.slate_gray);
        int pureWhite = ContextCompat.getColor(requireContext(), R.color.pure_white);

        if (selectedRole == UserRole.COMMUNITY) {
            // Active Community
            if (btnRoleCommunity != null) {
                btnRoleCommunity.setBackgroundTintList(ColorStateList.valueOf(cobaltBlue));
                btnRoleCommunity.setTextColor(pureWhite);
            }
            // Inactive Operations
            if (btnRoleOperations != null) {
                btnRoleOperations.setBackgroundTintList(ColorStateList.valueOf(Color.TRANSPARENT));
                btnRoleOperations.setTextColor(slateGray);
            }
        } else {
            // Active Operations
            if (btnRoleOperations != null) {
                btnRoleOperations.setBackgroundTintList(ColorStateList.valueOf(cobaltBlue));
                btnRoleOperations.setTextColor(pureWhite);
            }
            // Inactive Community
            if (btnRoleCommunity != null) {
                btnRoleCommunity.setBackgroundTintList(ColorStateList.valueOf(Color.TRANSPARENT));
                btnRoleCommunity.setTextColor(slateGray);
            }
        }
    }
}