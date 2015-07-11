package com.tiger.xiaohumo.tigerlist;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.view.Window;
import android.view.WindowManager;

/**
 * Created by xiaohumo on 15/7/11.
 */
public class WelcomeActivity extends ActionBarActivity {

    public static final int SPLASH_DELAY = 2000;
    private Intent startNextActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_welcome);

        startNextActivity = new Intent(this, MainActivity.class);
        new Handler().postDelayed(new Runnable() {
            public void run() {
                if (!WelcomeActivity.this.isFinishing()) {
                    WelcomeActivity.this.finish();
                    startActivity(startNextActivity);
                }
            }
        }, SPLASH_DELAY);
    }
}
