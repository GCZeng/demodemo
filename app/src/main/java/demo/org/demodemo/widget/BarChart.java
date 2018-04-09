package demo.org.demodemo.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import java.util.List;

import demo.org.demodemo.util.DisplayUtiil;

/**
 * Author: zgc
 * Time: 2018/4/9 下午10:52
 * Description:
 **/
public class BarChart extends View {

    private Paint mPaint;//画笔

    private int sHeight = DisplayUtiil.getScreenHeight();//屏幕高度
    private int sWidth = DisplayUtiil.getScreenWidth();//屏幕宽度

    private int height = 0;
    private int width = 0;

    private List<Integer> dataList = null;

    private final int barCharWidth = 60;//条形图宽度
    private final int barCharSplit = 30;//条形图间隔
    private final int leftPadding = 60;//left padding
    private final int topPadding = 50;//top padding

    public BarChart(Context context) {
        super(context);
    }

    public BarChart(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public void init(List<Integer> dataList) {
        this.dataList = dataList;

        mPaint = new Paint();
        mPaint.setColor(Color.RED);
        mPaint.setTextSize(25);

        height = sHeight * 3 / 5;
        width = sWidth - 100;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        if (dataList == null) {
            return;
        }

        //X轴
        canvas.drawLine(leftPadding, height + topPadding, leftPadding, topPadding, mPaint);
        //Y轴
        canvas.drawLine(leftPadding, height + topPadding, width + leftPadding, height + topPadding, mPaint);

        //Y轴坐标
        for (int i = 1; i * 100 < height; i++) {
            int y = i * 100;
            canvas.drawLine(leftPadding, height + topPadding - y, leftPadding + 10, height + topPadding - y, mPaint);
            Paint.FontMetrics fm = mPaint.getFontMetrics();
            canvas.drawText(String.valueOf(y), leftPadding - mPaint.measureText(String.valueOf(y)) - 10, (float) ((height + topPadding - y) + Math.ceil(fm.descent - fm.ascent) / 2), mPaint);
        }

        int tempX = barCharSplit + leftPadding;

        //画条形
        for (int i = 0; i < dataList.size(); i++) {
            Rect rect = new Rect();

            rect.left = tempX;
            rect.top = topPadding + height - dataList.get(i) * 10;
            rect.right = tempX + barCharWidth;
            rect.bottom = topPadding + height;

            tempX += barCharWidth + barCharSplit;

            //条形图
            canvas.drawRect(rect, mPaint);

            //文字
            String text = "NO." + (i + 1);
            float textWidth = mPaint.measureText(text);
            canvas.drawText(text, (rect.left + rect.right) / 2 - textWidth / 2, topPadding + height + 50, mPaint);

            String data = dataList.get(i).toString();
            float dataWidth = mPaint.measureText(data);
            canvas.drawText(data, (rect.left + rect.right) / 2 - dataWidth / 2, topPadding + height - dataList.get(i) * 10 - 10, mPaint);
        }

    }
}
