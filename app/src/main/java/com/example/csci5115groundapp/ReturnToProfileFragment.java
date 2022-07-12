package com.example.csci5115groundapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.navigation.NavigationView;

public class ReturnToProfileFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        // Set the title for that page.
        getActivity().setTitle("");

        // This just creates the view
        View view = inflater.inflate(R.layout.fragment_return_to_profile, container, false);

        // Return To Profile Button
        Button returnToProfileButton = view.findViewById(R.id.button_return_to_profile);

        // This binds the button to change screens
        returnToProfileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // The next three lines changes the fragment

                // This line gets the transaction manager
                FragmentTransaction fragmentTransaction = getParentFragmentManager().beginTransaction();

                // fragment_container (Current screen) and BrowseWorkoutsFragment
                // name of the class of the fragment you want to change it too.
                fragmentTransaction.replace(R.id.fragment_container, new UserProfileFragment());

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