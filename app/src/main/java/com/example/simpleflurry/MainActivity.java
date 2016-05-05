package com.example.simpleflurry;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.flurry.android.FlurryAgent;
import com.flurry.android.FlurryAgentListener;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivityTAG_";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();
        FlurryAgent.onStartSession(this);
        FlurryAgent.setFlurryAgentListener(new FlurryAgentListener() {
            @Override
            public void onSessionStarted() {
                logFlurry();
                Log.d(TAG, "onSessionStarted: " + FlurryAgent.getSessionId());
                Log.d(TAG, "onSessionStarted: " + FlurryAgent.isSessionActive());
                Log.d(TAG, "onSessionStarted: " + FlurryAgent.getReleaseVersion());
            }
        });
    }

    private void logFlurry() {
        Map<String, String> articleParams = new HashMap<>();

        articleParams.put("Author", "John Q");
        articleParams.put("User_Status", "Registered");

        FlurryAgent.logEvent("Article_Write", articleParams);
    }

    @Override
    protected void onStop() {
        super.onStop();
        FlurryAgent.onEndSession(this);
    }
}
