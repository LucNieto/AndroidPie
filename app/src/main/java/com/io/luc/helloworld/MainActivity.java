package com.io.luc.helloworld;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

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
        int product, multiplicand=4, multiplier  =2;
        product = multiplicand *multiplier;

        Log.i("Mensaje", "The product of 4*2 is : " + product);
    }
}
