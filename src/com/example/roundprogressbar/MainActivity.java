package com.example.roundprogressbar;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.widget.Button;

import com.example.circlepregress.R;

public class MainActivity extends Activity {
    private RoundProgressBar mRoundProgressBar1, mRoundProgressBar2, mRoundProgressBar3, mRoundProgressBar4,
        mRoundProgressBar5;
    
    private int progress = 10;
    
    int i = 10;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cricle_progress);
        
        mRoundProgressBar1 = (RoundProgressBar)findViewById(R.id.roundProgressBar1);
        mRoundProgressBar2 = (RoundProgressBar)findViewById(R.id.roundProgressBar2);
        mRoundProgressBar3 = (RoundProgressBar)findViewById(R.id.roundProgressBar3);
        mRoundProgressBar4 = (RoundProgressBar)findViewById(R.id.roundProgressBar4);
        mRoundProgressBar5 = (RoundProgressBar)findViewById(R.id.roundProgressBar5);
        mRoundProgressBar3.setCricleColor(Color.GRAY);
        Button btn = (Button)findViewById(R.id.button1);
        //        
        
        mRoundProgressBar1.setProgress(progress);
        btn.setOnClickListener(new OnClickListener() {
            
            @Override
            public void onClick(View v) {
                progress = 100 - i;
                i += 3;
                System.out.println(progress);
                
                mRoundProgressBar1.setProgress(progress);
                mRoundProgressBar2.setProgress(progress);
                mRoundProgressBar5.setProgress(progress);
                mRoundProgressBar4.setProgress(progress);
                //                            mRoundProgressBar5.setProgress(progress);
                
            }
        });
        
        //        btn.setOnTouchListener(new OnTouchListener()
        //        {
        //            
        //            @Override
        //            public boolean onTouch(View arg0, MotionEvent arg1)
        //            {
        //                switch (arg1.getAction())
        //                {
        //                    case MotionEvent.ACTION_DOWN:
        //                        Log.e("ACTION_DOWN", "--------" + progress);
        //                        //按住事件发生后执行代码的区域
        //                        if (thread == null)
        //                        {
        //                            thread = new Mythread();
        //                            progress = 0;
        //                            new Thread(thread).start();
        //                        }
        //                        mRoundProgressBar3.setVisibility(View.VISIBLE);
        //                        break;
        //                    case MotionEvent.ACTION_MOVE:
        //                        //移动事件发生后执行代码的区域
        //                        break;
        //                    case MotionEvent.ACTION_UP:
        //                        //松开事件发生后执行代码的区域
        //                        Log.e("ACTION_UP", "--------" + progress);
        //                        if (progress < 100)
        //                        {
        //                            progress = 102;
        //                            thread.setSop();
        //                            thread = null;
        //                            mRoundProgressBar3.setProgress(0);
        //                        } else
        //                        {
        //                            thread.setSop();
        //                            thread = null;
        //                            mRoundProgressBar3.setVisibility(View.GONE);
        //                        }
        //                        break;
        //                    default:
        //                        break;
        //                }
        //                return false;
        //            }
        //        });
    }
    
    private Mythread thread;
    
    class Mythread implements Runnable {
        private boolean isStop = false;
        
        public void run() {
            while (!isStop) {
                while (progress <= 100) {
                    progress += 3;
                    Log.e("Mythread", "--------" + progress);
                    mRoundProgressBar3.setProgress(progress);
                    //                            mRoundProgressBar5.setProgress(progress);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            
        }
        
        public void setSop() {
            this.isStop = true;
        }
    }
    
}
