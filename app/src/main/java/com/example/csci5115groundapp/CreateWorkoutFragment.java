package com.example.csci5115groundapp;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.navigation.NavigationView;

import java.util.*;

public class CreateWorkoutFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        // Set the title for that page.
        getActivity().setTitle("Create Your Workout");

        // This just creates the view
        View view = inflater.inflate(R.layout.fragment_create_workout, container, false);

        // Publish Button
        Button publishButton = view.findViewById(R.id.button_publish_create_workout);

        // This binds the button to change screens
        publishButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ArrayList<String> newWorkout = new ArrayList<>();

                newWorkout.add(((EditText) requireActivity().findViewById(R.id.title1)).getText().toString());
                newWorkout.add(((EditText) requireActivity().findViewById(R.id.details1)).getText().toString());
                newWorkout.add(((EditText) requireActivity().findViewById(R.id.title2)).getText().toString());
                newWorkout.add(((EditText) requireActivity().findViewById(R.id.details2)).getText().toString());
                newWorkout.add(((EditText) requireActivity().findViewById(R.id.title3)).getText().toString());
                newWorkout.add(((EditText) requireActivity().findViewById(R.id.details3)).getText().toString());
                newWorkout.add(((EditText) requireActivity().findViewById(R.id.title4)).getText().toString());
                newWorkout.add(((EditText) requireActivity().findViewById(R.id.details4)).getText().toString());
                newWorkout.add(((EditText) requireActivity().findViewById(R.id.title5)).getText().toString());
                newWorkout.add(((EditText) requireActivity().findViewById(R.id.details5)).getText().toString());

                MainActivity.createdWorkoutsArray.add(newWorkout);

                String workout_title = ((EditText) requireActivity().findViewById(R.id.title1)).getText().toString();
                ArrayList<String> empty_list = new ArrayList<String>();
                MainActivity.userCommentsHash.put(workout_title, empty_list);

                // The next three lines changes the fragment

                // This line gets the transaction manager
                FragmentTransaction fragmentTransaction = getParentFragmentManager().beginTransaction();

                // fragment_container (Current screen) and BrowseWorkoutsFragment
                // name of the class of the fragment you want to change it too.
                fragmentTransaction.replace(R.id.fragment_container, new ReturnToProfileFragment());

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