package sang.com.weathermode;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PixelFormat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import sang.com.weathermode.drawable.WeatherDrawable;

/**
 * 作者： ${PING} on 2018/3/29.
 */

public class WeatherView extends SurfaceView implements SurfaceHolder.Callback {

    private String tag = "DemoSurfaceView";


    private int width;
    private int height;


    public WeatherView(Context context) {
        this(context, null);
    }

    public WeatherView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    private void initView(Context context) {

        SurfaceHolder mSurfaceHolder = getHolder();
        mSurfaceHolder.addCallback(this);
        mSurfaceHolder.setFormat(PixelFormat.RGBA_8888);

    }


    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        this.width = w;
        this.height = h;
    }


    @Override
    public void surfaceCreated(SurfaceHolder holder) {

    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
        Canvas canvas = getHolder().lockCanvas();
        if (canvas != null) {
            drawSomething(canvas);
        }
    }


    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        getHolder().removeCallback(this);
        Log.i(tag, "--------------surfaceDestroyed---------------");
    }


    private void drawSomething(Canvas canvas) {
        //获得canvas对象
        //绘制背景
        final int w = width;
        final int h = height;
        if (w == 0 || h == 0) {
            return;
        }

        new WeatherDrawable(false, getContext()).setSize(width, height).draw(canvas);
        getHolder().unlockCanvasAndPost(canvas);
    }


}
