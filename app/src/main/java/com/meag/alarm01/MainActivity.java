package com.meag.alarm01;

import android.content.Intent;
import android.provider.AlarmClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
Button setbutton;
int h;
int m;
String value2;
String value;
EditText hor;
EditText minu;

@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        hor = (EditText) findViewById(R.id.horas);
        minu = (EditText) findViewById(R.id.minutos);


        setbutton=findViewById(R.id.setalarm);
        setbutton.setOnClickListener(new View.OnClickListener() {





            @Override
            public void onClick(View v) {
                value= hor.getText().toString();
                h=Integer.parseInt(value);
                value2= minu.getText().toString();
                m=Integer.parseInt(value2);
                if(h>=0 && h<=24 && m>=0 && m<=59){
                setalarms("Alarm has been set",h,m);}
            }
        });
    }
    public void setalarms(String mensaje, int hora, int minutos){
        Intent intent=new Intent(AlarmClock.ACTION_SET_ALARM)
                .putExtra(AlarmClock.EXTRA_MESSAGE,mensaje)
                .putExtra(AlarmClock.EXTRA_HOUR,hora)
                .putExtra(AlarmClock.EXTRA_MINUTES,minutos);
        if(intent.resolveActivity(getPackageManager())!= null){
            startActivity(intent);
        }

    }

}
