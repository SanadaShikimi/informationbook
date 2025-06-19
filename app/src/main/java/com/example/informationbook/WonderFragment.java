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
        View view = inflater.inflate(R.layout.fragment_