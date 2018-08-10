package com.thesanjoy.assignment1.assignment2;

import android.app.Activity;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends Activity implements SensorEventListener,View.OnClickListener {

    TextView tv1 = null,tv2=null,tv3=null,tv4=null;
    Button btn1,btn2,btn3,btn4;
    private SensorManager mSensorManager;
    Sensor s1,s2,s3,s4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv1 = (TextView) findViewById(R.id.textView1);
        tv2 = (TextView) findViewById(R.id.textView2);
        tv3 = (TextView) findViewById(R.id.textView3);
        tv4 = (TextView) findViewById(R.id.textView4);

        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);
        btn4 = (Button) findViewById(R.id.btn4);
        //tv1.setVisibility(View.GONE);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);

        mSensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        s1 = mSensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);

        tv1.setText("Light Intensity : "+s1.getPower()+" Ix");

        s2 = mSensorManager.getDefaultSensor(Sensor.TYPE_PRESSURE);
        tv2.setText("Environmental Pressure : "+s2.getPower()+" hPa");

        s3 = mSensorManager.getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE);
        tv3.setText("Temperature : "+s3.getPower()+" °C");

        s4 = mSensorManager.getDefaultSensor(Sensor.TYPE_RELATIVE_HUMIDITY);
        tv4.setText("Humidity : "+s4.getPower()+" %");
        /*List<Sensor> mList = mSensorManager.getSensorList(Sensor.TYPE_ALL);

        for (int i = 1; i < mList.size(); i++) {
            tv1.setVisibility(View.VISIBLE);
            tv1.append("\n" + mList.get(i).getName() + "\n" + mList.get(i).getVendor() + "\n" + mList.get(i).getVersion());
        }*/

    }



    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        Log.i("Sensor Event",sensorEvent.values[0]+"");
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }


    @Override
    public void onClick(View view) {
        Intent i = new Intent(getApplicationContext(), SecondActivity.class);

        switch(view.getId())
        {
            case R.id.btn1:
            {
                i.putExtra("sensor",1);
                //open login screen
                break;
            }
            case R.id.btn2:
            {
                i.putExtra("sensor",2);

                break;
            }
            case R.id.btn3:
            {
                i.putExtra("sensor",3);
                break;
            }
            case R.id.btn4: {
                i.putExtra("sensor",4);
                break;
            }
        }
        startActivity(i);
    }
}