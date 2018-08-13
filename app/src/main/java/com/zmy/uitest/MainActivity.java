package com.zmy.uitest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private MainActivity mActivity;

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
    }

}
