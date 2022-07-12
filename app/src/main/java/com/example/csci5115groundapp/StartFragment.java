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

public class StartFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // This just creates the view
        requireActivity().setTitle("Login");

        View view = inflater.inflate(R.layout.fragment_start, container, false);

        View Create_account_button = view.findViewById(R.id.create_account_button);

        Create_account_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // The next three lines changes the fragment
                FragmentTransaction fragmentTransaction = getParentFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container_login, new CreateAccountFragment());
                fragmentTransaction.commit();
            }
        });

        Button login_account_button = view.findViewById(R.id.login_button);

        login_account_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // The next three lines changes the fragment
                FragmentTransaction fragmentTransaction = getParentFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container_login, new CredentialsFragment());
                fragmentTransaction.commit();
            }
        });

        return view;
    }
}
