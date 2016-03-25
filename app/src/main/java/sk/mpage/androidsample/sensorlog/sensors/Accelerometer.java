package sk.mpage.androidsample.sensorlog.sensors;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.util.Log;


public class Accelerometer implements SensorEventListener {
    @Override
    public void onSensorChanged(SensorEvent event) {
        int x = (int)event.values[0];
        int y = (int)event.values[1];
        int z = (int)event.values[2];

        Log.d("senzory","ACC:["+ event.accuracy+"]  "+x+", "+ y+", "+z);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        Log.d("senzory","ACC> "+ accuracy);
    }
}
