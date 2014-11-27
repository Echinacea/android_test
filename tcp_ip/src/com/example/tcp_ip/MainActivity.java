package com.example.tcp_ip;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		//======================================
		
		
		InetAddress serverIp;
		 
        // ���ճs��Server
        try {
            // �]�wIP
            serverIp = InetAddress.getByName("140.125.33.210");
 
            // �]�wport
            int serverPort=1234;
 
            // ��lsocket�s��
            Socket clientSocket=new Socket(serverIp,serverPort);
 
            // �����Ӧ�Server���T�� 
            
            while(true)
            {
            //BufferedReader  br=new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            BufferedWriter bw=  new BufferedWriter( new OutputStreamWriter(clientSocket.getOutputStream()));
            bw.write("Hello! This is sever msg.\n");
            bw.flush();
            
            }
            // ��ܦ��쪺�T
 
            // �����s�u
            //clientSocket.close(); 
        } catch (IOException e) {
            // �X������ܿ��~�T��
            
        }
        
		
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
}
