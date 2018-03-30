package sang.com.weathermode.factory;

import android.animation.ArgbEvaluator;
import android.content.Context;


import sang.com.weathermode.drawable.SunnyDrawaber;
import sang.com.weathermode.drawable.WeatherDrawable;


/**
 * 作者： ${PING} on 2018/3/30.
 * 天气背景
 *
 */
public   class WeatherBgFactory {

    public enum WeatherType {
        CLEAR_D, CLEAR_N, RAIN_D, RAIN_N, SNOW_D, SNOW_N, CLOUDY_D, CLOUDY_N,
        OVERCAST_D, OVERCAST_N, FOG_D, FOG_N, HAZE_D, HAZE_N, SAND_D, SAND_N,
        WIND_D, WIND_N, RAIN_SNOW_D, RAIN_SNOW_N, UNKNOWN_D, UNKNOWN_N
    }

}
