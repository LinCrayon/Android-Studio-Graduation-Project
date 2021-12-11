package com.lsq.sudoku;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.ComponentCallbacks;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.airbnb.lottie.LottieAnimationView;

import org.jetbrains.annotations.NotNull;

public class IntroductoryActivity extends AppCompatActivity {
    ImageView logo,appName,spashImg;
    LottieAnimationView lottieAnimationView;

    Animation anim;

    private  static  final  int NUM_PAGES = 3;
    private ViewPager viewPager;
    private ScreenSlidePagerAdapter pagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introductory);
        logo = findViewById(R.id.logo);
        appName = findViewById(R.id.app_name);
        spashImg = findViewById(R.id.img);
        lottieAnimationView = findViewById(R.id.lottie);


        viewPager = findViewById(R.id.pager);
        pagerAdapter = new ScreenSlidePagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(pagerAdapter);


        anim = AnimationUtils.loadAnimation(this,R.anim.o_n_anim);
        viewPager.setAdapter(pagerAdapter);


        spashImg.animate().translationY(-2900).setDuration(1000).setStartDelay(4000);
        appName.animate().translationY(2600).setDuration(1000).setStartDelay(4000);
        logo.animate().translationY(2600).setDuration(1000).setStartDelay(4000);
        lottieAnimationView.animate().translationY(1600).setDuration(1000).setStartDelay(4000);
    }

    private class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {
        public ScreenSlidePagerAdapter(@NonNull @NotNull FragmentManager fm) {
            super(fm);
        }

        @NonNull
        @NotNull
        @Override
        public Fragment getItem(int position) {
            switch (position){
                case 0:
                    OnBoardingfragment1 tab1 = new OnBoardingfragment1();

                case 1:
                    OnBoardingfragment2 tab2 = new OnBoardingfragment2();
                    return tab2;
                case 2:
                    OnBoardingfragment3 tab3 = new OnBoardingfragment3();
                    return tab3;
            }
            return null;
        }

        @Override
        public int getCount() {
            return NUM_PAGES;
        }
    }

}