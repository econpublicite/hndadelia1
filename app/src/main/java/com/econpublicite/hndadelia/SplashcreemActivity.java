package com.econpublicite.hndadelia;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class SplashcreemActivity extends AppCompatActivity {

    private ImageView splash ;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashcreem);
        splash =(ImageView) findViewById(R.id.splash1);
        Animation myamin = AnimationUtils.loadAnimation(this,R.anim.mytrans);
        splash.startAnimation(myamin);
        final Intent i =new Intent(this,MainActivity.class);
        Thread timer =new Thread(){
            public void run () {
                try {
                    sleep(5000) ;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                finally {
                    startActivity(i);
                    finish();
                }
            }

        };
        timer.start();


    }

}

