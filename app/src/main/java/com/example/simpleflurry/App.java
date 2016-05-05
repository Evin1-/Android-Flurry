package com.example.simpleflurry;

import android.app.Application;

import com.flurry.android.FlurryAgent;

/**
 * Created by evin on 5/4/16.
 */
public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        FlurryAgent.setLogEnabled(true);
        FlurryAgent.init(this, getString(R.string.flurry_key));
    }
}
