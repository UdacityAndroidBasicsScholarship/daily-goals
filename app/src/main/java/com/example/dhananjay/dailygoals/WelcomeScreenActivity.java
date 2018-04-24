package com.example.dhananjay.dailygoals;

import com.stephentuso.welcome.ParallaxPage;
import com.stephentuso.welcome.WelcomeActivity;
import com.stephentuso.welcome.WelcomeConfiguration;

public class WelcomeScreenActivity extends WelcomeActivity {

    @Override
    protected WelcomeConfiguration configuration() {
        return new WelcomeConfiguration.Builder(this)
                .defaultTitleTypefacePath("Montserrat-Bold.ttf")
                .defaultHeaderTypefacePath("Montserrat-Bold.ttf")

                .page(new ParallaxPage(R.layout.parallax1,
                        getResources().getString(R.string.title_welcome),
                        getResources().getString(R.string.description_welcome))
                        .lastParallaxFactor(2f)
                        .background(R.color.blue_background)
                )

                .page(new ParallaxPage(R.layout.parallax2,
                        getResources().getString(R.string.title_life_guide),
                        getResources().getString(R.string.description_life_guide))
                        .lastParallaxFactor(2f)
                        .background(R.color.grey_background)
                )

                .page(new ParallaxPage(R.layout.parallax3,
                        getResources().getString(R.string.title_time_manager),
                        getResources().getString(R.string.description_time_manager))
                        .lastParallaxFactor(2f)
                        .background(R.color.orange_background)
                )

                .page(new ParallaxPage(R.layout.parallax4,
                        getResources().getString(R.string.title_performance),
                        getResources().getString(R.string.description_performance))
                        .lastParallaxFactor(2f)
                        .background(R.color.red_background)
                )

                .swipeToDismiss(true)
                .exitAnimation(android.R.anim.fade_out)
                .build();
    }

}
