package sang.com.surfaceviewdemo.dynamicweather.holder;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;

import static sang.com.surfaceviewdemo.dynamicweather.BaseDrawer.convertAlphaColor;
import static sang.com.surfaceviewdemo.dynamicweather.BaseDrawer.getRandom;

public   class CircleHolder {
    private final float cx, cy, dx, dy, radius;
		private final int color;
		private boolean isGrowing = true;
		private float curPercent = 0f;
		private final float percentSpeed;

		public CircleHolder(float cx, float cy, float dx, float dy, float radius, float percentSpeed, int color) {
			super();
			this.cx = cx;
			this.cy = cy;
			this.dx = dx;
			this.dy = dy;
			this.radius = radius;
			this.percentSpeed = percentSpeed;
			this.color = color;
		}

		public void updateAndDraw(Canvas canvas, Paint paint, float alpha) {
			float randomPercentSpeed = getRandom(percentSpeed * 0.7f, percentSpeed * 1.3f);
			if (isGrowing) {
				curPercent += randomPercentSpeed;
				if (curPercent > 1f) {
					curPercent = 1f;
					isGrowing = false;
				}
			} else {
				curPercent -= randomPercentSpeed;
				if (curPercent < 0f) {
					curPercent = 0f;
					isGrowing = true;
				}
			}
			float curCX = cx + dx * curPercent;
			float curCY = cy + dy * curPercent;
			int curColor = convertAlphaColor(alpha * (Color.alpha(color) / 255f), color);
			paint.setColor(curColor);
			canvas.drawCircle(curCX, curCY, radius, paint);

		}

	}

