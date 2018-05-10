package com.akashaarcher.android.healthcarenyc.view;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.TabLayout;
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
    private TabLayout tabLayout;
    private ViewPager viewPager;


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

        tabLayout = (TabLayout) findViewById(R.id.user_profile_tabs);
        viewPager = (ViewPager) findViewById(R.id.user_profile_view_pager);
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
                                FragmentTransaction homeFragTransaction = getSupportFragmentManager().beginTransaction();
                                homeFragTransaction.replace(R.id.main_container, findServiceFragment);
                                homeFragTransaction.commit();
                                break;

                            case R.id.action_profile:
                                FragmentTransaction searchFragTransaction = getSupportFragmentManager().beginTransaction();
                                searchFragTransaction.replace(R.id.main_container, profileFragment);
                                searchFragTransaction.commit();
                                break;

                            case R.id.action_calculate:
                                FragmentTransaction profileFragTransaction = getSupportFragmentManager().beginTransaction();
                                profileFragTransaction.replace(R.id.main_container, calculateCostFragment);
                                profileFragTransaction.commit();
                                break;
                        }
                        return true;
                    }
                }
        );

    }

}
