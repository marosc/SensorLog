package sk.mpage.androidsample.sensorlog;

import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.List;

import sk.mpage.androidsample.sensorlog.sensors.Accelerometer;
import sk.mpage.androidsample.sensorlog.sensors.Light;
import sk.mpage.androidsample.sensorlog.sensors.LinearAcceleration;
import sk.mpage.androidsample.sensorlog.sensors.Proximity;

public class MainActivity extends AppCompatActivity {
    private TextView sensorTextView;
    private SensorManager mSensorManager;

    private Sensor mAccelerometer;
    private Accelerometer acc;

    private Sensor mLight;
    private Light light;

    private Sensor mLinearAcceleration;
    private LinearAcceleration linearAcceleration;

    private Sensor mProximity;
    private Proximity proximity;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sensorTextView = (TextView) findViewById(R.id.sensor_text);
        mSensorManager = (SensorManager)getSystemService(SENSOR_SERVICE);

//        List<Sensor> deviceSensors = mSensorManager.getSensorList(Sensor.TYPE_ALL);
//        String text = "";
//        for (Sensor s : deviceSensors){
//
//            text+=s.getName()+" -- "+ s.getPower() +"mA\n";
//        }
//        sensorTextView.setText(text);
//
//
//        mAccelerometer = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
//        acc = new Accelerometer();
//
//        mLight = mSensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
//        light = new Light();

        mLinearAcceleration = mSensorManager.getDefaultSensor(Sensor.TYPE_LINEAR_ACCELERATION);
        linearAcceleration = new LinearAcceleration();
        linearAcceleration.textView=sensorTextView;

//        mProximity = mSensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);
//        proximity = new Proximity();
    }

    protected void onResume() {
        super.onResume();
//        mSensorManager.registerListener(acc, mAccelerometer, SensorManager.SENSOR_DELAY_NORMAL);
//        mSensorManager.registerListener(light, mLight, SensorManager.SENSOR_DELAY_NORMAL);
        mSensorManager.registerListener(linearAcceleration,mLinearAcceleration, SensorManager.SENSOR_DELAY_NORMAL);
//        mSensorManager.registerListener(proximity,mProximity,SensorManager.SENSOR_DELAY_NORMAL);
    }

    protected void onPause() {
        super.onPause();
//        mSensorManager.unregisterListener(acc);
//        mSensorManager.unregisterListener(light);
        mSensorManager.unregisterListener(linearAcceleration);
//        mSensorManager.unregisterListener(proximity);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
