package com.example.atulsiademo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class NavagiateActivity extends AppCompatActivity {
    NavigationView nav;
    ActionBarDrawerToggle toggle;
    DrawerLayout drawerLayout;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navagiate);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        nav = (NavigationView) findViewById(R.id.navgation);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer);
        toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.Open, R.string.Close);
// drawer will listen the toggle drawer will open or close na
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        getSupportFragmentManager().beginTransaction().replace(R.id.containerAD,new DashboardFragment()).commit();
nav.setCheckedItem(R.id.dashboard);

        nav.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            Fragment temp;

            @Override

            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.dashboard:
                        temp=new DashboardFragment();
                                            break;
                    case R.id.profile:
                        temp=new ProfileFragment();

                        break;
                    case R.id.jewelllery:
                        temp=new JewelleryFragment();
                        break;
                    case R.id.Support:
                        temp=new SupportFragment();
                        break;
                    case R.id.logout:
                        Toast.makeText(getApplicationContext(), "Logout Panel is open", Toast.LENGTH_LONG).show();
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.containerAD,temp).commit();
                drawerLayout.closeDrawer(GravityCompat.START);

                return true;
            }


        });


    }
}