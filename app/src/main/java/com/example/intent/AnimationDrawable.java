package com.example.intent;

import android.animation.AnimatorInflater;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.example.hoperun.myapplication.R;

public class AnimationDrawable extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation_drawable);
        RelativeLayout rl = (RelativeLayout) findViewById(R.id.rl_animator);
        rl.addView(new MyAnimationView(this));

        final ImageView imageView = (ImageView) findViewById(R.id.imageAnim);
        final Animation animation = AnimationUtils.loadAnimation(this, R.anim.my_anim);
//        animation.setFillAfter(true);
        Button button = (Button) findViewById(R.id.btnStartAnim);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView.startAnimation(animation);
            }
        });
    }
    public class MyAnimationView extends View{

        public MyAnimationView(Context context) {
            super(context);
            ObjectAnimator colorAnim = (ObjectAnimator) AnimatorInflater
                    .loadAnimator(AnimationDrawable.this,R.animator.color_anim);
            colorAnim.setEvaluator(new ArgbEvaluator());
            colorAnim.setTarget(this);
            colorAnim.start();
        }
    }
}
