package com.example.csci5115groundapp;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class AddCommentFragment extends Fragment {

    public int userId = -1;
    public Fragment previous_fragment;
    public String workout_name;
    public String myType;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        // Set the title for that page.
        getActivity().setTitle("Add comments");

        // This just creates the view
        View view = inflater.inflate(R.layout.fragment_add_comment, container, false);

        // Publish Button
        Button publishButton = view.findViewById(R.id.submit_comment);

        // This binds the button to change screens
        publishButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                EditText edit_text_comment = (EditText) getView().findViewById(R.id.edit_text_comment);
                String user_comment = edit_text_comment.getText().toString();

                ArrayList<String> userCommentsList = MainActivity.userCommentsHash.get(workout_name);
                if(!(user_comment == null && user_comment.isEmpty())){
                    userCommentsList.add(MainActivity.userName);
                    userCommentsList.add(user_comment);
                }

                // The next three lines changes the fragment
                // This line gets the transaction manager
                FragmentTransaction fragmentTransaction = getParentFragmentManager().beginTransaction();
                if(userId > -1) {
                    Bundle bundle = new Bundle();
                    bundle.putInt("num", userId);
                    bundle.putString("type", myType);
                    previous_fragment.setArguments(bundle);
                }
                // fragment_container (Current screen) and Previous framgment
                // name of the class of the fragment you want to change it too.
                fragmentTransaction.replace(R.id.fragment_container, previous_fragment);
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


//    EditText please = (EditText) getView().findViewById(R.id.edit_text_comment);
//
//    please.setOnEditorActionListener(new OnEditorActionListener() {
//        @Override
//        public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
//            boolean handled = false;
//            if (actionId == EditorInfo.IME_ACTION_SEND) {
//                sendMessage();
//                handled = true;
//            }
//            return handled;
//        }
//    });
}