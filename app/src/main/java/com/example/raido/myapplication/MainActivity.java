package com.example.raido.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Calculator calc = new Calculator();
    public static final String TAG = "MainActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }





    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.


        return super.onOptionsItemSelected(item);
    }

    public void OnNumber(View view) {
        Button btn = (Button) view;
        String bvalue = btn.getText().toString();
        //calc.sumlast = 0;


        if (BuildConfig.DEBUG) {
            Log.d(TAG, "button pressed: " + bvalue);
            Log.d(TAG, "initial x value: " + calc.getX());
        }

        TextView screen = (TextView) findViewById(R.id.textnumbers);


        //if (screen.getText()=="0")
        if (calc.abix == 0)
        {

            screen.setText(bvalue);

            Log.d(TAG, "x väärtus:" + calc.arvx.toString());
            Log.d(TAG, "Teksti max pikkus:" + screen.length());
        if
            (calc.arvx.toString().length() < 10){
            calc.arvx = calc.arvx + bvalue.toString();
        }
            screen.setText(calc.arvx.toString());

        }else {
            if (calc.abiy == 0)
            {

                if
                        (calc.arvy.toString().length() < 10){
                    calc.arvy = calc.arvy + bvalue.toString();
                }
                screen.setText(calc.arvy.toString());
                calc.abix =1;

                Log.d(TAG, "y väärtus:" + calc.arvy.toString());
            }
            //screen.setText(screen.getText() + bvalue);

        }

    }

    public void OnOperate(View view){
        Button btn = (Button) view;
        String bvalue = btn.getText().toString();

        TextView screen = (TextView) findViewById(R.id.textnumbers);
        String nvalue = screen.getText().toString();

        if (calc.sumlast ==0) {
            calc.setX(Float.parseFloat(calc.arvx));
            calc.abix = 1;
            calc.sumlast = 1;
            calc.setTotal(calc.getX());
            calc.lastoperand = bvalue;
        }else if(calc.abix ==1) {

            calc.setY(Float.parseFloat(calc.arvy));
            calc.abiy = 0;
            calc.arvy="";
            calc.sumlast = 1;
            calc.calc(calc.lastoperand);
            calc.abix=1;
            Log.d(TAG, "set X: " + calc.getX().toString());
            Log.d(TAG, "Set Y: " + calc.getY().toString());
            Log.d(TAG, "Set text: " + bvalue.toString());
            screen.setText(Float.toString(calc.getTotal()));

            calc.setX(calc.getTotal());
            calc.lastoperand = bvalue;
    }else{
            calc.lastoperand = bvalue;
        }

    }

    public void OnEquals(View view) {

        TextView screen = (TextView) findViewById(R.id.textnumbers);
        String nvalue = screen.getText().toString();
if(calc.abix==1) {
    calc.setY(Float.parseFloat(calc.arvy));

    Log.d(TAG, "Equal x: " + calc.getX().toString());
    Log.d(TAG, "Equal y: " + calc.getY().toString());

    calc.setTotal(calc.calc(calc.lastoperand));

    //screen.setText("Tere");
    screen.setText(Float.toString(calc.getTotal()));

    calc.setX(calc.getTotal());
    calc.abix = 2;
    calc.arvy = "";
    //float total = calc.calc(calc.getOperator());

}

    }

    public void OnClear(View view)
    {
        calc.abix=0;
        //calc.setY(Float.parseFloat("0"));
        //calc.setX(Float.parseFloat("117"));

        calc.arvx = "";
        calc.arvy = "";
        calc.abiy = 0;
        calc.sumlast = 0;
        //calc.setX(Float.parseFloat("0"));
        calc.setTotal(Float.parseFloat("0"));
        TextView screen = (TextView) findViewById(R.id.textnumbers);
        screen.setText("0");
    }
}
