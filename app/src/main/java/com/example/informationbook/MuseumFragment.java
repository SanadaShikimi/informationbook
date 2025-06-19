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

public class MuseumFragment extends Fragment {

    private static final String ARG_MUSEUM = "museum";
    private String museumName;
    private LinearLayout loadingLayout;
    private ScrollView contentLayout;

    public static MuseumFragment newInstance(String museum) {
        MuseumFragment fragment = new MuseumFragment();
        Bundle args = new Bundle();
        args.putString(ARG_MUSEUM, museum);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            museumName = getArguments().getString(ARG_MUSEUM);
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_museum, container, false);

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
        ImageView museumImage = view.findViewById(R.id.museumImage);
        TextView nameText = view.findViewById(R.id.nameText);
        TextView locationText = view.findViewById(R.id.locationText);
        TextView establishedText = view.findViewById(R.id.establishedText);
        TextView visitorsText = view.findViewById(R.id.visitorsText);
        TextView collectionText = view.findViewById(R.id.collectionText);
        TextView descriptionText = view.findViewById(R.id.descriptionText);

        switch (museumName) {
            case "Louvre":
                museumImage.setImageResource(R.drawable.museum_louvre);
                nameText.setText("The Louvre Museum");
                locationText.setText("Location: Paris, France");
                establishedText.setText("Established: 1793");
                visitorsText.setText("Annual Visitors: ~10 million");
                collectionText.setText("Collection: 380,000 objects");
                descriptionText.setText("The Louvre, or the Louvre Museum, is the world's most-visited museum, and a historic landmark in Paris, France. It is the home of some of the best-known works of art, including the Mona Lisa and the Venus de Milo. A central landmark of the city, it is located on the Right Bank of the Seine in the city's 1st arrondissement. At any given point in time, approximately 35,000 objects from prehistory to the 21st century are being exhibited over an area of 72,735 square meters. The Louvre received 8.6 million visitors in 2019. The museum is housed in the Louvre Palace, originally built in the late 12th century under Philip II.");
                break;
            case "British Museum":
                museumImage.setImageResource(R.drawable.museum_british);
                nameText.setText("The British Museum");
                locationText.setText("Location: London, United Kingdom");
                establishedText.setText("Established: 1753");
                visitorsText.setText("Annual Visitors: ~6 million");
                collectionText.setText("Collection: 8 million objects");
                descriptionText.setText("The British Museum is a public museum dedicated to human history, art and culture located in the Bloomsbury area of London. Its permanent collection of eight million works is among the largest and most comprehensive in existence. It documents the story of human culture from its beginnings to the present. The British Museum was the first public national museum in the world. The museum was established in 1753, largely based on the collections of the Anglo-Irish physician and scientist Sir Hans Sloan. The museum first opened to the public on 15 January 1759, in Montagu House, on the site of the current building.");
                break;
            case "Vatican Museums":
                museumImage.setImageResource(R.drawable.museum_vatican);
                nameText.setText("Vatican Museums");
                locationText.setText("Location: Vatican City");
                establishedText.setText("Established: 1506");
                visitorsText.setText("Annual Visitors: ~6 million");
                collectionText.setText("Collection: 70,000 works");
                descriptionText.setText("The Vatican Museums are the public museums of the Vatican City. They display works from the immense collection amassed by the Catholic Church and the papacy throughout the centuries, including several of the most renowned Roman sculptures and most important masterpieces of Renaissance art in the world. The museums contain roughly 70,000 works, of which 20,000 are on display. The Vatican Museums trace their origin to a single marble sculpture, purchased in the 16th century: Laocoön and His Sons was discovered in 1506 in a vineyard near the basilica of Santa Maria Maggiore and was purchased by Pope Julius II.");
                break;
        }
    }
}