package com.example.saccerwin.todolist_group1;

import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.Date;

public class NavigationDrawerMainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, MainFragment.OnFragmentInteractionListener {

    private Toolbar toolbar;
    private TextView tvGreeting, tvCountTask, tvCountGroup;
    private int hour;
    public Date dayNow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_drawer_main);
        dayNow = new Date();
        hour = dayNow.getHours();

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("");
        tvGreeting = (TextView) toolbar.findViewById(R.id.tvGreeting);
        setSupportActionBar(toolbar);

        if (savedInstanceState == null) {
            Fragment fragment = null;
            Class fragmentClass = MainFragment.class;
            try {
                tvGreeting.setText(setGreeting(hour));
                fragment = (Fragment) fragmentClass.newInstance();
            } catch (Exception e) {
                e.printStackTrace();
            }

            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.flContent, fragment).commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        tvCountTask = (TextView) MenuItemCompat.getActionView(navigationView.getMenu().
                findItem(R.id.navHome));
        tvCountGroup = (TextView) MenuItemCompat.getActionView(navigationView.getMenu().
                findItem(R.id.navGroups));

        initializeCountDrawer();
    }

    private void initializeCountDrawer() {
        tvCountTask.setGravity(Gravity.CENTER_VERTICAL);
        tvCountTask.setTypeface(null, Typeface.BOLD);
        tvCountTask.setTextColor(getResources().getColor(R.color.colorBlack));
        tvCountTask.setText("99+");

        tvCountGroup.setGravity(Gravity.CENTER_VERTICAL);
        tvCountGroup.setTypeface(null, Typeface.BOLD);
        tvCountGroup.setTextColor(getResources().getColor(R.color.colorBlack));
        tvCountGroup.setText("99+");
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } //else {
        //super.onBackPressed();
        //}
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.navHome) {

        } else if (id == R.id.navOverView) {

        } else if (id == R.id.navGroups) {

        } else if (id == R.id.navProfile) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    private String setGreeting(int hour) {
        if (0 <= hour && hour < 12) {
            return "Good Morning!";
        } else if (12 <= hour && hour < 18) {
            return "Good Afternoon!";
        } else if (18 <= hour && hour < 21) {
            return "Good Evening!";
        } else {
            return "Good Night!";
        }
    }
}
