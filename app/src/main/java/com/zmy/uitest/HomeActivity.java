package com.zmy.uitest;

import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {

    private HomeActivity mActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        mActivity = this;

        Toolbar toolbar = findViewById(R.id.toolbar);

//        setSupportActionBar(toolbar);

        final DrawerLayout drawerLayout = findViewById(R.id.drawr_layout);

        final LinearLayout drawerView = findViewById(R.id.drawerContent);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mActivity,"test",Toast.LENGTH_SHORT).show();
                drawerLayout.openDrawer(drawerView);
            }
        });

    }
}
