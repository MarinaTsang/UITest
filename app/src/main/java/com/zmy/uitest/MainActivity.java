package com.zmy.uitest;

import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private MainActivity mActivity;

    //test handle
    private Handler handler1;
    private Handler handler2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_shouxie);

        mActivity = this;

        Toolbar mToolbarTb = findViewById(R.id.toolbar);
        setSupportActionBar(mToolbarTb);

        mToolbarTb.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mActivity,"back",Toast.LENGTH_SHORT).show();
            }
        });


        findViewById(R.id.btn1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(mActivity,CoordinateActivity.class));
            }
        });

        findViewById(R.id.btn2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(mActivity,HomeActivity.class));
            }
        });

        //test handle
        handler1 = new Handler();
        //子线程创建Handler对象
//
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                handler2 = new Handler();
//            }
//        }).start();

        //子线程向主线程发送消息

        new Thread(new Runnable() {
            @Override
            public void run() {
                Message message = new Message();
                message.obj = "发送消息";
                handler1.sendMessage(message);

            }
        }).start();


        //消息机制 ----容易造成内存泄漏
        class LooperThread extends Thread{
            private Handler handler;

            public void run(){
                Looper.prepare();
                handler = new Handler(){


                    @Override
                    public void handleMessage(Message msg) {


                    }
                };

                Looper.loop();

            }


        }


    }

}
