package com.example.csci5115groundapp;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.navigation.NavigationView;

public class UserLoggedFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // This just creates the view

        requireActivity().setTitle("Created Workouts");

        View view = inflater.inflate(R.layout.fragment_user_logged, container, false);


//        view.findViewById(R.id.user_profile_add_workout_created_logged).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                FragmentTransaction fragmentTransaction = getParentFragmentManager().beginTransaction();
//                fragmentTransaction.replace(R.id.fragment_container, new CreateWorkoutFragment());
//                fragmentTransaction.commit();
//
//                NavigationView navigationView = requireActivity().findViewById(R.id.nav_view);
//                navigationView.setCheckedItem(R.id.menu_none);
//            }
//        });

        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.ideaview_logged);
        Drawable rectangle = getResources().getDrawable(R.drawable.rectange_gray);

        for (int i = 0; i < MainActivity.loggedWorkoutArray.size(); i++) {
            TextView textView = new TextView(requireContext());
            RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,RelativeLayout.LayoutParams.WRAP_CONTENT);
            params.setMargins(175, 300+(i*300), 175, 0);
            params.alignWithParent = true;
            params.width = 1000;
            params.height = 250;
            textView.setTextSize(18);
            textView.setLayoutParams(params);
            textView.setBackground(rectangle);
            textView.setText(Html.fromHtml("<b>" + MainActivity.loggedWorkoutArray.get(i).get(0) + "</b>"
                    + "<br/>" + MainActivity.loggedWorkoutArray.get(i).get(1)));
            relativeLayout.addView(textView);

            int finalI = i;
            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (MainActivity.loggedWorkoutArray.get(finalI).get(0).equals("Jacob\'s Cool Workout!!")) {

                        FragmentTransaction fragmentTransaction = getParentFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.fragment_container, new JacobCoolWorkoutFragment());
                        fragmentTransaction.commit();

                        NavigationView navigationView = requireActivity().findViewById(R.id.nav_view);
                        navigationView.setCheckedItem(R.id.menu_none);

                    } else if (MainActivity.loggedWorkoutArray.get(finalI).get(0).equals("Jordyn's Bicep Breaker")) {

                        FragmentTransaction fragmentTransaction = getParentFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.fragment_container, new JordynBicepBreakerFragment());
                        fragmentTransaction.commit();

                        NavigationView navigationView = requireActivity().findViewById(R.id.nav_view);
                        navigationView.setCheckedItem(R.id.menu_none);

                    } else if (MainActivity.loggedWorkoutArray.get(finalI).get(0).equals("Peter\'s One Punch Workout")) {

                        FragmentTransaction fragmentTransaction = getParentFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.fragment_container, new PeterOnePunchWorkoutFragment());
                        fragmentTransaction.commit();

                        NavigationView navigationView = requireActivity().findViewById(R.id.nav_view);
                        navigationView.setCheckedItem(R.id.menu_none);

                    } else if (MainActivity.loggedWorkoutArray.get(finalI).get(0).equals("Fadi\'s 5 Moves Total Workout")) {

                        FragmentTransaction fragmentTransaction = getParentFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.fragment_container, new FadiFiveMovesFragment());
                        fragmentTransaction.commit();

                        NavigationView navigationView = requireActivity().findViewById(R.id.nav_view);
                        navigationView.setCheckedItem(R.id.menu_none);

                    } else if (MainActivity.loggedWorkoutArray.get(finalI).get(0).equals("Daniel\'s Stretch Your Back")) {

                        FragmentTransaction fragmentTransaction = getParentFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.fragment_container, new DanielStretchYourBackFragment());
                        fragmentTransaction.commit();

                        NavigationView navigationView = requireActivity().findViewById(R.id.nav_view);
                        navigationView.setCheckedItem(R.id.menu_none);

                    } else {

                        FragmentTransaction fragmentTransaction = getParentFragmentManager().beginTransaction();
                        Fragment customWorkout = new CustomWorkoutFragment();
                        Bundle bundle = new Bundle();
                        bundle.putInt("num", finalI);
                        bundle.putString("type", "logged");
                        customWorkout.setArguments(bundle);
                        fragmentTransaction.replace(R.id.fragment_container, customWorkout);
                        fragmentTransaction.commit();

                        NavigationView navigationView = requireActivity().findViewById(R.id.nav_view);
                        navigationView.setCheckedItem(R.id.menu_none);
                    }
                }
            });
        }

        return view;
    }
}
