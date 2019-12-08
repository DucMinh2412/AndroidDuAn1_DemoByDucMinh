package com.example.androidduan1_demobyducminh.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.example.androidduan1_demobyducminh.R;
import com.example.androidduan1_demobyducminh.fragment.DiscoverFragment;
import com.example.androidduan1_demobyducminh.fragment.MyfavoriteFragment;
import com.example.androidduan1_demobyducminh.fragment.RazochartFragment;
import com.example.androidduan1_demobyducminh.fragment.SearchFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    private static final int SECOND_ACTIVITY_REQUEST_CODE = 0;
    ImageView ImgAnhcasi;
    TextView tvTenBaiHat, tvTencasi;


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
        ImgAnhcasi = findViewById(R.id.ImgAnhcasiMain);
        tvTenBaiHat = findViewById(R.id.tvTenBaiHatMain);
        tvTencasi = findViewById(R.id.tvTencasiMain);
        bottomNavigationView.setOnNavigationItemSelectedListener(OpenListener);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new MyfavoriteFragment()).commit();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == SECOND_ACTIVITY_REQUEST_CODE && resultCode == RESULT_OK && data != null) {
            int LinkAnhBaiHat = Integer.parseInt(getIntent().getStringExtra("LinkAnhBaiHatReturn"));
            String TenBaiHat = getIntent().getStringExtra("TenBaiHatReturn");
            String TenCasi = getIntent().getStringExtra("TenCasiReturn");
            ImgAnhcasi.setImageResource(LinkAnhBaiHat);
            tvTencasi.setText(TenCasi);
            tvTenBaiHat.setText(TenBaiHat);
        }

    }

    public void RLOpen(View view) {
        Intent intent = new Intent(this, PlayMusicActivity.class);
        startActivityForResult(intent, SECOND_ACTIVITY_REQUEST_CODE);
        Animatoo.animateSlideUp(this);
    }
}
