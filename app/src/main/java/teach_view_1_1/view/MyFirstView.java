package teach_view_1_1.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by sunqi on 2018/6/13.
 */

public class MyFirstView extends View{
    private Paint mPaint;
    private Context mContext;

    public MyFirstView(Context context) {
        super(context);
        init(context);
    }

    public MyFirstView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public MyFirstView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public MyFirstView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context);
    }

    private void init(Context context) {
        mPaint = new Paint();

        mContext = context;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
//        DrawView(canvas);
        DrawArc(canvas);
    }

    private void DrawView(Canvas canvas) {
        mPaint.setColor(Color.BLACK);
        mPaint.setStrokeWidth(20);
        mPaint.setStrokeCap(Paint.Cap.ROUND);
        float[] points = {0, 0, 50, 50, 50, 100, 100, 50, 100, 100, 150, 50, 150, 100};
        // 绘制四个点：(50, 50) (50, 100) (100, 50) (100, 100)
        canvas.drawPoints(points, 2 /* 跳过两个数，即前两个 0 */,
                8 /* 一共绘制 8 个数（4 个点）*/, mPaint);
        mPaint.setStyle(Paint.Style.STROKE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            canvas.drawOval(400, 50, 700, 200, mPaint);
        }
        canvas.drawLine(200, 200, 800, 500, mPaint);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            canvas.drawRoundRect(100, 100, 500, 300, 50, 50, mPaint);
        }
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    private void DrawArc(Canvas canvas) {
        mPaint.setColor(Color.BLACK);
        mPaint.setStrokeWidth(5);
        mPaint.setStyle(Paint.Style.FILL); // 填充模式
        canvas.drawArc(200, 100, 800, 500, -110, 100, true, mPaint); // 绘制扇形
        canvas.drawArc(200, 100, 800, 500, 20, 140, false, mPaint); // 绘制弧形
        mPaint.setStyle(Paint.Style.STROKE); // 画线模式
        canvas.drawArc(200, 100, 800, 500, 180, 60, false, mPaint); // 绘制不封口的弧形
    }
}
