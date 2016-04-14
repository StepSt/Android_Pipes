package com.example.admin.pipes;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Main extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Typeface myTypeface = Typeface.createFromAsset(getAssets(), "Roboto-Regular.ttf");
        TextView textView = (TextView) findViewById(R.id.textView);
        textView.setTypeface(myTypeface);
    }
}
