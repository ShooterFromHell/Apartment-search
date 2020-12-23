package com.vladimir.myapplication;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.vladimir.myapplication.ui.main.MainFragment;
import com.vladimir.myapplication.ui.main.Result;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        MainFragment fragment1 = new MainFragment();
        Result fragment2 = new Result();

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.frame1, fragment1)
                .replace(R.id.frame2, fragment2)
                .commit();

    }
}