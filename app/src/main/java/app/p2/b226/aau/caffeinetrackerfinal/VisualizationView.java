package app.p2.b226.aau.caffeinetrackerfinal;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Lynge on 04/05/2017.
 */

public class VisualizationView extends View {

    Paint PaintView = new Paint();
    public VisualizationView(Context context) {
        super(context);
        init(null,0);
    }

    public VisualizationView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs,0);
    }

    public VisualizationView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs,defStyleAttr);
    }

    private void init(AttributeSet attrs, int defStyleAttr){
        PaintView.setColor(Color.BLACK);

    }
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawLine(50,50,50,500,PaintView);

    }

}
