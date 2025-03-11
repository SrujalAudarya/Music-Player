package com.srujal.musicplayer;

import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.srujal.musicplayer.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    ActivityMainBinding binding;
    boolean doubletab = false;
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
            getSupportFragmentManager().beginTransaction().replace(R.id.home_fragment, homeFragment).commit();
        }
        if (item.getItemId() == R.id.search){
            getSupportFragmentManager().beginTransaction().replace(R.id.home_fragment, searchFragment).commit();
        }
        if (item.getItemId() == R.id.library){
            getSupportFragmentManager().beginTransaction().replace(R.id.home_fragment, libraryFragment).commit();
        }
        if (item.getItemId() == R.id.premium){
            getSupportFragmentManager().beginTransaction().replace(R.id.home_fragment, premiumFragment).commit();
        }
        return true;
    }

    @Override
    public void onBackPressed(){
        if (doubletab){
            finishAffinity();
            super.onBackPressed();
        }
        else {
            doubletab = true;
            Toast.makeText(MainActivity.this, "Press again to exit app", Toast.LENGTH_SHORT).show();
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    doubletab = false;
                }
            },2000);// Reset doubleTab after 2 seconds
        }
    }
}