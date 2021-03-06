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
    static int YCenter = 500;
    RectF rectF;
    static int CaffeineIntaken;
    static int CaffeineGoal;
    static float CupDegrees;

    //FOR TEST!!!
    static int[] Tracks;





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
        Tracks = new int[4];
        Tracks[0] = 100;
        Tracks[1] = 100;
        Tracks[2] = 150;
        Tracks[3] = 100;


    }
    //Draws on the
    @Override
    public void onDraw(Canvas canvas){
        super.onDraw(canvas);
        //This caluculates the factor between milligrams and degress according to the goal

        double Factor = (double)203/(double)CaffeineGoal;
        CupDegrees = (float)(Factor*CaffeineIntaken);



        //Draws the circles and arc
        paintView.setColor(Color.BLACK);
        rectF.set(getWidth()/2-270,YCenter-270,getWidth()/2+270,YCenter+270);

        //First big circle
        canvas.drawCircle(getWidth()/2,YCenter,270,paintView);

        canvas.drawArc (rectF, 157, CupDegrees, false, paintView2);

        //Second big circle
        canvas.drawCircle(getWidth()/2,YCenter+270,270,paintView);

        //Small circle at the end of the arc
        canvas.drawCircle(getWidth()/2+270,YCenter,10,paintView2);

        paintView2.setColor(Color.BLACK);


        //Makes a dot for each tracking
        //Should have an array with all the trackings now it's running on a premade array!
        int Last = 0;

        for(int k:Tracks){
            CupDegrees = (float)(Factor*(k+Last));
            float x =(float)((getWidth()/2)+270*(Math.cos(Math.toRadians(CupDegrees+157))));
            float y =(float)(YCenter+270*(Math.sin(Math.toRadians(CupDegrees+157))));
            canvas.drawCircle(x,y,10,paintView2);
            Last+=k;
        }

        invalidate();

    }
}
