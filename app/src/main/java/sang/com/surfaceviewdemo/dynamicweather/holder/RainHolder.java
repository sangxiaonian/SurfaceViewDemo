package sang.com.surfaceviewdemo.dynamicweather.holder;

import android.graphics.Color;

import sang.com.surfaceviewdemo.dynamicweather.RainDrawer;

import static sang.com.surfaceviewdemo.dynamicweather.BaseDrawer.getRandom;

public   class RainHolder {
    public float x;
//		public float y;//y 表示雨滴底部的y坐标,由curTime求得
		public final float rainWidth;
		public final float rainHeight;
		public final float maxY;// [0,1]
		public float curTime;// [0,1]
		public final int rainColor;
		public final float v;//速度
//		public boolean alphaIsGrowing = true;
		
		/**
		 * @param x 雨滴中心的x坐标
		 * @param rainWidth 雨滴宽度
		 * @param maxRainHeight  最大的雨滴长度
		 * @param maxY 屏幕高度
		 */
		public RainHolder(float x,float rainWidth,float minRainHeight,float maxRainHeight, float maxY,float speed ) {
			super();
			this.x = x;
			this.rainWidth = rainWidth;
			this.rainHeight = getRandom(minRainHeight, maxRainHeight);
			this.rainColor = Color.argb((int) (getRandom(0.1f, 0.5f) * 255f), 0xff, 0xff, 0xff);
			this.maxY = maxY;
//			this.v0 = 0;//maxY * 0.1f;
			this.v = speed * getRandom(0.9f, 1.1f);
			final float maxTime = maxY / this.v;//  (float) Math.sqrt(2f * maxY / acceleration);//s = 0.5*a*t^2;
			this.curTime = getRandom(0, maxTime);
		}

		public void updateRandom(RainDrawer.RainDrawable drawable, float alpha) {
			curTime += 0.025f;
//			float curY = v0 * curTime + 0.5f * acceleration * curTime * curTime;
			float curY = curTime * this.v;
			if((curY - this.rainHeight) > this.maxY){
				this.curTime = 0f;
			}
			drawable.setColor(Color.argb((int) (Color.alpha(rainColor) * alpha), 0xff, 0xff, 0xff));
			drawable.setStrokeWidth(rainWidth);
			drawable.setLocation(x, curY, rainHeight);
		}
	}