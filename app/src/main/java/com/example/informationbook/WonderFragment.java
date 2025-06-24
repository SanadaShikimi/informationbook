package com.example.informationbook;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class WonderFragment extends Fragment {

    private static final String ARG_WONDER = "wonder";
    private String wonderName;
    private LinearLayout loadingLayout;
    private ScrollView contentLayout;

    public static WonderFragment newInstance(String wonder) {
        WonderFragment fragment = new WonderFragment();
        Bundle args = new Bundle();
        args.putString(ARG_WONDER, wonder);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            wonderName = getArguments().getString(ARG_WONDER);
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_wonder, container, false);

        loadingLayout = view.findViewById(R.id.loadingLayout);
        contentLayout = view.findViewById(R.id.contentLayout);

        // Show loading initially
        loadingLayout.setVisibility(View.VISIBLE);
        contentLayout.setVisibility(View.GONE);

        // Simulate loading delay
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                loadContent(view);
                loadingLayout.setVisibility(View.GONE);
                contentLayout.setVisibility(View.VISIBLE);
            }
        }, 1500);

        return view;
    }

    private void loadContent(View view) {
        ImageView wonderImage = view.findViewById(R.id.wonderImage);
        TextView nameText = view.findViewById(R.id.nameText);
        TextView locationText = view.findViewById(R.id.locationText);
        TextView builtText = view.findViewById(R.id.builtText);
        TextView heightText = view.findViewById(R.id.heightText);
        TextView civilizationText = view.findViewById(R.id.civilizationText);
        TextView descriptionText = view.findViewById(R.id.descriptionText);

        switch (wonderName) {
            case "Machu Picchu":
                wonderImage.setImageResource(R.drawable.wonder_machu_picchu);
                nameText.setText("Machu Picchu");
                locationText.setText("Location: Peru");
                builtText.setText("Built: 1450 AD");
                heightText.setText("Altitude: 2,430 meters");
                civilizationText.setText("Civilization: Inca Empire");
                descriptionText.setText("Machu Picchu is a 15th-century Inca citadel located in the Eastern Cordillera of southern Peru on a 2,430-meter mountain ridge. Often referred to as the 'Lost City of the Incas', it is the most familiar icon of Inca civilization. The Incas built the estate around 1450 but abandoned it a century later at the time of the Spanish conquest. Although known to locals, it was not known to the Spanish during the colonial period and remained unknown to the outside world until American historian Hiram Bingham brought it to international attention in 1911. Machu Picchu was built in the classical Inca style, with polished dry-stone walls. Its three primary structures are the Intihuatana, the Temple of the Sun, and the Room of the Three Windows.");
                break;
            case "Chichen Itza":
                wonderImage.setImageResource(R.drawable.wonder_chichen_itza);
                nameText.setText("Chichen Itza");
                locationText.setText("Location: Mexico");
                builtText.setText("Built: 600-1200 AD");
                heightText.setText("Pyramid Height: 30 meters");
                civilizationText.setText("Civilization: Maya");
                descriptionText.setText("Chichen Itza was a large pre-Columbian city built by the Maya people of the Terminal Classic period. The archaeological site is located in Tinúm Municipality, Yucatán State, Mexico. Chichen Itza was a major focal point in the Northern Maya Lowlands from the Late Classic through the Terminal Classic and into the early portion of the Postclassic period. The site exhibits a multitude of architectural styles, reminiscent of styles seen in central Mexico and of the Puuc and Chenes styles of the Northern Maya lowlands. The most famous structure is El Castillo (the Castle), also known as the Temple of Kukulcán, a step pyramid that is 30 meters tall.");
                break;
            case "Colosseum":
                wonderImage.setImageResource(R.drawable.wonder_colosseum);
                nameText.setText("Colosseum");
                locationText.setText("Location: Rome, Italy");
                builtText.setText("Built: 70-80 AD");
                heightText.setText("Height: 48 meters");
                civilizationText.setText("Civilization: Roman Empire");
                descriptionText.setText("The Colosseum is an oval amphitheatre in the centre of the city of Rome, Italy, just east of the Roman Forum. It is the largest amphitheatre ever built, measuring approximately 189 meters long, 156 meters wide and 50 meters high. The Colosseum is built of travertine limestone, tuff, and brick-faced concrete. It could hold an estimated 50,000 to 80,000 spectators at various points in its history, having an average audience of some 65,000. It was used for gladiatorial contests and public spectacles such as mock naval battles, animal hunts, executions, re-enactments of famous battles, and dramas based on Classical mythology. The building ceased to be used for entertainment in the early medieval era.");
                break;
        }
    }
}