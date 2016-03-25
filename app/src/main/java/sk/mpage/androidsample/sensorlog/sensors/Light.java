package sk.mpage.androidsample.sensorlog.sensors;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.util.Log;

/**
 * Created by maros on 30.9.2015.
 */
public class Light implements SensorEventListener {
    @Override
    public void onSensorChanged(SensorEvent event) {
        float lux = event.values[0];

        Log.d("senzory", "LIGHT:["+ event.accuracy+"] " + lux );
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        Log.d("senzory","LIGHT> "+ accuracy);
    }
}