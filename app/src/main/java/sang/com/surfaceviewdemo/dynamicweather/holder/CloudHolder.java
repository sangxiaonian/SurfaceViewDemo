package sang.com.surfaceviewdemo.dynamicweather.holder;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;

import static sang.com.surfaceviewdemo.dynamicweather.BaseDrawer.fixAlpha;
import static sang.com.surfaceviewdemo.dynamicweather.BaseDrawer.getRandom;

public   class CloudHolder {
    private final Drawable drawable;
		private final float percentWidthPerframe;
		final float screenWidth;
		final float drawableWidth, drawableHeight;
		float curX;// screenWidth-drawableWidth ~ 0之间的 就是说drawable的宽度必须全部在屏幕内
		final float minX;
		final float maxAlpha;
		final boolean canLoop;

		/**
		 * drawableWidth 必须>ScreenWidth
		 * 
		 * @param drawable
		 * @param percentWidthPerframe
		 *            相对于drawableWidth每一帧移动的距离,screenWidth*2时大约 0.0002f
		 * @param screenWidth
		 * @param drawableWidth
		 * @param maxAlpha
		 * @param canLoop是否可以循环移动
		 *            （如果左边正好接上右边就设置为true)
		 */
		public CloudHolder(Drawable drawable, float percentWidthPerframe, float screenWidth, float drawableWidth,
                           float maxAlpha, final boolean canLoop) {
			this.drawable = drawable;
			this.percentWidthPerframe = percentWidthPerframe;
			this.screenWidth = screenWidth;
			if (drawableWidth < screenWidth) {
				drawableWidth = screenWidth * 1.1f;
			}
			float scale = drawableWidth / drawable.getIntrinsicWidth();
			this.drawableWidth = drawableWidth;
			this.drawableHeight = drawable.getIntrinsicHeight() * scale;
			minX = this.screenWidth - this.drawableWidth;
			this.curX = getRandom(minX, 0);
			this.maxAlpha = maxAlpha;
			this.canLoop = canLoop;
		}

		public void updateAndDraw(Canvas canvas, float alpha) {
			curX -= percentWidthPerframe * drawableWidth * getRandom(0.5f, 1);
			if (curX < minX) {
				curX = 0f;
			}
			float curAlpha = 1f;
			if (!canLoop) {
				float percent = Math.abs(curX / minX);
				curAlpha = (percent > 0.5f) ? ((1 - percent) / 0.5f) : (percent / 0.5f);
				curAlpha = fixAlpha(curAlpha) * maxAlpha;
			}
			drawable.setAlpha(Math.round(alpha * 255f * curAlpha));
			final int left = Math.round(curX);
			drawable.setBounds(left, 0, Math.round(left + drawableWidth), Math.round(drawableHeight));
			drawable.draw(canvas);

		}
	}
