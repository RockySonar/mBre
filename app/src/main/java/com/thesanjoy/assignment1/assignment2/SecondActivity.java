package com.thesanjoy.assignment1.assignment2;

import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity  implements SensorEventListener {

    TextView textView;
    Intent intent;
    int btn;
    private SensorManager mSensorManager;
    Sensor s1;
    Button btn_back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        btn_back = (Button) findViewById(R.id.btn_back);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        mSensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);

        s1 = mSensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
        textView = (TextView) findViewById(R.id.text2);
        //textView.setText("Hiii");
        intent = getIntent();
        btn = intent.getIntExtra("sensor",0);
        switch (btn){
            case 1:
                s1 = mSensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
                textView.setText("Light Intensity : "+s1.getPower()+" Ix");
                break;
            case 2:
                s1 = mSensorManager.getDefaultSensor(Sensor.TYPE_PRESSURE);
                textView.setText("Environmental Pressure : "+s1.getPower()+" hPa");
                break;
            case 3:
                s1 = mSensorManager.getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE);
                textView.setText("Temperature : "+s1.getPower()+" °C");
                break;
            case 4:
                s1 = mSensorManager.getDefaultSensor(Sensor.TYPE_RELATIVE_HUMIDITY);
                textView.setText("Humidity : "+s1.getPower()+" %");
                break;
                default:
                    textView.setText("Please go back and try again.");
        }

    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        /*switch (btn){
            case 1:

                textView.setText("Light Intensity : "+sensorEvent.values[0]+" Ix");
                break;
            case 2:
                textView.setText("Environmental Pressure : "+sensorEvent.values[0]+" hPa");
                break;
            case 3:
                textView.setText("Temperature : "+sensorEvent.values[0]+" °C");
                break;
            case 4:
                textView.setText("Humidity : "+sensorEvent.values[0]+" %");
                break;
            default:
                textView.setText("Please go back and try again.");
        }*/
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }


}
