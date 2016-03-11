package com.example.raido.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Calculator calc = new Calculator();
    public static final String TAG = "MainActivity";
    private static final String STATE_ACTION = "last action";
    private static final String STATE_NUMBER = "last number on screen";
    private static final String STATE_OPERATOR = "last operator";
    private static final String STATE_X = "last x";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView screen = (TextView) findViewById(R.id.textnumbers);


        if (savedInstanceState != null) {
            calc.lastaction= savedInstanceState.getString(STATE_ACTION);
            calc.lastnumber=savedInstanceState.getString(STATE_NUMBER);
            calc.lastoperator = savedInstanceState.getString(STATE_OPERATOR);
            calc.setX(savedInstanceState.getFloat(STATE_X));
            screen.setText(calc.lastnumber);

        }
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState){
        if (BuildConfig.DEBUG) {
            Log.d(TAG, "onSaveInstanceState called");
        }
        savedInstanceState.putString(STATE_ACTION, calc.lastaction);
        savedInstanceState.putString(STATE_NUMBER, calc.lastnumber);
        Log.d(TAG, "onSaveInstanceState calc.lastnumber: " +calc.lastnumber);
        savedInstanceState.putString(STATE_OPERATOR, calc.lastoperator);
        savedInstanceState.putFloat(STATE_X, calc.getX());

        super.onSaveInstanceState(savedInstanceState);
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
        TextView screen = (TextView) findViewById(R.id.textnumbers);
        screen.setText(bvalue);


        if(calc.lastaction!="number")
        {
            calc.lastnumber="";
            calc.lastaction="number";
        }

        if
                (calc.lastnumber.toString().length() < 10 ){
            calc.lastnumber = calc.lastnumber + bvalue.toString();
            screen.setText(calc.lastnumber);
        }


    }

    public void OnOperate(View view){

        Button btn = (Button) view;
        String bvalue = btn.getText().toString();

        TextView screen = (TextView) findViewById(R.id.textnumbers);
        String nvalue = screen.getText().toString();

        switch(calc.lastaction) {
            case ("operate"):
                calc.lastoperator =bvalue;
                break;
            case ("equals"):
                calc.lastoperator =bvalue;
                break;

            case ("number"):
                if (calc.sumlast ==0) {
                    calc.setX(Float.parseFloat(calc.lastnumber));
                    //calc.lastnumber= "";
                    calc.sumlast = 1;
                    calc.lastoperator = bvalue;
                }else{
                    calc.setY(Float.parseFloat(calc.lastnumber));
                    calc.lastnumber=Float.toString(calc.calc(calc.lastoperator));

                    calc.setX(Float.parseFloat(calc.lastnumber));
                    screen.setText(calc.lastnumber);
                    calc.lastoperator =bvalue;
                }
                break;


        }

        calc.lastaction="operate";

    }

    public void OnEquals(View view) {

        TextView screen = (TextView) findViewById(R.id.textnumbers);

        switch(calc.lastaction) {
            case ("number"):
                calc.setY(Float.parseFloat(calc.lastnumber));


            calc.lastnumber = Float.toString(calc.calc(calc.lastoperator));

            calc.setX(Float.parseFloat(calc.lastnumber));
            screen.setText(calc.lastnumber);
            calc.lastaction="equals";
        }


    }

    public void OnClear(View view)
    {
        calc.sumlast=0;
        calc.lastnumber="0";
        calc.lastaction="clear";
        TextView screen = (TextView) findViewById(R.id.textnumbers);
        screen.setText(calc.lastnumber);
        calc.setX(Float.parseFloat("0"));
        calc.setY(Float.parseFloat("0"));


    }
}
