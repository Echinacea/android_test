package com.example.test11;

import android.support.v7.app.ActionBarActivity;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.app.Activity;

public class MainActivity extends Activity implements SensorEventListener{
	private SensorManager aSensorManager;
	private Sensor aSensor;
	private float gravity[] = new float[3];
	String tagx="x:";
	String tagy="y:";
	String tagz="z:";
	TextView x_label;
	TextView y_label;
	TextView z_label;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		x_label=(TextView)findViewById(R.id.textView2);
		y_label=(TextView)findViewById(R.id.textView3); 
		z_label=(TextView)findViewById(R.id.textView4); 
		
		
		
		
		aSensorManager=(SensorManager) getSystemService(SENSOR_SERVICE);
		aSensor = aSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
		aSensorManager.registerListener(this, aSensor, aSensorManager.SENSOR_DELAY_NORMAL);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onAccuracyChanged(Sensor sensor, int accuracy) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onSensorChanged(SensorEvent event) {
		// TODO Auto-generated method stub
		Log.d(tagx, "x:"+Float.toString(event.values[0])+"y:"+Float.toString(event.values[1])+"z:"+Float.toString(event.values[2]));
		x_label.setText("x:"+Float.toString(event.values[0]));
		y_label.setText("y:"+Float.toString(event.values[1]));
		z_label.setText("z:"+Float.toString(event.values[2]));
		
		if(event.values[2]<0)
		{
			
		z_label.setTextColor(0xffffff00);
		}else
		{
			z_label.setTextColor(0xffff00ff);
		}
		
	}
}
