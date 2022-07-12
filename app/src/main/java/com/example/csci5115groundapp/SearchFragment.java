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

public class SearchFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // This just creates the view
        requireActivity().setTitle("Search");

        View view = inflater.inflate(R.layout.fragment_search, container, false);

        Button searchButton = view.findViewById(R.id.search_button);

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent intent = new Intent(getActivity(), MainActivity.class);
                EditText editText = (EditText) requireActivity().findViewById(R.id.search);
                String message = editText.getText().toString().toLowerCase();
                //Intent intent =  new Intent(getActivity(), SearchFragment.class);;
                FragmentTransaction fragmentTransaction = getParentFragmentManager().beginTransaction();
                NavigationView navigationView = getActivity().findViewById(R.id.nav_view);

                switch (message) {
                    case "fadi":
                        fragmentTransaction.replace(R.id.fragment_container, new FadisProfileFragment());
                        fragmentTransaction.commit();
                        navigationView.setCheckedItem(R.id.menu_none);
                        break;
                    case "daniel":
                        fragmentTransaction.replace(R.id.fragment_container, new DanielsProfileFragment());
                        fragmentTransaction.commit();
                        navigationView.setCheckedItem(R.id.menu_none);
                        break;
                    case "peter":
                        fragmentTransaction.replace(R.id.fragment_container, new PetersProfileFragment());
                        fragmentTransaction.commit();
                        navigationView.setCheckedItem(R.id.menu_none);
                        break;
                    case "jordyn":
                        fragmentTransaction.replace(R.id.fragment_container, new JordynsProfileFragment());
                        fragmentTransaction.commit();
                        navigationView.setCheckedItem(R.id.menu_none);
                        break;
                    case "jacob's workout":
                        fragmentTransaction.replace(R.id.fragment_container, new JacobCoolWorkoutFragment());
                        fragmentTransaction.commit();
                        navigationView.setCheckedItem(R.id.menu_none);
                        break;
                    case "jordyn's workout":
                        fragmentTransaction.replace(R.id.fragment_container, new JordynBicepBreakerFragment());
                        fragmentTransaction.commit();
                        navigationView.setCheckedItem(R.id.menu_none);
                        break;
                    case "fadi's workout":
                        fragmentTransaction.replace(R.id.fragment_container, new FadiFiveMovesFragment());
                        fragmentTransaction.commit();
                        navigationView.setCheckedItem(R.id.menu_none);
                        break;
                    case "daniel's workout":
                        fragmentTransaction.replace(R.id.fragment_container, new DanielStretchYourBackFragment());
                        fragmentTransaction.commit();
                        navigationView.setCheckedItem(R.id.menu_none);
                        break;
                    case "peter's workout":
                        fragmentTransaction.replace(R.id.fragment_container, new PeterOnePunchWorkoutFragment());
                        fragmentTransaction.commit();
                        navigationView.setCheckedItem(R.id.menu_none);
                        break;

                    default:
                        fragmentTransaction.replace(R.id.fragment_container, new SearchNotFoundFragment());
                        fragmentTransaction.commit();
                        navigationView.setCheckedItem(R.id.menu_none);
                        break;

                }
                //intent.putExtra("email", message);
                //startActivity(intent);
            }
        });

        return view;
    }
}
