package sk.mpage.androidsample.sensorlog.sensors;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.util.Log;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by maros on 30.9.2015.
 */
public class LinearAcceleration implements SensorEventListener {

    public TextView textView;
    public long start = 0;
    public long interval= 2; // 10 seconds
    public int[] xyz = null;
    public boolean move=false;


    @Override
    public void onSensorChanged(SensorEvent event) {
        int x = (int)event.values[0];
        int y = (int)event.values[1];
        int z = (int)event.values[2];

        long seconds =  event.timestamp/1000000000;

        Log.d("testik",seconds+"-"+start+" = "+ (seconds-start));
        if (xyz==null || seconds-start > interval ){
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(event.timestamp/1000000);
            SimpleDateFormat df = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");

            textView.setText(df.format(calendar.getTime())+ " "+ (move ? "move" : "no move" )+ "\n" + textView.getText());
            move=false;
            start=seconds;
            xyz= new int[]{x,y,z};
        }else{
            if (x!=xyz[0] || y!=xyz[1] || z!=xyz[2]){
                move=true;
            }
        }

        xyz[0]=x;
        xyz[1]=y;
        xyz[2]=z;

        //Log.d("senzory", "LINEAR:["+ (event.timestamp-start/1000000000)+ "] " + x + ", " + y + ", " + z);

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        Log.d("senzory","LINEAR> "+ accuracy);
    }
}
