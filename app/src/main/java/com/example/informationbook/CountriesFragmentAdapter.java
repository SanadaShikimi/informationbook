package com.example.informationbook;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class CountriesFragmentAdapter extends FragmentStateAdapter {

    public CountriesFragmentAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return CountryFragment.newInstance("United Kingdom");
            case 1:
                return CountryFragment.newInstance("France");
            case 2:
                return CountryFragment.newInstance("Italy");
            default:
                return CountryFragment.newInstance("United Kingdom");
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}