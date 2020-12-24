package com.vladimir.myapplication.Activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.vladimir.myapplication.R;
import com.vladimir.myapplication.Fragment.MainFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        MainFragment fragment1 = new MainFragment();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.frame1, fragment1)
                .commit();

    }
}