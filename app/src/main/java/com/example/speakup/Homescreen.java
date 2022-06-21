package com.example.speakup;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;

import com.example.speakup.com.app.kids.fragment.HomeFragment;
import com.example.speakup.com.app.kids.fragment.MyWorkFragment;
import com.example.speakup.com.app.kids.util.Method;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.GravityCompat;

import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.navigation.NavigationView;


public class Homescreen extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    ConstraintLayout drawer;
    BottomNavigationView bottomNavigationView;
    GameFragment gameFragment = new GameFragment();
    SettingsFragment settingsFragment = new SettingsFragment();
    SpeakingFragment speakingFragment = new SpeakingFragment();
    Home homeFragment = new Home();
    StatFragment statFragment = new StatFragment();
    private boolean doubleBackToExitPressedOnce = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_homescreen);

        Method method = new Method(Homescreen.this);
        method.forceRTLIfSupported();

        drawer = findViewById(R.id.homescreen);
        bottomNavigationView = findViewById(R.id.bottomNavigationView);

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.home:
                        backStackRemove();
                        select(0);
                        startActivity(new Intent(Homescreen.this, Homescreen.class));
                        return true;

                    case R.id.game:
                        backStackRemove();
                        select(1);
                        startActivity(new Intent(Homescreen.this, gamelayout.class));
                        return true;

                    case R.id.speaking:
                        backStackRemove();
                        select(2);
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, speakingFragment).commit();
                        return true;

                    case R.id.stats:
                        backStackRemove();
                        select(3);
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, statFragment).commit();
                        return true;

                    case R.id.settings:
                        backStackRemove();
                        select(4);
                        startActivity(new Intent(Homescreen.this, Login.class));
                        return true;

                }
                return false;
            }


        private void unSelect(int position) {
            bottomNavigationView.getMenu().getItem(position).setChecked(false);
            bottomNavigationView.getMenu().getItem(position).setCheckable(false);
        }

        private void select(int position) {
            bottomNavigationView.getMenu().getItem(position).setChecked(true);
        }

        public void backStackRemove() {
            for (int i = 0; i < getSupportFragmentManager().getBackStackEntryCount(); i++) {
                getSupportFragmentManager().popBackStack();
            }
        }
        });
    }


    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
        }
        if (getSupportFragmentManager().getBackStackEntryCount() != 0) {
            String title = getSupportFragmentManager().getFragments().get(getSupportFragmentManager().getBackStackEntryCount() - 1).getTag();
            super.onBackPressed();
        } else {
            this.doubleBackToExitPressedOnce = true;
            Toast.makeText(this, getResources().getString(R.string.Please_click_BACK_again_to_exit), Toast.LENGTH_SHORT).show();
            new Handler().postDelayed(() -> doubleBackToExitPressedOnce = false, 2000);
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return false;
    }
}





//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
//        setContentView(R.layout.activity_homescreen);
//
//
//
//        startActivity(new Intent(Homescreen.this, Home.class));
//
//        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//                switch(item.getItemId()){
//                    case R.id.home:
//                        backStackRemove();
//                        select(0);
//                        startActivity(new Intent(Homescreen.this, Home.class));
//                        return true;
//
//                    case R.id.game:
//                        backStackRemove();
//                        select(1);
//                        startActivity(new Intent(Homescreen.this, gamelayout.class));
//                        return true;
//
//                    case R.id.speaking:
//                        backStackRemove();
//                        select(2);
//                        getSupportFragmentManager().beginTransaction().replace(R.id.container,speakingFragment).commit();
//                        return true;
//
//                    case R.id.stats:
//                        backStackRemove();
//                        select(3);
//                        getSupportFragmentManager().beginTransaction().replace(R.id.container,statFragment).commit();
//                        return true;
//
//                    case R.id.settings:
//                        backStackRemove();
//                        select(4);
//                        startActivity(new Intent(Homescreen.this, Login.class));
//                        return true;
//
//                }
//                return false;
//            }
//            private void unSelect(int position) {
//                bottomNavigationView.getMenu().getItem(position).setChecked(false);
//                bottomNavigationView.getMenu().getItem(position).setCheckable(false);
//            }
//
//            private void select(int position) {
//                bottomNavigationView.getMenu().getItem(position).setChecked(true);
//            }
//
//            public void backStackRemove() {
//                for (int i = 0; i < getSupportFragmentManager().getBackStackEntryCount(); i++) {
//                    getSupportFragmentManager().popBackStack();
//                }
//            }
//        });
//    }
