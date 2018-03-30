package sang.com.surfaceviewdemo.dynamicweather.holder;

import android.graphics.drawable.GradientDrawable;

import static sang.com.surfaceviewdemo.dynamicweather.BaseDrawer.getRandom;

public   class SnowHolder {
    public float x;
		// public float y;//y 表示雨滴底部的y坐标,由curTime求得
		public final float snowSize;
		public final float maxY;// [0,1]
		public float curTime;// [0,1]
		public final float v;// 速度

		/**
		 * @param x
		 * @param snowSize
		 * @param maxY
		 * @param averageSpeed
		 */
		public SnowHolder(float x, float snowSize, float maxY, float averageSpeed) {
			super();
			this.x = x;
			this.snowSize = snowSize;
			this.maxY = maxY;
			this.v = averageSpeed * getRandom(0.85f, 1.15f);
			final float maxTime = maxY / this.v;
			this.curTime = getRandom(0, maxTime);
		}

		public void updateRandom(GradientDrawable drawable, float alpha) {
			curTime += 0.025f;
			float curY = curTime * this.v;
			if ((curY - this.snowSize) > this.maxY) {
				this.curTime = 0f;
			}
			final int left = Math.round(x - snowSize / 2f);
			final int right = Math.round(x + snowSize / 2f);
			final int top = Math.round(curY - snowSize);
			final int bottom = Math.round(curY);
			drawable.setBounds(left, top, right, bottom);
			drawable.setGradientRadius(snowSize / 2.2f);
			drawable.setAlpha((int) (255 * alpha));
		}
	}