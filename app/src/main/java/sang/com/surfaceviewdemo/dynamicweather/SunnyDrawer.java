package sang.com.surfaceviewdemo.dynamicweather;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.GradientDrawable;

import java.util.ArrayList;

/**
 * 晴天
 * @author Mixiaoxiao
 * 
 */
public class SunnyDrawer extends BaseDrawer {

	public SunnyDrawer(Context context) {
		super(context, false);

	}


	@Override
	public boolean drawWeather(Canvas canvas, float alpha) {
		return true;
	}
}
