package com.example.informationbook;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class LeadersFragmentAdapter extends FragmentStateAdapter {

    public LeadersFragmentAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return LeaderFragment.newInstance("Joe Biden");
            case 1:
                return LeaderFragment.newInstance("Emmanuel Macron");
            case 2:
                return LeaderFragment.newInstance("Giorgia Meloni");
            default:
                return LeaderFragment.newInstance("Joe Biden");
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}