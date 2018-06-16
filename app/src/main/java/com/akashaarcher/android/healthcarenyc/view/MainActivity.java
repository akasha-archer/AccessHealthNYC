package com.akashaarcher.android.healthcarenyc.view;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.akashaarcher.android.healthcarenyc.R;

/**
 * Created by akashaarcher on 4/7/18.
 */

public class MainActivity extends AppCompatActivity {

    FindServiceFragment findServiceFragment = new FindServiceFragment();
    UserProfileFragment profileFragment = new UserProfileFragment();
    CalculateCostFragment calculateCostFragment = new CalculateCostFragment();


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentTransaction homeFragTransaction = getSupportFragmentManager().beginTransaction();
        homeFragTransaction.add(R.id.main_container, findServiceFragment);
        homeFragTransaction.commit();

        BottomNavigationView bottomNav = (BottomNavigationView) findViewById(R.id.bottom_nav_layout);
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
