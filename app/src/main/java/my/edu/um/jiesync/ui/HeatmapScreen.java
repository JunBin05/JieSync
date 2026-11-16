package my.edu.um.jiesync.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.google.android.material.card.MaterialCardView;
import my.edu.um.jiesync.MainActivity;
import my.edu.um.jiesync.R;

public class HeatmapScreen extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_heatmap, container, false);

        // Tapping the nearby restroom card inspects the issue on Verify Fix (Screen 04)
        MaterialCardView facilityCard = view.findViewById(R.id.card_heatmap);

        if (facilityCard != null) {
            facilityCard.setOnClickListener(v -> {
                if (getActivity() instanceof MainActivity) {
                    ((MainActivity) getActivity()).loadFragment(new VerifyFixScreen());
                }
            });
        }

        return view;
    }
}
