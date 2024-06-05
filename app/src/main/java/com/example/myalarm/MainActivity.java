package com.example.myalarm;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView mBottomNavigationView;
    private ViewPager2 mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        anhXa();
        setupBottomNavigationView();
        setupViewPager();
    }

    private void anhXa() {
        mBottomNavigationView = findViewById(R.id.BottomNavigation);
        mViewPager = findViewById(R.id.ViewPage);
    }

    private void setupBottomNavigationView() {
        mBottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemId = item.getItemId();
                if (itemId == R.id.gioquocte) {
                    mViewPager.setCurrentItem(0);
                } else if (itemId == R.id.baothuc) {
                    mViewPager.setCurrentItem(1);
                } else if (itemId == R.id.giodingu) {
                    mViewPager.setCurrentItem(2);
                } else if (itemId == R.id.bamgio) {
                    mViewPager.setCurrentItem(3);
                } else if (itemId == R.id.hengio) {
                    mViewPager.setCurrentItem(4);
                }
                return true;
            }
        });
    }



//

    private void setupViewPager() {
        ViewPageAdapter viewPageAdapter = new ViewPageAdapter(this);
        mViewPager.setAdapter(viewPageAdapter);
        mViewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                switch (position) {
                    case 0:
                        mBottomNavigationView.getMenu().findItem(R.id.gioquocte).setChecked(true);
                        break;
                    case 1:
                        mBottomNavigationView.getMenu().findItem(R.id.baothuc).setChecked(true);
                        break;
                    case 2:
                        mBottomNavigationView.getMenu().findItem(R.id.giodingu).setChecked(true);
                        break;
                    case 3:
                        mBottomNavigationView.getMenu().findItem(R.id.bamgio).setChecked(true);
                        break;
                    case 4:
                        mBottomNavigationView.getMenu().findItem(R.id.hengio).setChecked(true);
                        break;
                }
            }
        });
    }
}
