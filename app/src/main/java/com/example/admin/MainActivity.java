package com.example.admin;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    private BottomNavigationView mMainNav;
    private FrameLayout mMainFrame;

    private QLSVFragment qlsvFragment;
    private QLChuNhaFragment qlChuTroFragment;
    private MapFragment mapFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mMainFrame = (FrameLayout) findViewById(R.id.main_frame);
        mMainNav = (BottomNavigationView) findViewById(R.id.main_nav);

        qlsvFragment = new QLSVFragment();
        qlChuTroFragment = new QLChuNhaFragment();
        mapFragment = new MapFragment();

        setFragment(qlsvFragment);

        mMainNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.nav_QLSV:
                        mMainNav.setItemBackgroundResource(R.color.colorPrimary);
                        setFragment(qlsvFragment);
                        return true;

                    case R.id.nav_QLTro:
                        mMainNav.setItemBackgroundResource(R.color.colorPrimary);
                        setFragment(qlChuTroFragment);
                        return true;

                    case R.id.nav_map:
                        mMainNav.setItemBackgroundResource(R.color.colorPrimary);
                        setFragment(mapFragment);
                        return true;

                    default: return false;

                }
            }


        });
    }
    private void setFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.main_frame, fragment);
        fragmentTransaction.commit();
    }
}
