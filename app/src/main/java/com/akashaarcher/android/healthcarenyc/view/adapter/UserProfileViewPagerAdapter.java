package com.akashaarcher.android.healthcarenyc.view.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.akashaarcher.android.healthcarenyc.view.UserFavoritesFragment;
import com.akashaarcher.android.healthcarenyc.view.UserInfoFragment;

/**
 * Created by akashaarcher on 3/26/18.
 */

public class UserProfileViewPagerAdapter extends FragmentPagerAdapter {

    static final int INFO_INDEX = 0;
    static final int FAVORITES_INDEX = 1;
    private String tabTitles[] = new String[] { "My Info", "Favorites" };

    public UserProfileViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }


    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case INFO_INDEX:
                return new UserInfoFragment();
            case FAVORITES_INDEX:
                return new UserFavoritesFragment();
            default:
                throw new IllegalStateException("no more than 2 fragments");
        }
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles[position];
    }

}
