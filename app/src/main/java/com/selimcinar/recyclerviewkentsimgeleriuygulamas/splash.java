package com.selimcinar.recyclerviewkentsimgeleriuygulamas;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

public class splash extends AppCompatActivity {

    private static int SPLASH_TIME_OUT = 5000; // 5 saniye sürecek
    private MediaPlayer mediaPlayer;
    private TextView colorChangeTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        colorChangeTextView =findViewById(R.id.colorText);

        mediaPlayer = MediaPlayer.create(this, R.raw.turkiyem); // raw klasöründeki ses dosyasını belirtin

        // StatusBar'ı gizle
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        // Splash ekranı süresi kadar bekleyip sonra main activity'e geçiş yap
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(splash.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        }, SPLASH_TIME_OUT);

        startColorAnimation(colorChangeTextView);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mediaPlayer.start(); // Ses çalmaya başla
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mediaPlayer.release();
    }
    public void startColorAnimation(View view) {
        int startColor = ContextCompat.getColor(this, R.color.white); // başlangıç rengi
        int endColor = ContextCompat.getColor(this, R.color.red); // bitiş rengi

        ValueAnimator colorAnimator = ObjectAnimator.ofObject(
                colorChangeTextView,
                "backgroundColor",
                new ArgbEvaluator(),
                startColor,
                endColor
        );

        colorAnimator.setDuration(150); // animasyon süresi (ms)
        colorAnimator.start();

        colorAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animator) {
                int animatedColor = (int) animator.getAnimatedValue();
                colorChangeTextView.setBackgroundColor(animatedColor);
            }
        });
    }
}
