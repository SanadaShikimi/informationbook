package com.example.informationbook;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class WondersFragmentAdapter extends FragmentStateAdapter {

    public WondersFragmentAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return WonderFragment.newInstance("Machu Picchu");
            case 1:
                return WonderFragment.newInstance("Chichen Itza");
            case 2:
                return WonderFragment.newInstance("Colosseum");
            default:
                return WonderFragment.newInstance("Machu Picchu");
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}