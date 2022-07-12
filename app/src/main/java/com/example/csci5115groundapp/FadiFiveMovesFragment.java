package com.example.csci5115groundapp;

import android.os.Bundle;
import android.text.Html;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class FadiFiveMovesFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        // set title
        getActivity().setTitle("Fadi's 5 Moves Total Workout");

        // This just creates the view
        View view = inflater.inflate(R.layout.fragment_fadi_five_moves, container, false);

        TextView recent_created = (TextView) view.findViewById(R.id.fadi_comments_section);
        recent_created.setMovementMethod(new ScrollingMovementMethod());
        int comment_size = MainActivity.userCommentsHash.get("Fadi").size();
        if (MainActivity.userCommentsHash.get("Fadi").size() == 0) {
            recent_created.setText(Html.fromHtml("<b>None yet!</b>"));
        } else {
            String comment = "";
            for(int i = 0 ; i < comment_size ; i+=2) {
                comment += "<b>" + MainActivity.userCommentsHash.get("Fadi").get(i) + "</b>"
                        + "<br/>" + MainActivity.userCommentsHash.get("Fadi").get(i+1) + "<br/>";
            }
            recent_created.setText(Html.fromHtml(comment));
        }

        // add comment
        View addComment = view.findViewById(R.id.fadi_add_comment);

        // This binds the button to change screens
        addComment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // The next three lines changes the fragment

                // This line gets the transaction manager
                FragmentTransaction fragmentTransaction = getParentFragmentManager().beginTransaction();

                // fragment_container (Current screen) and BrowseWorkoutsFragment
                // name of the class of the fragment you want to change it too.
                AddCommentFragment addCommentFragment = new AddCommentFragment();
                addCommentFragment.workout_name = "Fadi";
                addCommentFragment.previous_fragment = new FadiFiveMovesFragment();
                fragmentTransaction.replace(R.id.fragment_container, addCommentFragment);

                // Makes the transaction happen.
                fragmentTransaction.commit();

                // The next two lines deselects any selected screens in the hamburger menu
                // We can remove this is we remove android:checkableBehavior="single" in drawer_menu.xml
                // But I think it looks nice
                NavigationView navigationView = getActivity().findViewById(R.id.nav_view);
                navigationView.setCheckedItem(R.id.menu_none);
            }
        });

        // view creator
        View viewCreator = view.findViewById(R.id.fadi_view_creator);

        // This binds the button to change screens
        viewCreator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // The next three lines changes the fragment

                // This line gets the transaction manager
                FragmentTransaction fragmentTransaction = getParentFragmentManager().beginTransaction();

                // fragment_container (Current screen) and BrowseWorkoutsFragment
                // name of the class of the fragment you want to change it too.
                fragmentTransaction.replace(R.id.fragment_container, new FadisProfileFragment());

                // Makes the transaction happen.
                fragmentTransaction.commit();

                // The next two lines deselects any selected screens in the hamburger menu
                // We can remove this is we remove android:checkableBehavior="single" in drawer_menu.xml
                // But I think it looks nice
                NavigationView navigationView = getActivity().findViewById(R.id.nav_view);
                navigationView.setCheckedItem(R.id.menu_none);
            }
        });

        // log workout
        View logWorkout = view.findViewById(R.id.fadi_log_workout);

        // This binds the button to change screens
        logWorkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // The next three lines changes the fragment

                ArrayList<String> loggedEvent = new ArrayList<>();
                loggedEvent.add("Fadi\'s 5 Moves Total Workout");
                loggedEvent.add("30 minutes; average; full body");

                MainActivity.loggedWorkoutArray.add(loggedEvent);

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
