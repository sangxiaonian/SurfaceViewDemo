package sang.com.surfaceviewdemo;

import android.app.Activity;
import android.graphics.Color;
import android.os.Build;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

import java.util.ArrayList;
import java.util.List;

import sang.com.weathermode.WeatherView;
import sang.com.weathermode.drawable.WeatherConver;
import sang.com.weathermode.fragment.WeatherFragment;

public class MainActivity extends AppCompatActivity {
    WeatherView weatherView;
    ViewPager vp;
    /**
     * 使状态栏透明
     * <p>
     * 适用于图片作为背景的界面,此时需要图片填充到状态栏
     *
     * @param activity 需要设置的activity
     */
    public void setTranslucent(Activity activity) {
        if (Build.VERSION.SDK_INT >= 21) {
            View decorView = getWindow().getDecorView();
            int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
            decorView.setSystemUiVisibility(option);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
        ActionBar actionBar = getSupportActionBar();
        if (actionBar!=null) {
            actionBar.hide();
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTranslucent(this);
        weatherView = findViewById(R.id.weather);
        vp = findViewById(R.id.vp);
        final WeatherAdapter weatherAdapter = new WeatherAdapter(getSupportFragmentManager(), creatDatas());
        vp.setAdapter(weatherAdapter);
        vp.addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener(){
            @Override
            public void onPageSelected(int position) {
                WeatherConver.WeatherType type= weatherAdapter.fragments.get(position).getType();
                weatherView.changeWeather(type);
            }
        });

    }

    public List<WeatherFragment> creatDatas() {
        List<WeatherFragment> fragments = new ArrayList<>();
        WeatherFragment cleardFragment = new WeatherFragment();
        cleardFragment.setType(WeatherConver.WeatherType.CLEAR_D);
        fragments.add(cleardFragment);

        WeatherFragment cleardFragment1 = new WeatherFragment();
        cleardFragment1.setType(WeatherConver.WeatherType.CLEAR_N);
        fragments.add(cleardFragment1);

        WeatherFragment cleardFragment2 = new WeatherFragment();
        cleardFragment2.setType(WeatherConver.WeatherType.RAIN_D);
        fragments.add(cleardFragment2);

        WeatherFragment cleardFragment3 = new WeatherFragment();
        cleardFragment3.setType(WeatherConver.WeatherType.RAIN_N);
        fragments.add(cleardFragment3);

        WeatherFragment cleardFragment4 = new WeatherFragment();
        cleardFragment4.setType(WeatherConver.WeatherType.SNOW_D);
        fragments.add(cleardFragment4);

        WeatherFragment cleardFragment5 = new WeatherFragment();
        cleardFragment5.setType(WeatherConver.WeatherType.SNOW_N);
        fragments.add(cleardFragment5);

        WeatherFragment cleardFragment6 = new WeatherFragment();
        cleardFragment6.setType(WeatherConver.WeatherType.OVERCAST_D);
        fragments.add(cleardFragment6);

        WeatherFragment cleardFragment7 = new WeatherFragment();
        cleardFragment7.setType(WeatherConver.WeatherType.OVERCAST_N);
        fragments.add(cleardFragment7);

        WeatherFragment cleardFragment8 = new WeatherFragment();
        cleardFragment8.setType(WeatherConver.WeatherType.FOG_D);
        fragments.add(cleardFragment8);

        WeatherFragment cleardFragment9 = new WeatherFragment();
        cleardFragment9.setType(WeatherConver.WeatherType.FOG_N);
        fragments.add(cleardFragment9);

        WeatherFragment cleardFragment10 = new WeatherFragment();
        cleardFragment10.setType(WeatherConver.WeatherType.HAZE_D);
        fragments.add(cleardFragment10);

        WeatherFragment cleardFragment11 = new WeatherFragment();
        cleardFragment11.setType(WeatherConver.WeatherType.HAZE_N);
        fragments.add(cleardFragment11);

        WeatherFragment cleardFragment12 = new WeatherFragment();
        cleardFragment12.setType(WeatherConver.WeatherType.SAND_D);
        fragments.add(cleardFragment12);

        WeatherFragment cleardFragment13 = new WeatherFragment();
        cleardFragment13.setType(WeatherConver.WeatherType.SAND_N);
        fragments.add(cleardFragment13);

        WeatherFragment cleardFragment14 = new WeatherFragment();
        cleardFragment14.setType(WeatherConver.WeatherType.WIND_D);
        fragments.add(cleardFragment14);

        WeatherFragment cleardFragment15 = new WeatherFragment();
        cleardFragment15.setType(WeatherConver.WeatherType.WIND_N);
        fragments.add(cleardFragment15);

        WeatherFragment cleardFragment16 = new WeatherFragment();
        cleardFragment16.setType(WeatherConver.WeatherType.RAIN_SNOW_D);
        fragments.add(cleardFragment16);

        WeatherFragment cleardFragment17 = new WeatherFragment();
        cleardFragment17.setType(WeatherConver.WeatherType.RAIN_SNOW_N);
        fragments.add(cleardFragment17);

        WeatherFragment cleardFragment18 = new WeatherFragment();
        cleardFragment18.setType(WeatherConver.WeatherType.UNKNOWN_D);
        fragments.add(cleardFragment18);

        WeatherFragment cleardFragment19 = new WeatherFragment();
        cleardFragment19.setType(WeatherConver.WeatherType.UNKNOWN_N);
        fragments.add(cleardFragment19);
        return fragments;
    }


    public class WeatherAdapter extends FragmentPagerAdapter {

        List<WeatherFragment> fragments = new ArrayList<>();

        public WeatherAdapter(FragmentManager fm, List<WeatherFragment> fragments) {
            super(fm);
            this.fragments = fragments;
        }

        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }


        @Override
        public int getCount() {
            return fragments.size();
        }
    }

}
