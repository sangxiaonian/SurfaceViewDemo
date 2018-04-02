package sang.com.weathermode.drawable.holder;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;

/**
 * 作者： ${PING} on 2018/4/2.
 */

public abstract class BasicWeatherHolder {
    protected float width;
    protected float height;
    protected Context mContext;
    /**
     * 雨滴位置
     */
    public Point loaction;

    public BasicWeatherHolder(float width, float height, Context mContext) {
        this.width = width;
        this.height = height;
        this.mContext = mContext;
    }

    public abstract void excuse(Canvas canvas, Paint mPaint);
}
