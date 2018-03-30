package sang.com.surfaceviewdemo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PixelFormat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import sang.com.surfaceviewdemo.dynamicweather.SunnyDrawer;
import sang.com.weathermode.drawable.FogDrawaber;
import sang.com.weathermode.drawable.WeatherDrawable;

/**
 * 作者： ${PING} on 2018/3/29.
 */

public class WeatherMainView extends SurfaceView implements SurfaceHolder.Callback, Runnable {

    private String tag = "DemoSurfaceView";

    private SurfaceHolder mSurfaceHolder;
    //绘图的Canvas
    private Canvas mCanvas;
    //子线程标志位
    private boolean mIsDrawing;

    private int width;
    private int height;


    public WeatherMainView(Context context) {
        this(context, null, 0);
    }

    public WeatherMainView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public WeatherMainView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    private void initView(Context context) {

        mSurfaceHolder = getHolder();
        mSurfaceHolder.addCallback(this);
        mSurfaceHolder.setFormat(PixelFormat.RGBA_8888);
        setFocusable(true);
        setKeepScreenOn(true);
        setFocusableInTouchMode(true);

    }


    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        mIsDrawing = true;
       new Thread(this).start();

    }


    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
        this.width=width;
        this.height=height;
        drawSomething();
    }

    /**
     * This is called immediately before a surface is being destroyed. After
     * returning from this call, you should no longer try to access this
     * surface.  If you have a rendering thread that directly accesses
     * the surface, you must ensure that thread is no longer touching the
     * Surface before returning from this function.
     *
     * @param holder The SurfaceHolder whose surface is being destroyed.
     */
    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        mIsDrawing = false;
        Log.i(tag, "--------------surfaceDestroyed---------------");
    }

    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {

        while (mIsDrawing){
            drawSomething();
        }
    }



    private void drawSomething() {
        synchronized (WeatherMainView.class) {
            mCanvas = mSurfaceHolder.lockCanvas();
            //获得canvas对象
            //绘制背景
            new SunnyDrawer(getContext()).setSize(width,height).draw(mCanvas,1);
            mSurfaceHolder.unlockCanvasAndPost(mCanvas);
        }
    }


}
