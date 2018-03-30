package sang.com.surfaceviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import sang.com.weathermode.WeatherView;
import sang.com.weathermode.drawable.color.SkyBackground;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    WeatherView weatherView;
    Button btChange;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        weatherView = findViewById(R.id.weather);
        btChange= findViewById(R.id.bt_change);
        btChange.setOnClickListener(this);

    }





    private boolean change;
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_change:

                if (change) {
                    weatherView.changeColorsWithAni(SkyBackground.CLEAR_N);
                }else {
                    weatherView.changeColorsWithAni(SkyBackground.CLOUDY_D);
                }
                change=!change;
                break;
        }
    }
}
