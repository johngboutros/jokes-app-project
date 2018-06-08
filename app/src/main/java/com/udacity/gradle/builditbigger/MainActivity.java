package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.util.Pair;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;

import com.example.android.jokedisplay.JokeActivity;
import com.udacity.gradle.builditbigger.task.EndpointsAsyncTask;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    private MainActivityFragment mainFragment;
    private ProgressBar loadingSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainFragment = (MainActivityFragment) getSupportFragmentManager()
                .findFragmentById(R.id.fragment);

        loadingSpinner = findViewById(R.id.loadingSpinner);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void tellJoke(View view) {
        // Start Loading
        startLoading();
        // Retrieve a joke from appengine
        new ReadJokeAsyncTask().execute();
    }

    private class ReadJokeAsyncTask extends EndpointsAsyncTask {
        @Override
        protected void onPostExecute(final String s) {
            Log.d(TAG, "Joke loaded! : " + s);
            // Stop Loading
            stopLoading();

            mainFragment.actionTellJoke(new MainActivityFragment.PostAction() {
                @Override
                public void action() {
                    startJokeActivity(s);
                }
            });
        }
    }

    private void startLoading() {
        // Hide fragment
        FragmentManager fm = getSupportFragmentManager();
        fm.beginTransaction()
                .setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out)
                .hide(mainFragment)
                .commit();
        // Show spinner
        loadingSpinner.setVisibility(View.VISIBLE);
    }

    private void stopLoading() {
        // Show fragment
        FragmentManager fm = getSupportFragmentManager();
        fm.beginTransaction()
                .setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out)
                .show(mainFragment)
                .commit();
        // Hide spinner
        loadingSpinner.setVisibility(View.GONE);
    }

    private void startJokeActivity(String joke) {
        Intent i = new Intent(this, JokeActivity.class);
        i.putExtra(JokeActivity.ARG_JOKE, joke);
        startActivity(i);
    }


}
