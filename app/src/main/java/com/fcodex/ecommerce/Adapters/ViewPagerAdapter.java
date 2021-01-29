package com.fcodex.ecommerce.Adapters;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class ViewPagerAdapter extends FragmentStatePagerAdapter {
    private Context context;
    public ViewPagerAdapter(@NonNull FragmentManager fm, Context context) {
        super(fm);
        this.context=context;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        /*switch (position){
            case 0:
                return MenFragment.newInstance();
            case 1:
                return WomenFragment.newInstance();
            case 2:
                return KidsFragment.newInstance();
        }*/
        return null;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0:
                return "Men";
            case 1:
                return "Women";
            case 2:
                return "Kids";
        }
        return super.getPageTitle(position);
    }
}
