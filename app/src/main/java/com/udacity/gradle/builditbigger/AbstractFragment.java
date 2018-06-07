package com.udacity.gradle.builditbigger;

import android.support.v4.app.Fragment;

/**
 * Created by john on 07/06/18.
 */

abstract class AbstractFragment extends Fragment {

    interface PostAction {
        void action();
    }

    abstract void actionTellJoke(PostAction postAction);
}
