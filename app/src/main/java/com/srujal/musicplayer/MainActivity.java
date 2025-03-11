package com.srujal.musicplayer;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.bottomnavigation.BottomNavigationItemView;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.srujal.musicplayer.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    ActivityMainBinding binding;
    BottomNavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        navigationView = binding.homeNav;
        navigationView.setOnNavigationItemSelectedListener(MainActivity.this);
        navigationView.setSelectedItemId(R.id.home);
    }

    HomeFragment homeFragment = new HomeFragment();
    SearchFragment searchFragment = new SearchFragment();
    LibraryFragment libraryFragment = new LibraryFragment();
    PremiumFragment premiumFragment = new PremiumFragment();
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.home){
            item.setIcon(R.drawable.home);
            getSupportFragmentManager().beginTransaction().replace(R.id.home_fragment, homeFragment).commit();
        }
        if (item.getItemId() == R.id.search){
            item.setIcon(R.drawable.search);
            getSupportFragmentManager().beginTransaction().replace(R.id.home_fragment, searchFragment).commit();
        }
        if (item.getItemId() == R.id.library){
            item.setIcon(R.drawable.library);
            getSupportFragmentManager().beginTransaction().replace(R.id.home_fragment, libraryFragment).commit();
        }
        if (item.getItemId() == R.id.premium){
            item.setIcon(R.drawable.premium);
            getSupportFragmentManager().beginTransaction().replace(R.id.home_fragment, premiumFragment).commit();
        }
        return true;
    }
}