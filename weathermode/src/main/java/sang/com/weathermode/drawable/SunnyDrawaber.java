package sang.com.weathermode.drawable;

import android.content.Context;
import android.graphics.Canvas;

import sang.com.weathermode.drawable.color.SkyBackground;

/**
 * 作者： ${PING} on 2018/3/30.
 * 晴天
 */

public class SunnyDrawaber  extends WeatherDrawable{


    public SunnyDrawaber(boolean isNight, Context mContext) {
        super(isNight, mContext);
    }

    public int[] getSkyBackColor() {
        return isNight ? SkyBackground.CLEAR_N : SkyBackground.CLEAR_D;
//        return isNight ? SkyBackground.FOG_D : SkyBackground.FOG_N;
    }

}
