package com.example.raido.myapplication;

/**
 * Created by Raido on 9.03.2016.
 */
public class Calculator {

    private static float total;
    private static float x;
    private static float y;
    private String operator;
    public int abix;
    public int abiy;
    public int sumlast;
    public String lastoperator;
    public String lastnumber;
    public String lastaction;

    public Calculator()
    {
        this.x = 0;
        this.y = 0;
        this.total = 0;
        abix = 0;
        abiy = 0;
        sumlast = 0;
        lastoperator = "";
        lastnumber ="";
        lastaction="";
    }

    public void setX(Float x){
        this.x = x;
    }

    public void setY(Float y){
        this.y=y;
    }

    public Float getX(){
        return this.x=x;
    }

    public Float getY(){
        return this.y=y;
    }

   // public void setTotal(Float total){ this.total = total;}

    //public Float getTotal() {return this.total = total;}

    //public void setOperator(String operator) {this.operator = operator;}

    //public String getOperator() {return this.operator;}

    public float addition(float x, float y)
    {
        return x + y;
    }

    public float subtraction(float x, float y)
    {
        return x - y;
    }
    public float multiplication(float x, float y)
    {
        return x * y;
    }
    public float division(float x, float y)
    {
        return x / y;
    }

    public float calc(String ops){

        float x = this.x;
        float y = this.y;

        switch(ops.toString())
        {
            case("+"):
                this.total = addition(x, y);
                break;
            case ("-"):
                this.total = subtraction(x, y);
                break;
            case("x"):
                this.total = multiplication(x, y);
                break;
            case("/"):
                this.total = division(x, y);
                break;
        }

        return total;
    }
}
