package sang.com.surfaceviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import sang.com.surfaceviewdemo.dynamicweather.BaseDrawer;
import sang.com.surfaceviewdemo.dynamicweather.DynamicWeatherView;
import sang.com.weathermode.WeatherView;
import sang.com.weathermode.drawable.FogDrawaber;
import sang.com.weathermode.drawable.WeatherDrawable;
import sang.com.weathermode.drawable.color.SkyBackground;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    WeatherView weatherView;
    Button btChange;
    ImageView img;
    private FogDrawaber fogDrawaber;
    private DemoSurfaceView demo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        weatherView = findViewById(R.id.weather);
        demo = findViewById(R.id.demo);
        btChange= findViewById(R.id.bt_change);
        btChange.setOnClickListener(this);

        WeatherDrawable drawable = new WeatherDrawable(false,this);
          fogDrawaber = new FogDrawaber(false,this);
        drawable.setSize(100,100);
        fogDrawaber.setSize(100,100);
          img = findViewById(R.id.img);
        img.setBackground(drawable.getDrawable());
    }





    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_change:
                weatherView.changeType();


                img.setBackground(fogDrawaber.getDrawable());
                break;
        }
    }
}
