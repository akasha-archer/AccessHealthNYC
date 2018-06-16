package com.akashaarcher.android.healthcarenyc.view;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.akashaarcher.android.healthcarenyc.R;
import com.akashaarcher.android.healthcarenyc.view.adapter.UserProfileViewPagerAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * Created by akashaarcher on 4/4/18.
 */

public class UserProfileActivity extends AppCompatActivity {

    private UserProfileViewPagerAdapter pagerAdapter;

    @BindView(R.id.user_profile_tabs)
    TabLayout tabLayout;

    @BindView(R.id.user_profile_view_pager)
    ViewPager viewPager;

    @BindView(R.id.bottom_nav_layout)
    BottomNavigationView bottomNav;

    FindServiceFragment findServiceFragment = new FindServiceFragment();
    UserProfileFragment profileFragment = new UserProfileFragment();
    CalculateCostFragment calculateCostFragment = new CalculateCostFragment();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_user_profile);

        ButterKnife.bind(this);

        pagerAdapter = new UserProfileViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(pagerAdapter);
        tabLayout.setupWithViewPager(viewPager);

        bottomNav.setPadding(0, 0, 0, 0);
        bottomNav.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {

                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.action_search:
                                launchFragment(findServiceFragment);
                                break;

                            case R.id.action_profile:
                                launchFragment(profileFragment);
                                break;

                            case R.id.action_calculate:
                                launchFragment(calculateCostFragment);
                                break;
                        }
                        return true;
                    }
                }
        );

    }

    private void launchFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.main_container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

}
