package com.example.trungtien.raspberrypi.homescreen;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.trungtien.raspberrypi.MainActivity;
import com.example.trungtien.raspberrypi.R;
import com.example.trungtien.raspberrypi.homescreen.fragment.HomeFragment;
import com.example.trungtien.raspberrypi.homescreen.fragment.IntroduceFragment;
import com.example.trungtien.raspberrypi.homescreen.fragment.SettingFragment;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.messaging.FirebaseMessaging;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {
    private DrawerLayout drawerLayout;
    private FragmentManager fragmentManager;
    private View btnMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.screen_home);
        FirebaseMessaging.getInstance().subscribeToTopic("test");
        String mgs = FirebaseInstanceId.getInstance().getToken();
        Toast.makeText(this, mgs, Toast.LENGTH_SHORT).show();
        fragmentManager = getFragmentManager();
        redirectFragment(new HomeFragment());
        initNavigationDrawer();
        setupView();
    }

    private void setupView() {
        btnMenu = findViewById(R.id.btn_menu);
        btnMenu.setOnClickListener(this);
    }

    private void redirectFragment(Fragment fragment) {
        fragmentManager.beginTransaction()
                .replace(R.id.content_frame
                        , fragment)
                .commit();
    }

    public void initNavigationDrawer() {

        NavigationView navigationView = (NavigationView) findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {

                int id = menuItem.getItemId();

                switch (id) {
                    case R.id.home:
                        redirectFragment(new HomeFragment());
                        drawerLayout.closeDrawers();
                        break;
                    case R.id.settings:
                        redirectFragment(new SettingFragment());
                        drawerLayout.closeDrawers();
                        break;
                    case R.id.about:
                        redirectFragment(new IntroduceFragment());
                        drawerLayout.closeDrawers();
                        break;
                    case R.id.logout:
                        Intent intent = new Intent(HomeActivity.this, MainActivity.class);
                        startActivity(intent);
                        drawerLayout.closeDrawers();
                        finish();
                        break;

                }
                return true;
            }
        });
        View header = navigationView.getHeaderView(0);
        TextView tv_email = (TextView) header.findViewById(R.id.tv_email);
        tv_email.setText("tientt.dev@gmail.com");
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer);

        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.drawer_open, R.string.drawer_close) {

            @Override
            public void onDrawerClosed(View v) {
                super.onDrawerClosed(v);
            }

            @Override
            public void onDrawerOpened(View v) {
                super.onDrawerOpened(v);
            }
        };
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
    }

    @Override
    public void onClick(View view) {
        if (view == btnMenu) {
            drawerLayout.openDrawer(Gravity.START);
        }
    }
}

