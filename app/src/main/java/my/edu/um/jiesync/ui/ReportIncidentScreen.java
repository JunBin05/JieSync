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

public class ReportIncidentScreen extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_report_incident, container, false);

        Button btnSubmit = view.findViewById(R.id.btn_submit_report);

        if (btnSubmit != null) {
            btnSubmit.setOnClickListener(v -> {
                Toast.makeText(requireContext(), "Incident Submitted! +10 XP awarded.", Toast.LENGTH_SHORT).show();
                if (getActivity() instanceof MainActivity) {
                    ((MainActivity) getActivity()).loadFragment(new HeatmapScreen());
                }
            });
        }

        return view;
    }
}