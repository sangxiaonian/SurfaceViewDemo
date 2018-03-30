package sang.com.surfaceviewdemo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.PixelFormat;
import android.graphics.PorterDuff.Mode;
import android.util.AttributeSet;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import sang.com.surfaceviewdemo.dynamicweather.BaseDrawer;
import sang.com.weathermode.drawable.WeatherDrawable;

public class DemoSurfaceView extends SurfaceView implements SurfaceHolder.Callback {

    static final String TAG = DemoSurfaceView.class.getSimpleName();

    public DemoSurfaceView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private int mWidth, mHeight;

    private void init(Context context) {
        final SurfaceHolder surfaceHolder = getHolder();
        surfaceHolder.addCallback(this);
        surfaceHolder.setFormat(PixelFormat.RGBA_8888);
    }



    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        // updateDrawerSize(w, h);
        mWidth = w;
        mHeight = h;
    }

    private boolean drawSurface(Canvas canvas) {
        final int w = mWidth;
        final int h = mHeight;
        if (w == 0 || h == 0) {
            return true;
        }
        boolean needDrawNextFrame = false;
        new WeatherDrawable(false,getContext()).setSize(w,h).draw(canvas);


        return needDrawNextFrame;
    }


    @Override
    public void surfaceCreated(SurfaceHolder holder) {


        Log.i(TAG, "surfaceCreated");
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

        Canvas canvas = getHolder().lockCanvas();

        if (canvas != null) {
            canvas.drawColor(Color.TRANSPARENT, Mode.CLEAR);

            drawSurface(canvas);

            getHolder().unlockCanvasAndPost(canvas);

        } else {
            Log.i(TAG, "Failure locking canvas");
        }

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

        holder.removeCallback(this);
        Log.i(TAG, "surfaceDestroyed");
    }


}
