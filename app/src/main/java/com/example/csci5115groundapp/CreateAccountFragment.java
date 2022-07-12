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

import java.util.Objects;

public class CreateAccountFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // This just creates the view
        requireActivity().setTitle("Create Your Account");

        View view = inflater.inflate(R.layout.fragment_create_account, container, false);

        Button createFilled = view.findViewById(R.id.create_account_filled);

        createFilled.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), MainActivity.class);
                EditText editText = (EditText) requireActivity().findViewById(R.id.email);
                EditText editTextUser = (EditText) requireActivity().findViewById(R.id.username);
                String message = editText.getText().toString();
                String userMessage = editTextUser.getText().toString();
                intent.putExtra("email", message);
                intent.putExtra("username", userMessage);
                startActivity(intent);
            }
        });

        return view;
    }
}
