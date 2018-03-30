package sang.com.weathermode;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import sang.com.weathermode.drawable.FogDrawaber;
import sang.com.weathermode.drawable.SunnyDrawaber;
import sang.com.weathermode.drawable.WeatherDrawable;

/**
 * 作者： ${PING} on 2018/3/29.
 */

public class WeatherView extends SurfaceView implements SurfaceHolder.Callback, Runnable {

    private String tag = "DemoSurfaceView";

    private SurfaceHolder mSurfaceHolder;
    //绘图的Canvas
    private Canvas mCanvas;
    //子线程标志位
    private boolean mIsDrawing;

    WeatherDrawable drawable;
    private Paint mPaint;
    private Thread thread;
    private int width;
    private int height;


    public WeatherView(Context context) {
        this(context, null, 0);
    }

    public WeatherView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public WeatherView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    private void initView(Context context) {
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setColor(Color.RED);

        mSurfaceHolder = getHolder();
        mSurfaceHolder.addCallback(this);
        setFocusable(true);
        setKeepScreenOn(true);
        setFocusableInTouchMode(true);

    }


    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        mIsDrawing = true;
        thread = new Thread(this);
        thread.start();
    }


    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
        drawable = new WeatherDrawable(false,getContext());
        this.width=width;
        this.height=height;
        drawable.setSize(width, height);
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

    }

   public void changeType(){
        drawable=new FogDrawaber(false,getContext()).setSize(width,height);
        drawable.setSize(width,height);
        drawSomething();
   };



    private void drawSomething() {
        mCanvas = mSurfaceHolder.lockCanvas();
        //获得canvas对象
        //绘制背景
        if (drawable != null && mCanvas != null) {
            drawable.draw(mCanvas);
        }
        mSurfaceHolder.unlockCanvasAndPost(mCanvas);
    }


}
