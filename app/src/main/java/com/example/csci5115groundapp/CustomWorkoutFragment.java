
package com.example.csci5115groundapp;

import android.os.Bundle;
import android.text.Html;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class CustomWorkoutFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // This just creates the view

        View view = inflater.inflate(R.layout.fragment_custom_workout, container, false);

        Bundle bundle = this.getArguments();
        int myInt = bundle.getInt("num", -1);
        String myType = bundle.getString("type", "");

        if (myInt != -1 && myType == "created") {
            requireActivity().setTitle(MainActivity.createdWorkoutsArray.get(myInt).get(0));
            TextView workout_title = (TextView) view.findViewById(R.id.custom_workout_title);
            workout_title.setText(Html.fromHtml("<b>" + MainActivity.createdWorkoutsArray.get(myInt).get(0) + "</b>"
                    + "<br/>" + MainActivity.createdWorkoutsArray.get(myInt).get(1)));

            TextView workout_body = (TextView) view.findViewById(R.id.custom_workout_body);
            workout_body.setText(Html.fromHtml("<b>" + MainActivity.createdWorkoutsArray.get(myInt).get(2) + "</b>"
                    + "<br/>" + MainActivity.createdWorkoutsArray.get(myInt).get(3)
                    + "<br/><br/>" + "<b>" + MainActivity.createdWorkoutsArray.get(myInt).get(4) + "</b>"
                    + "<br/>" + MainActivity.createdWorkoutsArray.get(myInt).get(5)
                    + "<br/><br/>" + "<b>" + MainActivity.createdWorkoutsArray.get(myInt).get(6) + "</b>"
                    + "<br/>" + MainActivity.createdWorkoutsArray.get(myInt).get(7)
                    + "<br/><br/>" + "<b>" + "<a href=\"" + MainActivity.createdWorkoutsArray.get(myInt).get(9) + "\">" +
                    MainActivity.createdWorkoutsArray.get(myInt).get(8) + "</a>" + "</b>" + "<br/>"));
        } else if (myInt != -1 && myType == "logged") {
            TextView workout_title = (TextView) view.findViewById(R.id.custom_workout_title);
            workout_title.setText(Html.fromHtml("<b>" + MainActivity.loggedWorkoutArray.get(myInt).get(0) + "</b>"
                    + "<br/>" + MainActivity.loggedWorkoutArray.get(myInt).get(1)));

            TextView workout_body = (TextView) view.findViewById(R.id.custom_workout_body);
            workout_body.setText(Html.fromHtml("<b>" + MainActivity.loggedWorkoutArray.get(myInt).get(2) + "</b>"
                    + "<br/>" + MainActivity.loggedWorkoutArray.get(myInt).get(3)
                    + "<br/><br/>" + "<b>" + MainActivity.loggedWorkoutArray.get(myInt).get(4) + "</b>"
                    + "<br/>" + MainActivity.loggedWorkoutArray.get(myInt).get(5)
                    + "<br/><br/>" + "<b>" + MainActivity.loggedWorkoutArray.get(myInt).get(6) + "</b>"
                    + "<br/>" + MainActivity.loggedWorkoutArray.get(myInt).get(7)
                    + "<br/><br/>" + "<b>" + "<a href=\"" + MainActivity.loggedWorkoutArray.get(myInt).get(9) + "\">" +
                    MainActivity.loggedWorkoutArray.get(myInt).get(8) + "</a>" + "</b>" + "<br/>"));
        }

        String workout_name = MainActivity.createdWorkoutsArray.get(myInt).get(0);;
        TextView recent_created = (TextView) view.findViewById(R.id.custom_comments_section);
        recent_created.setMovementMethod(new ScrollingMovementMethod());
        int comment_size = MainActivity.userCommentsHash.get(workout_name).size();
        if (MainActivity.userCommentsHash.get(workout_name).size() == 0) {
            recent_created.setText(Html.fromHtml("<b>None yet!</b>"));
        } else {
            String comment = "";
            for(int i = 0 ; i < comment_size ; i+=2) {
                comment += "<b>" + MainActivity.userCommentsHash.get(workout_name).get(i) + "</b>"
                        + "<br/>" + MainActivity.userCommentsHash.get(workout_name).get(i+1) + "<br/>";
            }
            recent_created.setText(Html.fromHtml(comment));
        }

        // add comment
        View addComment = view.findViewById(R.id.custom_add_comment);

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
                addCommentFragment.userId = myInt;
                addCommentFragment.myType = myType;
                addCommentFragment.workout_name = MainActivity.createdWorkoutsArray.get(myInt).get(0);
                addCommentFragment.previous_fragment = new CustomWorkoutFragment();
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

        view.findViewById(R.id.custom_view_creator).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                FragmentTransaction fragmentTransaction = getParentFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, new UserProfileFragment());
                fragmentTransaction.commit();

                NavigationView navigationView = requireActivity().findViewById(R.id.nav_view);
                navigationView.setCheckedItem(R.id.menu_none);
            }
        });

        view.findViewById(R.id.custom_log_workout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<String> loggedEvent = new ArrayList<>();
                if (myType == "created") {
                    loggedEvent = (ArrayList<String>) MainActivity.createdWorkoutsArray.get(myInt).clone();
                } else if (myType == "logged") {
                    loggedEvent = (ArrayList<String>) MainActivity.loggedWorkoutArray.get(myInt).clone();
                }

                MainActivity.loggedWorkoutArray.add(loggedEvent);

                FragmentTransaction fragmentTransaction = getParentFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, new UserProfileFragment());
                fragmentTransaction.commit();

                NavigationView navigationView = requireActivity().findViewById(R.id.nav_view);
                navigationView.setCheckedItem(R.id.menu_none);
            }
        });

        return view;
    }
}
