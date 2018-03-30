package sang.com.surfaceviewdemo.dynamicweather;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.GradientDrawable;

import java.util.ArrayList;

import sang.com.surfaceviewdemo.dynamicweather.holder.SnowHolder;

/**
 * 下雪
 * 
 * @author Mixiaoxiao
 * 
 */
public class SnowDrawer extends BaseDrawer {
	static final String TAG = SnowDrawer.class.getSimpleName();

	private GradientDrawable drawable;
	private ArrayList<SnowHolder> holders = new ArrayList<SnowHolder>();

	private static final int COUNT = 30;
	private static final float MIN_SIZE = 12f;// dp
	private static final float MAX_SIZE = 30f;// dp

	public SnowDrawer(Context context, boolean isNight) {
		super(context, isNight);
		drawable = new GradientDrawable(GradientDrawable.Orientation.BL_TR, new int[] { 0x99ffffff, 0x00ffffff });
		drawable.setShape(GradientDrawable.OVAL);
		drawable.setGradientType(GradientDrawable.RADIAL_GRADIENT);
	}

	@Override
	public boolean drawWeather(Canvas canvas, float alpha) {
		for (SnowHolder holder : holders) {
			holder.updateRandom(drawable, alpha);
			drawable.draw(canvas);
		}
		return true;
	}

	@Override
    public BaseDrawer setSize(int width, int height) {
		super.setSize(width, height);
		if (this.holders.size() == 0) {
			final float minSize = dp2px(MIN_SIZE);
			final float maxSize = dp2px(MAX_SIZE);
			final float speed = dp2px(80);// 40当作中雪80
			for (int i = 0; i < COUNT; i++) {
				final float size = getRandom(minSize, maxSize);
				SnowHolder holder = new SnowHolder(getRandom(0, width), size, height, speed);
				holders.add(holder);
			}
		}
		return null;
	}
	@Override
	protected int[] getSkyBackgroundGradient() {
		return isNight ? SkyBackground.SNOW_N : SkyBackground.SNOW_D;
	}


}
