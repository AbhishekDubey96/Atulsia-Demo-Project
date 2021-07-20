package com.example.atulsiademo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SlideActivity extends AppCompatActivity {
   public static ViewPager Pager;
    SlideviewpagerAdapter adapter;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slide);


        Pager=(ViewPager)findViewById(R.id.viewADemo);

        adapter=new SlideviewpagerAdapter(this);
        Pager.setAdapter(adapter);


    }
}