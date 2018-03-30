package sang.com.surfaceviewdemo.dynamicweather;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;

import java.util.ArrayList;

import sang.com.surfaceviewdemo.dynamicweather.holder.CircleHolder;

public class CloudyDrawer extends BaseDrawer {

	// final ArrayList<CloudHolder> holders = new ArrayList<CloudHolder>();
	final ArrayList<CircleHolder> holders = new ArrayList<CircleHolder>();
	private Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);

	public CloudyDrawer(Context context, boolean isNight) {
		super(context, isNight);

	}

	@Override
    public BaseDrawer setSize(int width, int height) {
		super.setSize(width, height);
		if (holders.size() == 0) {
			holders.add(new CircleHolder(0.20f * width, -0.30f * width, 0.06f * width, 0.022f * width, 0.56f * width,
					0.0015f, isNight ? 0x183c6b8c : 0x28ffffff));
			holders.add(new CircleHolder(0.58f * width, -0.35f * width, -0.15f * width, 0.032f * width, 0.6f * width,
					0.00125f, isNight ? 0x223c6b8c : 0x33ffffff));
			holders.add(new CircleHolder(0.9f * width, -0.19f * width, 0.08f * width, -0.015f * width, 0.44f * width,
					0.0025f, isNight ? 0x153c6b8c : 0x15ffffff));
		}
		return null;
	}

	@Override
	public boolean drawWeather(Canvas canvas, float alpha) {
			for (CircleHolder holder : this.holders) {
				holder.updateAndDraw(canvas, paint, alpha);
			}
		return true;
	}

	@Override
	protected int[] getSkyBackgroundGradient() {
		return isNight ? SkyBackground.CLOUDY_N : SkyBackground.CLOUDY_D;
	}

}
