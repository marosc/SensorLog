package sk.mpage.androidsample.sensorlog.sensors;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.util.Log;

/**
 * Created by maros on 30.9.2015.
 */
public class Proximity implements SensorEventListener {
    @Override
    public void onSensorChanged(SensorEvent event) {
        float distance = event.values[0];

        Log.d("senzory", "PROXIMITY:[" + event.accuracy + "] " + distance);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        Log.d("senzory","PROXIMITY> "+ accuracy);
    }
}