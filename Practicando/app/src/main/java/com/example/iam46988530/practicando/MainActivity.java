package com.example.iam46988530.practicando;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String Tag = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(Tag,"onCreate");
        Toast.makeText(this,"onCreate",Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(Tag,"onStart");
        Toast.makeText(this,"onStart",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(Tag,"onStop");
        Toast.makeText(this,"onStop",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(Tag,"onDestroy");
        Toast.makeText(this,"onDestroy",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(Tag,"onPause");
        Toast.makeText(this,"onPause",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(Tag,"onResume");
        Toast.makeText(this,"onResume",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(Tag,"onRestart");
        Toast.makeText(this,"onRestart",Toast.LENGTH_SHORT).show();
    }
}
