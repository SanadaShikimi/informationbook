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

public class CountryFragment extends Fragment {

    private static final String ARG_COUNTRY = "country";
    private String countryName;
    private LinearLayout loadingLayout;
    private ScrollView contentLayout;

    public static CountryFragment newInstance(String country) {
        CountryFragment fragment = new CountryFragment();
        Bundle args = new Bundle();
        args.putString(ARG_COUNTRY, country);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            countryName = getArguments().getString(ARG_COUNTRY);
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_country, container, false);

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
        }, 1500); // 1.5 second delay

        return view;
    }

    private void loadContent(View view) {
        ImageView flagImage = view.findViewById(R.id.flagImage);
        TextView capitalText = view.findViewById(R.id.capitalText);
        TextView largestCityText = view.findViewById(R.id.largestCityText);
        TextView languageText = view.findViewById(R.id.languageText);
        TextView areaText = view.findViewById(R.id.areaText);
        TextView currencyText = view.findViewById(R.id.currencyText);
        TextView descriptionText = view.findViewById(R.id.descriptionText);

        switch (countryName) {
            case "United Kingdom":
                flagImage.setImageResource(R.drawable.flag_uk);
                capitalText.setText("Capital: London");
                largestCityText.setText("Largest City: London");
                languageText.setText("National Language: English");
                areaText.setText("Total Area: 242,495 km2");
                currencyText.setText("Currency: GBP");
                descriptionText.setText("The United Kingdom of Great Britain and Northern Ireland, commonly known as the United Kingdom (UK) or Britain, is a country in Northwestern Europe, off the coast of the continental mainland. It comprises England, Scotland, Wales, and Northern Ireland. The UK includes the island of Great Britain, the north-eastern part of the island of Ireland, and most of the smaller islands within the British Isles, covering 94,354 square miles (244,376 km2). Northern Ireland shares a land border with the Republic of Ireland; otherwise, the United Kingdom is surrounded by the Atlantic Ocean, the North Sea, the English Channel, the Celtic Sea, and the Irish Sea. The UK maintains sovereignty over the British Overseas Territories.");
                break;
            case "France":
                flagImage.setImageResource(R.drawable.flag_france);
                capitalText.setText("Capital: Paris");
                largestCityText.setText("Largest City: Paris");
                languageText.setText("National Language: French");
                areaText.setText("Total Area: 643,801 km2");
                currencyText.setText("Currency: EUR");
                descriptionText.setText("France, officially the French Republic, is a country located primarily in Western Europe. It also comprises of overseas regions and territories in the Americas and the Atlantic, Pacific and Indian Oceans, giving it one of the largest discontiguous exclusive economic zones in the world. Metropolitan France shares borders with Belgium and Luxembourg to the north, Germany to the northeast, Switzerland to the east, Italy and Monaco to the southeast, Andorra and Spain to the south, and a maritime border with the United Kingdom to the northwest. Its metropolitan area extends from the Rhine to the Atlantic Ocean and from the Mediterranean Sea to the English Channel and the North Sea.");
                break;
            case "Italy":
                flagImage.setImageResource(R.drawable.flag_italy);
                capitalText.setText("Capital: Rome");
                largestCityText.setText("Largest City: Rome");
                languageText.setText("National Language: Italian");
                areaText.setText("Total Area: 301,340 km2");
                currencyText.setText("Currency: EUR");
                descriptionText.setText("Italy, officially the Italian Republic, is a country consisting of a peninsula delimited by the Alps and several islands surrounding it, whose territory largely coincides with the homonymous geographical region. Italy is located in the middle of the Mediterranean Sea, in Southern Europe; it is also considered part of Western Europe. A unitary parliamentary republic with Rome as its capital and largest city, the country covers a total area of 301,230 km2 and shares land borders with France, Switzerland, Austria, Slovenia and the enclaved microstates of Vatican City and San Marino. Italy has a territorial exclave in Switzerland, Campione.");
                break;
        }
    }
}