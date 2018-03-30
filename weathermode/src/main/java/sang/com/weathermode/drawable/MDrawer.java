package sang.com.weathermode.drawable;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.GradientDrawable;

import java.util.Random;

import sang.com.weathermode.drawable.color.SkyBackground;

public abstract class MDrawer {





	protected Context context;
	private final float desity;
	protected int width, height;
	private GradientDrawable skyDrawable;
	protected final boolean isNight;

	public MDrawer(Context context, boolean isNight) {
		super();
		this.context = context;
		this.desity = context.getResources().getDisplayMetrics().density;
		this.isNight = isNight;
	}

	protected void reset() {
	}
	
	public GradientDrawable makeSkyBackground(){
		return new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, getSkyBackgroundGradient());
	}

	protected void drawSkyBackground(Canvas canvas, float alpha) {
		if (skyDrawable == null) {
			skyDrawable = makeSkyBackground();
			skyDrawable.setBounds(0, 0, width, height);
		}
//		skyDrawable.setAlpha(Math.round(alpha * 255f));
		skyDrawable.draw(canvas);
	}

	/**
	 * @param canvas
	 * @return needDrawNextFrame
	 */
	public boolean draw(Canvas canvas, float alpha) {
		drawSkyBackground(canvas, alpha);
		boolean needDrawNextFrame = drawWeather(canvas, alpha);
//
		return needDrawNextFrame;
	}

	public abstract boolean drawWeather(Canvas canvas, float alpha);// return
																	// needDrawNextFrame

	protected int[] getSkyBackgroundGradient() {
		return isNight ? SkyBackground.CLEAR_N : SkyBackground.CLEAR_D;
	}

	protected void setSize(int width, int height) {
		if(this.width != width && this.height != height){
			this.width = width;
			this.height = height;

			if (this.skyDrawable != null) {
				skyDrawable.setBounds(0, 0, width, height);
			}
		}
		
	}



	public float dp2px(float dp) {
		return dp * desity;
	}

	// 获得0--n之内的不等概率随机整数，0概率最大，1次之，以此递减，n最小
	public static int getAnyRandInt(int n) {
		int max = n + 1;
		int bigend = ((1 + max) * max) / 2;
		Random rd = new Random();
		int x = Math.abs(rd.nextInt() % bigend);
		int sum = 0;
		for (int i = 0; i < max; i++) {
			sum += (max - i);
			if (sum > x) {
				return i;
			}
		}
		return 0; 
	}

	/**
	 * 获取[min, max)内的随机数，越大的数概率越小
	 * 参考http://blog.csdn.net/loomman/article/details/3861240
	 * 
	 * @param min
	 * @param max
	 * @return
	 */
	public static float getDownRandFloat(float min, float max) {
		float bigend = ((min + max) * max) / 2f;
		// Random rd = new Random();
		float x = getRandom(min, bigend);// Math.abs(rd.nextInt() % bigend);
		int sum = 0;
		for (int i = 0; i < max; i++) {
			sum += (max - i);
			if (sum > x) {
				return i;
			}
		}
		return min;
	}

	/**
	 * [min, max)
	 * 
	 * @param min
	 * @param max
	 * @return
	 */
	public static float getRandom(float min, float max) {
		if (max < min) {
			throw new IllegalArgumentException("max should bigger than min!!!!");
			// return 0f;
		}
		return (float) (min + Math.random() * (max - min));
	}

	/**
	 * 必须取[0,1]之间的float
	 * 
	 * @param alpha
	 * @return
	 */
	public static float fixAlpha(float alpha) {
		if (alpha > 1f) {
			return 1f;
		}
		if (alpha < 0f) {
			return 0f;
		}
		return alpha;
	}
}
