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

public class LeaderFragment extends Fragment {

    private static final String ARG_LEADER = "leader";
    private String leaderName;
    private LinearLayout loadingLayout;
    private ScrollView contentLayout;

    public static LeaderFragment newInstance(String leader) {
        LeaderFragment fragment = new LeaderFragment();
        Bundle args = new Bundle();
        args.putString(ARG_LEADER, leader);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            leaderName = getArguments().getString(ARG_LEADER);
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_leader, container, false);

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
        ImageView leaderImage = view.findViewById(R.id.leaderImage);
        TextView nameText = view.findViewById(R.id.nameText);
        TextView positionText = view.findViewById(R.id.positionText);
        TextView countryText = view.findViewById(R.id.countryText);
        TextView bornText = view.findViewById(R.id.bornText);
        TextView partyText = view.findViewById(R.id.partyText);
        TextView descriptionText = view.findViewById(R.id.descriptionText);

        switch (leaderName) {
            case "Joe Biden":
                leaderImage.setImageResource(R.drawable.leader_biden);
                nameText.setText("Joe Biden");
                positionText.setText("President of the United States");
                countryText.setText("Country: United States");
                bornText.setText("Born: November 20, 1942");
                partyText.setText("Political Party: Democratic");
                descriptionText.setText("Joseph Robinette Biden Jr. is an American politician who is the 46th and current president of the United States. A member of the Democratic Party, he previously served as the 47th vice president from 2009 to 2017 under Barack Obama and represented Delaware in the United States Senate from 1973 to 2009. Biden was born and raised in Scranton, Pennsylvania, and moved with his family to Delaware in 1953. He studied at the University of Delaware before earning his law degree from Syracuse University. He was elected to the New Castle County Council in 1970 and became the sixth-youngest senator in U.S. history when he was elected in 1972, at age 29.");
                break;
            case "Emmanuel Macron":
                leaderImage.setImageResource(R.drawable.leader_macron);
                nameText.setText("Emmanuel Macron");
                positionText.setText("President of France");
                countryText.setText("Country: France");
                bornText.setText("Born: December 21, 1977");
                partyText.setText("Political Party: Renaissance");
                descriptionText.setText("Emmanuel Jean-Michel Frédéric Macron is a French politician who has served as President of France since 2017. Ex officio, he is also one of the two Co-Princes of Andorra. Prior to his presidency, Macron served as Minister of Economy, Industry and Digital Affairs under President François Hollande from 2014 to 2016. Born in Amiens, he studied philosophy at Paris Nanterre University, later completing a master's degree in public affairs at Sciences Po and graduating from the École nationale d'administration in 2004. He worked as a senior civil servant at the Inspectorate General of Finances and later became an investment banker at Rothschild & Co.");
                break;
            case "Giorgia Meloni":
                leaderImage.setImageResource(R.drawable.leader_meloni);
                nameText.setText("Giorgia Meloni");
                positionText.setText("Prime Minister of Italy");
                countryText.setText("Country: Italy");
                bornText.setText("Born: January 15, 1977");
                partyText.setText("Political Party: Brothers of Italy");
                descriptionText.setText("Giorgia Meloni is an Italian politician who has served as Prime Minister of Italy since October 2022. A member of the Chamber of Deputies since 2006, she has led the Brothers of Italy political party since 2014, and she previously served as Minister of Youth from 2008 to 2011. Meloni became Italy's first female prime minister and, at 45, the youngest person to hold the office. Born in Rome, she joined the Youth Front in 1992 and later became involved in the National Alliance. She was elected to the Chamber of Deputies for the first time in 2006 as the youngest vice president in the chamber's history.");
                break;
        }
    }
}