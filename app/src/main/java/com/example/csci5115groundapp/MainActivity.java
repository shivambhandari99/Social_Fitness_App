package com.example.csci5115groundapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import java.util.*;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawer;

    protected static List<ArrayList<String>> createdWorkoutsArray = new ArrayList<>();

    // Temporary Name List since workout list are hardcoded
    public ArrayList<String> workout_list = new ArrayList<String>() {
        {
            add("Daniel");
            add("Fadi");
            add("Peter");
            add("Jordyn");
            add("Jacob");
        }
    };

    // Key: "Workout Name"
    // Value: [0]: "Username", [1]: "Comment", [2]: "Username", ....
    protected static HashMap<String, ArrayList<String>> userCommentsHash = new HashMap<String, ArrayList<String>>();

    protected static List<ArrayList<String>> loggedWorkoutArray = new ArrayList<>();
    public static String userName;
    public static String emailName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();
        String email = intent.getStringExtra("email");
        String userPassedIn = intent.getStringExtra("username");
        String[] emailArr = email.split("@", 2);

        if (emailArr[0] == "") {
            userName = "Jacob";
            emailName = "Jacob@umn.edu";
        } else if (emailArr.length == 1) {
            userName = emailArr[0];
            emailName = emailArr[0];
        } else {
            userName = emailArr[0];
            emailName = emailArr[1];
        }

        if (userPassedIn != null) {
            userName = userPassedIn;
        }

        // This creates a toolbar for the hamburger and title
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // This is the hamburger menu
        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        // This allows the hamburger menu to be toggled
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        // This sets the screen to home at launch
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new HomeFragment()).commit();
            navigationView.setCheckedItem(R.id.nav_message);
        }

        View headerView = navigationView.getHeaderView(0);
        TextView navUsername = (TextView) headerView.findViewById(R.id.nav_name);
        TextView navEmail = (TextView) headerView.findViewById(R.id.nav_email);
        navUsername.setText(userName);
        navEmail.setText(email);

        // Temporary Initialize Workout List
        initializeHashMap();
    }

    // This is a switch statement that changes the screens
    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_message:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new HomeFragment()).commit();
                break;
            case R.id.nav_browse_workout:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new BrowseWorkoutsFragment()).commit();
                break;
            case R.id.nav_profile:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new UserProfileFragment()).commit();
                break;
            case R.id.nav_search:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new SearchFragment()).commit();
//            case R.id.nav_logout:
//                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
//                        new StartFragment()).commit();
                break;
        }
        // This closes the menu after choosing an option
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        // If a user presses the phone's back button this will close the menu first
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    public void initializeHashMap(){
        for(String workout_name : workout_list){
            userCommentsHash.put(workout_name, new ArrayList<String>());
        }
    }

}