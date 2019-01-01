package com.io.luc.helloworld;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;


/**
 * @author Lucio Nieto Bautista
 * CEO at Nieto Industries
 */

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void buttonClicked(View newView){
        ImageView myImage = findViewById(R.id.img);
        myImage.setImageResource(R.drawable.orangejuice);



    }
}
