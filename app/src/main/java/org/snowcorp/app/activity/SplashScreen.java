package org.snowcorp.app.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;


import org.snowcorp.app.R;
import org.snowcorp.app.utils.GlobalUtils;

import java.net.HttpURLConnection;
import java.net.URL;


public class SplashScreen extends AppCompatActivity {
    Animation alphaAnimation, translateAnimation;
    LinearLayout l;
    ImageView iv;
    boolean loginstatus;
    int connection = 0;

    boolean url_exist;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.splash_screen);


        Log.d("response", String.valueOf(url_exist));

        l = (LinearLayout) findViewById(R.id.lin_lay);
        iv = (ImageView) findViewById(R.id.logo);

        loginstatus = GlobalUtils.getBoolean("status", this);
        Log.d("LoginStatus", loginstatus + "");

        alphaAnimation = AnimationUtils.loadAnimation(this, R.anim.alpha);
        translateAnimation = AnimationUtils.loadAnimation(this, R.anim.translate);
        StartAnimations();
        eventHandling();
    }


    private void eventHandling() {
        l.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StartAnimations();
            }
        });

    }


    private void StartAnimations() {

        l.startAnimation(alphaAnimation);
        iv.startAnimation(translateAnimation);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                navigateActivity();
            }
        }, 3000);


    }

    private void navigateActivity() {
        if (loginstatus) {
            CountDownTime timer = new CountDownTime(1500, 1500, SplashScreen.this, Dashboard.class);
            timer.start();
        } else {
            CountDownTime timer = new CountDownTime(1500, 1500, SplashScreen.this, LoginActivity.class);
            timer.start();
        }
    }
}
