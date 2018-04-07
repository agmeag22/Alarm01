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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setbutton=findViewById(R.id.setalarm);
        setbutton.setOnClickListener(new View.OnClickListener() {

            EditText hor = (EditText) findViewById(R.id.horas);
            EditText minu = (EditText) findViewById(R.id.minutos);
            Integer h = (Integer) Integer.parseInt(hor.getText().toString());
            Integer m = (Integer) Integer.parseInt(minu.getText().toString());
            @Override
            public void onClick(View v) {
                setalarms("Alarm has been set",h,m);
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
