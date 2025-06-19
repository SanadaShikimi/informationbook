package com.example.informationbook;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class MuseumsFragmentAdapter extends FragmentStateAdapter {

    public MuseumsFragmentAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return MuseumFragment.newInstance("Louvre");
            case 1:
                return MuseumFragment.newInstance("British Museum");
            case 2:
                return MuseumFragment.newInstance("Vatican Museums");
            default:
                return MuseumFragment.newInstance("Louvre");
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}