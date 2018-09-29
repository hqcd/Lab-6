//Quinten Whitaker
//Lab 6 - Random Character Generator Service
//Created on 9-28-18
//CS 4322
package com.example.quinten.lab6;

import android.content.Intent;
import android.content.ServiceConnection;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn1;
    Button btn2;
    Intent serviceIntent;
    private GenerateCharacterService myService;
    private ServiceConnection myServiceConnection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1 = (Button)findViewById(R.id.startButton);
        btn2 = (Button)findViewById(R.id.stopButton);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                serviceIntent = new Intent(getApplicationContext(), GenerateCharacterService.class);
                startService(serviceIntent);
                Toast.makeText(getApplicationContext(), "Service Started", Toast.LENGTH_SHORT).show();
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                serviceIntent = new Intent(getApplicationContext(), GenerateCharacterService.class);
                stopService(serviceIntent);
                Toast.makeText(getApplicationContext(), "Service Stopped", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
