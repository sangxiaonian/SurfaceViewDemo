package sang.com.weathermode.factory;


import android.content.Context;
import android.graphics.Point;

import java.util.ArrayList;
import java.util.List;

import sang.com.weathermode.drawable.holder.BasicWeatherHolder;
import sang.com.weathermode.drawable.holder.RainHolder;
import sang.com.weathermode.drawable.holder.SnowHolder;
import sang.com.weathermode.weatherutils.WUtils;

/**
 * 作者： ${PING} on 2018/3/30.
 * 天气背景
 *
 */
public   class WeatherBgFactory {





    public static List<BasicWeatherHolder> creatRain(Context context,int count, int width, int height){
        List<BasicWeatherHolder> rains = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            RainHolder rainHolder = new RainHolder(width,height,context);
            rains.add(rainHolder);
        }
        return rains;
    }
    public static List<BasicWeatherHolder> creatSnow(Context context, int count, int width, int height){
        List<BasicWeatherHolder> rains = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            SnowHolder rainHolder = new SnowHolder(width,height,context);
            rains.add(rainHolder);
        }
        return rains;
    }

}
