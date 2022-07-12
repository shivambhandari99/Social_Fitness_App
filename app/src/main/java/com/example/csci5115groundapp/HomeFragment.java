package com.example.csci5115groundapp;

import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.navigation.NavigationView;

public class HomeFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        // Set the title for that page.
        getActivity().setTitle("Home");

        // This just creates the view
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        TextView welcome_text = ((TextView) view.findViewById(R.id.welcome_text));
        String welcome_msg = "<b>Welcome back " + MainActivity.userName + "!</b>";
        welcome_text.setText(Html.fromHtml(welcome_msg));

        // Browse Button
        Button browseButton = view.findViewById(R.id.button_browse_workout_home);

        // This binds the button to change screens
        browseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // The next three lines changes the fragment

                // This line gets the transaction manager
                FragmentTransaction fragmentTransaction = getParentFragmentManager().beginTransaction();

                // fragment_container (Current screen) and BrowseWorkoutsFragment
                // name of the class of the fragment you want to change it too.
                fragmentTransaction.replace(R.id.fragment_container, new BrowseWorkoutsFragment());

                // Makes the transaction happen.
                fragmentTransaction.commit();

                // The next two lines deselects any selected screens in the hamburger menu
                // We can remove this is we remove android:checkableBehavior="single" in drawer_menu.xml
                // But I think it looks nice
                NavigationView navigationView = getActivity().findViewById(R.id.nav_view);
                navigationView.setCheckedItem(R.id.menu_none);
            }
        });

        // Previous Workout Text
        View previousWorkout = view.findViewById(R.id.previous_workout_text);

        // This binds the button to change screens
        previousWorkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // The next three lines changes the fragment

                // This line gets the transaction manager
                FragmentTransaction fragmentTransaction = getParentFragmentManager().beginTransaction();

                // fragment_container (Current screen) and BrowseWorkoutsFragment
                // name of the class of the fragment you want to change it too.
                fragmentTransaction.replace(R.id.fragment_container, new PeterOnePunchWorkoutFragment());

                // Makes the transaction happen.
                fragmentTransaction.commit();

                // The next two lines deselects any selected screens in the hamburger menu
                // We can remove this is we remove android:checkableBehavior="single" in drawer_menu.xml
                // But I think it looks nice
                NavigationView navigationView = getActivity().findViewById(R.id.nav_view);
                navigationView.setCheckedItem(R.id.menu_none);
            }
        });

        // Leaderboard Text
        View leaderboard = view.findViewById(R.id.leaderboard_text);

        // This binds the button to change screens
        leaderboard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // The next three lines changes the fragment

                // This line gets the transaction manager
                FragmentTransaction fragmentTransaction = getParentFragmentManager().beginTransaction();

                // fragment_container (Current screen) and BrowseWorkoutsFragment
                // name of the class of the fragment you want to change it too.
                fragmentTransaction.replace(R.id.fragment_container, new LeaderboardFragment());

                // Makes the transaction happen.
                fragmentTransaction.commit();

                // The next two lines deselects any selected screens in the hamburger menu
                // We can remove this is we remove android:checkableBehavior="single" in drawer_menu.xml
                // But I think it looks nice
                NavigationView navigationView = getActivity().findViewById(R.id.nav_view);
                navigationView.setCheckedItem(R.id.menu_none);
            }
        });

        // Recommended Workout Text
        View recommendedWorkout = view.findViewById(R.id.recommend_workout_text);

        // This binds the button to change screens
        recommendedWorkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // The next three lines changes the fragment

                // This line gets the transaction manager
                FragmentTransaction fragmentTransaction = getParentFragmentManager().beginTransaction();

                // fragment_container (Current screen) and BrowseWorkoutsFragment
                // name of the class of the fragment you want to change it too.
                fragmentTransaction.replace(R.id.fragment_container, new FadiFiveMovesFragment());

                // Makes the transaction happen.
                fragmentTransaction.commit();

                // The next two lines deselects any selected screens in the hamburger menu
                // We can remove this is we remove android:checkableBehavior="single" in drawer_menu.xml
                // But I think it looks nice
                NavigationView navigationView = getActivity().findViewById(R.id.nav_view);
                navigationView.setCheckedItem(R.id.menu_none);
            }
        });

        // Add Workout Button
        View addWorkout = view.findViewById(R.id.addWorkout);

        // This binds the button to change screens
        addWorkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // The next three lines changes the fragment

                // This line gets the transaction manager
                FragmentTransaction fragmentTransaction = getParentFragmentManager().beginTransaction();

                // fragment_container (Current screen) and BrowseWorkoutsFragment
                // name of the class of the fragment you want to change it too.
                fragmentTransaction.replace(R.id.fragment_container, new CreateWorkoutFragment());

                // Makes the transaction happen.
                fragmentTransaction.commit();

                // The next two lines deselects any selected screens in the hamburger menu
                // We can remove this is we remove android:checkableBehavior="single" in drawer_menu.xml
                // But I think it looks nice
                NavigationView navigationView = getActivity().findViewById(R.id.nav_view);
                navigationView.setCheckedItem(R.id.menu_none);
            }
        });

        return view;
    }
}
