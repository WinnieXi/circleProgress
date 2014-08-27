package com.example.roundprogressbar;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.util.AttributeSet;
import android.widget.ImageView;

public class DrawImageView extends ImageView {
    private final Paint paint;
    
    private final Context context;
    
    public DrawImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        // TODO Auto-generated constructor stub
        this.context = context;
        this.paint = new Paint();
        this.paint.setAntiAlias(true); //������� 
        this.paint.setStyle(Style.STROKE); //���ƿ���Բ�� ���ľ��� 
    }
    
    @Override
    protected void onDraw(Canvas canvas) {
        // TODO Auto-generated method stub
        int center = getWidth() / 2;
        int innerCircle = dip2px(context, 83); //��Բ�뾶
        int ringWidth = dip2px(context, 10); //Բ�����
        
        // ��һ�ַ�������Բ��
        //������Բ 
        this.paint.setARGB(255, 138, 43, 226);
        this.paint.setStrokeWidth(2);
        canvas.drawCircle(center, center, innerCircle, this.paint);
        
        //����Բ�� 
        this.paint.setARGB(255, 138, 43, 226);
        this.paint.setStrokeWidth(ringWidth);
        canvas.drawCircle(center, center, innerCircle + 1 + ringWidth / 2, this.paint);
        //������Բ 
        this.paint.setARGB(255, 138, 43, 226);
        this.paint.setStrokeWidth(2);
        canvas.drawCircle(center, center, innerCircle + ringWidth, this.paint);
        
        super.onDraw(canvas);
        
    }
    
    /* �����ֻ��ķֱ��ʴ� dp �ĵ�λ ת��Ϊ px(����) */
    public static int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int)(dpValue * scale + 0.5f);
    }
}