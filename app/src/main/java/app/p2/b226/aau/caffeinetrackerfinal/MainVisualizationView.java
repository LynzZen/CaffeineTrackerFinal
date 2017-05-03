package app.p2.b226.aau.caffeinetrackerfinal;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Lynge on 03/05/2017.
 */

public class MainVisualizationView extends View {
    private Paint paintView = new Paint();
    private Paint paintView2 = new Paint();

    RectF rectF;
    static int CaffeineIntaken;
    static float CupDegrees;




    public MainVisualizationView(Context context) {
        super(context);
        init(null,0);
    }

    public MainVisualizationView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs,0);
    }

    public MainVisualizationView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs,defStyleAttr);
    }
    private void init(AttributeSet attrs, int defStyleAttr){
        paintView.setStyle(Paint.Style.STROKE);
        paintView.setStrokeWidth(10);
        paintView.setAntiAlias(true);

        paintView2.setColor(Color.RED);
        paintView2.setStyle(Paint.Style.STROKE);
        paintView2.setStrokeWidth(20);
        paintView2.setAntiAlias(true);
        rectF = new RectF();

    }
    //Draws on the
    @Override
    public void onDraw(Canvas canvas){
        super.onDraw(canvas);
        //This caluculates the factor between milligrams and degress
        //The 600 here should be the goal at some point to make it work right.
        double Factor = (double)203/(double)600;
        CupDegrees = (float)(Factor*CaffeineIntaken);

        //Draws the circles and arc
        paintView.setColor(Color.BLACK);
        rectF.set(getWidth()/2-270,350-270,getWidth()/2+270,350+270);

        canvas.drawCircle(getWidth()/2,350,270,paintView);
        canvas.drawArc (rectF, 157, CupDegrees, false, paintView2);
        canvas.drawCircle(getWidth()/2,570,270,paintView);
        canvas.drawCircle(getWidth()/2+270,350,10,paintView2);
        invalidate();

    }
}
