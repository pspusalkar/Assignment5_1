package com.example.poojajoshi.assignment5_1;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.ScaleAnimation;
import android.widget.Toast;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements Animation.AnimationListener {

    Animation animIn, animOut;
    TextView text;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        text = findViewById(R.id.textView);
        button = findViewById(R.id.button2);

        // load the animation
        animIn = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_in);
        animOut = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_out);

        // set button onclick Listener
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text.setVisibility(View.VISIBLE);

                // start the animation
                text.startAnimation(animIn);
            }
        });
    }

    @Override
    public void onAnimationEnd(Animation animation) {
        // Take any action after completing the animation

        // check for fadein animation
        if (animation == animIn) {
            text.startAnimation(animOut);
            animOut.start();
        }
    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }

    @Override
    public void onAnimationStart(Animation animation) {

    }
}
