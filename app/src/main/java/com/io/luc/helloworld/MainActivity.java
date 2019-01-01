package com.io.luc.helloworld;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

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
//        int product, multiplicand=4, multiplier  =2;
//        product = multiplicand *multiplier;
//        Log.i("Mensaje", "The product of 4*2 is : " + product);
        TextView name = findViewById(R.id.nameText);
        TextView phone = findViewById(R.id.phoneText);
        Log.i("TAG", "Hello:  "+ name.getText().toString()+", your phone number is: "+phone.getText().toString() );



    }
}
