package com.example.android.jokedisplay;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A placeholder fragment containing a simple view.
 */
public class JokeFragment extends Fragment {

    public JokeFragment () {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_joke, container, false);

        // Display joke from activity intent
        String joke = getActivity().getIntent().getStringExtra(JokeActivity.ARG_JOKE);
        if (!TextUtils.isEmpty(joke)) {
            TextView jokeTextView = root.findViewById(R.id.jokeTextView);
            jokeTextView.setText(joke);
        }

        return root;
    }
}
