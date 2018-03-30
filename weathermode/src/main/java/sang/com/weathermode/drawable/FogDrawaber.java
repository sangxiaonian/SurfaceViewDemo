package sang.com.weathermode.drawable;

import android.content.Context;

import sang.com.weathermode.drawable.color.SkyBackground;

/**
 * 作者： ${PING} on 2018/3/30.
 * 晴天
 */

public class FogDrawaber extends WeatherDrawable{


    public FogDrawaber(boolean isNight, Context mContext) {
        super(isNight, mContext);
    }

    public int[] getSkyBackColor() {
        return isNight ? SkyBackground.FOG_N : SkyBackground.FOG_D;
//        return isNight ? SkyBackground.FOG_D : SkyBackground.FOG_N;
    }

}
