package sang.com.surfaceviewdemo.dynamicweather;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;

import java.util.ArrayList;

import sang.com.surfaceviewdemo.dynamicweather.holder.RainHolder;

/**
 * 下雨
 * @author Mixiaoxiao
 * 
 */
public class RainDrawer extends BaseDrawer {
	static final String TAG = RainDrawer.class.getSimpleName();
	
	public static class RainDrawable{
		public float x,y;
		public float length;
		public Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
		
		public RainDrawable() {
			super();
			paint.setStyle(Style.STROKE);
//			paint.setStrokeJoin(Paint.Join.ROUND);
//			paint.setStrokeCap(Paint.Cap.ROUND);
		}
		public void setColor(int color){
			this.paint.setColor(color);
		}
		public void setStrokeWidth(float strokeWidth){
			this.paint.setStrokeWidth(strokeWidth);
		}
		public void setLocation(float x,float y, float length){
			this.x = x;
			this.y = y;
			this.length = length;
		}
		public void draw(Canvas canvas){
			canvas.drawLine(x, y - length, x, y, paint);
		}
	}
	
	public enum RainLevel{
		LIGHT,MEDIUM,HEAVY,VERY_HEAVY; 
	}

	private RainDrawable drawable;
	private ArrayList<RainHolder> holders = new ArrayList<RainHolder>();

	private final int cfg_count = 50;
//	private final float cfg_rainWidth ,cfg_minRainHeight,cfg_maxRainHeight,cfg_speed;
	
	public RainDrawer(Context context, boolean isNight) {
		super(context, isNight);
		drawable = new RainDrawable();
//		switch (level) {
//		case LIGHT:
//			cfg_count = 30;
//			cfg_minRainHeight = 
//			break;
//
//		default:
//			break;
//		}
	}

	@Override
	public boolean drawWeather(Canvas canvas, float alpha) {
			for (RainHolder holder : holders) {
				holder.updateRandom(drawable, alpha);
				drawable.draw(canvas);
			}
		return true;
	}

	@Override
    public BaseDrawer setSize(int width, int height) {
		super.setSize(width, height);
		if (this.holders.size() == 0) {
//			Log.i(TAG, "x->" + x);
			final float rainWidth =  dp2px(2);//*(1f -  getDownRandFloat(0, 1));
			final float minRainHeight = dp2px(8);
			final float maxRainHeight = dp2px(14);
			final float speed = dp2px(400);
			for (int i = 0; i < cfg_count; i++) {
				float x = getRandom(0f, width);
				RainHolder holder = new RainHolder(x, rainWidth, minRainHeight, maxRainHeight, height,speed);
				holders.add(holder);
			}
		}
		return null;
	}
	
	@Override
	protected int[] getSkyBackgroundGradient() {
		return isNight ? SkyBackground.RAIN_N : SkyBackground.RAIN_D;
	}
	
	
	public static final float acceleration = 9.8f;



}
