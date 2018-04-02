package sang.com.weathermode.factory;


import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import sang.com.weathermode.drawable.WeatherConver;
import sang.com.weathermode.drawable.holder.BasicWeatherHolder;
import sang.com.weathermode.drawable.holder.RainHolder;
import sang.com.weathermode.drawable.holder.SnowHolder;
import sang.com.weathermode.drawable.holder.StarHolder;


/**
 * 作者： ${PING} on 2018/3/30.
 * 天气背景
 */
public class WeatherBgFactory {


    public static List<BasicWeatherHolder> creatWeatherHolder(WeatherConver.WeatherType type, Context mContext,   int width, int height) {
        List<BasicWeatherHolder> weatherBgColor = null;
        switch (type) {
            //晴天
            case CLEAR_D:
//                weatherBgColor = creatSnow(mContext, count, width, height);
                break;
            case CLEAR_N:
                weatherBgColor = creatStar(mContext, 100, width, height);
                break;

            //雨天
            case RAIN_D:
            case RAIN_N:
                weatherBgColor = creatRain(mContext, 100, width, height);
                break;

            //下雪
            case SNOW_D:
            case SNOW_N:
                weatherBgColor = creatRain(mContext, 100, width, height);
                break;
            //多云
            case CLOUDY_D:
            case CLOUDY_N:
                weatherBgColor = creatStar(mContext, 100, width, height);
                break;
            //阴天
            case OVERCAST_D:

            case OVERCAST_N:
                weatherBgColor = creatStar(mContext, 100, width, height);
                break;
            //大雾
            case FOG_D:

            case FOG_N:
                weatherBgColor = creatStar(mContext, 100, width, height);
                break;
            //雾霾
            case HAZE_D:

            case HAZE_N:
                weatherBgColor = creatStar(mContext, 100, width, height);
                break;

            //风沙
            case SAND_D:
                break;
            case SAND_N:
                weatherBgColor = creatStar(mContext, 100, width, height);
                break;

            //大风
            case WIND_D:

            case WIND_N:
                weatherBgColor = creatStar(mContext, 100, width, height);
                break;

            //雨夹雪
            case RAIN_SNOW_D:

            case RAIN_SNOW_N:
                weatherBgColor = creatRainAndSnow(mContext, 100, width, height);

                break;

            //未知天气
            case UNKNOWN_D:
                break;
            case UNKNOWN_N:
                break;
            default:
        }
        return weatherBgColor;
    }


    public static List<BasicWeatherHolder> creatRain(Context context, int count, int width, int height) {
        List<BasicWeatherHolder> holders = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            RainHolder rainHolder = new RainHolder(width, height, context);
            holders.add(rainHolder);
        }
        return holders;
    }

    public static List<BasicWeatherHolder> creatSnow(Context context, int count, int width, int height) {
        List<BasicWeatherHolder> holders = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            SnowHolder rainHolder = new SnowHolder(width, height, context);
            holders.add(rainHolder);
        }
        return holders;
    }

    public static List<BasicWeatherHolder> creatRainAndSnow(Context context, int count, int width, int height) {
        List<BasicWeatherHolder> holders = new ArrayList<>();
        for (int i = 0; i < count / 2; i++) {
            SnowHolder rainHolder = new SnowHolder(width, height, context);
            holders.add(rainHolder);
            SnowHolder snowHolder = new SnowHolder(width, height, context);
            holders.add(snowHolder);
        }
        return holders;
    }

    public static List<BasicWeatherHolder> creatStar(Context context, int count, int width, int height) {
        List<BasicWeatherHolder> holders = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            StarHolder rainHolder = new StarHolder(width, height, context);
            holders.add(rainHolder);
        }
        return holders;
    }

}
