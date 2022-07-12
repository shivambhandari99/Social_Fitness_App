package com.example.csci5115groundapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class CredentialsFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // This just creates the view
        requireActivity().setTitle("Login to your app");

        View view = inflater.inflate(R.layout.fragment_credentials, container, false);

        Button loginButton = view.findViewById(R.id.login_filled);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), MainActivity.class);
                EditText editText = (EditText) requireActivity().findViewById(R.id.email_login);
                String message = editText.getText().toString();
                intent.putExtra("email", message);
                startActivity(intent);
            }
        });

        return view;
    }
}
