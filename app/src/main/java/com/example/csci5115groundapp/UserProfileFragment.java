package com.example.csci5115groundapp;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.navigation.NavigationView;

public class UserProfileFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // This just creates the view

        requireActivity().setTitle("Profile");

        View view = inflater.inflate(R.layout.fragment_user_profile, container, false);

        TextView profile_name = (TextView) view.findViewById(R.id.profile_name);
        profile_name.setText(MainActivity.userName);

        TextView recent_created = (TextView) view.findViewById(R.id.user_profile_created_workout);
        if (MainActivity.createdWorkoutsArray.size() == 0) {
            recent_created.setText(Html.fromHtml("<b>None yet!</b>"));
        } else {
            recent_created.setText(Html.fromHtml("<b>" + MainActivity.createdWorkoutsArray.get(MainActivity.createdWorkoutsArray.size() - 1).get(0) + "</b>"
                    + "<br/>" + MainActivity.createdWorkoutsArray.get(MainActivity.createdWorkoutsArray.size() - 1).get(1)));
        }

        TextView recent_logged = (TextView) view.findViewById(R.id.user_profile_recent_workout);
        if (MainActivity.loggedWorkoutArray.size() == 0) {
            recent_logged.setText(Html.fromHtml("<b>None yet!</b>"));
        } else {
            recent_logged.setText(Html.fromHtml("<b>" + MainActivity.loggedWorkoutArray.get(MainActivity.loggedWorkoutArray.size() - 1).get(0) + "</b>"
                    + "<br/>" + MainActivity.loggedWorkoutArray.get(MainActivity.loggedWorkoutArray.size() - 1).get(1)));
        }

        // This binds the button to change screens
        recent_created.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (MainActivity.createdWorkoutsArray.size() == 0) {
                    return;
                }
                FragmentTransaction fragmentTransaction = getParentFragmentManager().beginTransaction();
                Fragment customWorkout = new CustomWorkoutFragment();
                Bundle bundle = new Bundle();
                bundle.putInt("num", MainActivity.createdWorkoutsArray.size() - 1);
                bundle.putString("type", "created");
                customWorkout.setArguments(bundle);
                fragmentTransaction.replace(R.id.fragment_container, customWorkout);
                fragmentTransaction.commit();

                NavigationView navigationView = getActivity().findViewById(R.id.nav_view);
                navigationView.setCheckedItem(R.id.menu_none);
            }
        });

        view.findViewById(R.id.user_profile_created_workout_view_more).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fragmentTransaction = getParentFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, new UserCreatedFragment());
                fragmentTransaction.commit();

                NavigationView navigationView = getActivity().findViewById(R.id.nav_view);
                navigationView.setCheckedItem(R.id.menu_none);
            }
        });

        view.findViewById(R.id.user_profile_add_workout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fragmentTransaction = getParentFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, new CreateWorkoutFragment());
                fragmentTransaction.commit();

                NavigationView navigationView = getActivity().findViewById(R.id.nav_view);
                navigationView.setCheckedItem(R.id.menu_none);
            }
        });

        View recentLoggedWorkoutText = view.findViewById(R.id.user_profile_recent_workout);
        recentLoggedWorkoutText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (MainActivity.loggedWorkoutArray.size() == 0) {
                    return;
                }
                if (MainActivity.loggedWorkoutArray.get(MainActivity.loggedWorkoutArray.size() - 1).get(0).equals("Jacob\'s Cool Workout!!")) {

                    FragmentTransaction fragmentTransaction = getParentFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.fragment_container, new JacobCoolWorkoutFragment());
                    fragmentTransaction.commit();

                    NavigationView navigationView = requireActivity().findViewById(R.id.nav_view);
                    navigationView.setCheckedItem(R.id.menu_none);

                } else if (MainActivity.loggedWorkoutArray.get(MainActivity.loggedWorkoutArray.size() - 1).get(0).equals("Jordyn's Bicep Breaker")) {

                    FragmentTransaction fragmentTransaction = getParentFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.fragment_container, new JordynBicepBreakerFragment());
                    fragmentTransaction.commit();

                    NavigationView navigationView = requireActivity().findViewById(R.id.nav_view);
                    navigationView.setCheckedItem(R.id.menu_none);

                } else if (MainActivity.loggedWorkoutArray.get(MainActivity.loggedWorkoutArray.size() - 1).get(0).equals("Peter\'s One Punch Workout")) {

                    FragmentTransaction fragmentTransaction = getParentFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.fragment_container, new PeterOnePunchWorkoutFragment());
                    fragmentTransaction.commit();

                    NavigationView navigationView = requireActivity().findViewById(R.id.nav_view);
                    navigationView.setCheckedItem(R.id.menu_none);

                } else if (MainActivity.loggedWorkoutArray.get(MainActivity.loggedWorkoutArray.size() - 1).get(0).equals("Fadi\'s 5 Moves Total Workout")) {

                    FragmentTransaction fragmentTransaction = getParentFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.fragment_container, new FadiFiveMovesFragment());
                    fragmentTransaction.commit();

                    NavigationView navigationView = requireActivity().findViewById(R.id.nav_view);
                    navigationView.setCheckedItem(R.id.menu_none);

                } else if (MainActivity.loggedWorkoutArray.get(MainActivity.loggedWorkoutArray.size() - 1).get(0).equals("Daniel\'s Stretch Your Back")) {

                    FragmentTransaction fragmentTransaction = getParentFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.fragment_container, new DanielStretchYourBackFragment());
                    fragmentTransaction.commit();

                    NavigationView navigationView = requireActivity().findViewById(R.id.nav_view);
                    navigationView.setCheckedItem(R.id.menu_none);

                } else {

                    FragmentTransaction fragmentTransaction = getParentFragmentManager().beginTransaction();
                    Fragment customWorkout = new CustomWorkoutFragment();
                    Bundle bundle = new Bundle();
                    bundle.putInt("num", MainActivity.loggedWorkoutArray.size() - 1);
                    bundle.putString("type", "logged");
                    customWorkout.setArguments(bundle);
                    fragmentTransaction.replace(R.id.fragment_container, customWorkout);
                    fragmentTransaction.commit();

                    NavigationView navigationView = requireActivity().findViewById(R.id.nav_view);
                    navigationView.setCheckedItem(R.id.menu_none);
                }
            }
        });

        view.findViewById(R.id.user_profile_recent_workout_view_more).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // The next three lines changes the fragment

                // This line gets the transaction manager
                FragmentTransaction fragmentTransaction = getParentFragmentManager().beginTransaction();

                // fragment_container (Current screen) and BrowseWorkoutsFragment
                // name of the class of the fragment you want to change it too.
                fragmentTransaction.replace(R.id.fragment_container, new UserLoggedFragment());

                // Makes the transaction happen.
                fragmentTransaction.commit();

                // The next two lines deselects any selected screens in the hamburger menu
                // We can remove this is we remove android:checkableBehavior="single" in drawer_menu.xml
                // But I think it looks nice
                NavigationView navigationView = getActivity().findViewById(R.id.nav_view);
                navigationView.setCheckedItem(R.id.menu_none);
            }
        });

        view.findViewById(R.id.user_profile_logout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), LoginActivity.class);
                startActivity(intent);
            }
        });

        return view;
    }
}
