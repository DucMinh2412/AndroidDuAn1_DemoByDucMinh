package com.example.androidduan1_demobyducminh.activity;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.androidduan1_demobyducminh.R;
import com.example.androidduan1_demobyducminh.fragment.DiscoverFragment;
import com.example.androidduan1_demobyducminh.fragment.MyfavoriteFragment;
import com.example.androidduan1_demobyducminh.fragment.RazochartFragment;
import com.example.androidduan1_demobyducminh.fragment.SearchFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView.OnNavigationItemSelectedListener OpenListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment = null;

                    switch (item.getItemId()) {
                        case R.id.myfavorite:
                            selectedFragment = new MyfavoriteFragment();
                            break;

                        case R.id.discover:
                            selectedFragment = new DiscoverFragment();
                            break;

                        case R.id.razochart:
                            selectedFragment = new RazochartFragment();
                            break;

                        case R.id.search:
                            selectedFragment = new SearchFragment();
                            break;

                    }

                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            selectedFragment).commit();

                    return true;
                }
            };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(OpenListener);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new MyfavoriteFragment()).commit();
        }
    }


}
