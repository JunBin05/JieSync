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

public class VerifyFixScreen extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_verify_fix, container, false);

        Button btnConfirm = view.findViewById(R.id.btn_confirm_fixed);
        Button btnStillBroken = view.findViewById(R.id.btn_still_broken);

        if (btnConfirm != null) {
            btnConfirm.setOnClickListener(v -> {
                Toast.makeText(requireContext(), "Fix Confirmed! +5 XP awarded.", Toast.LENGTH_SHORT).show();
                if (getActivity() instanceof MainActivity) {
                    ((MainActivity) getActivity()).loadFragment(new ProfileLeaderboardScreen());
                }
            });
        }

        if (btnStillBroken != null) {
            btnStillBroken.setOnClickListener(v -> {
                Toast.makeText(requireContext(), "Reported still broken. Ticket re-opened.", Toast.LENGTH_SHORT).show();
                getParentFragmentManager().popBackStack();
            });
        }

        return view;
    }
}