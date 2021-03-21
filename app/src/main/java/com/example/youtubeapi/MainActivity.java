package com.example.youtubeapi;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button sin=(Button) findViewById(R.id.single);
        Button men=(Button) findViewById(R.id.button2);

        sin.setOnClickListener(this);
        men.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent =null;
        switch(v.getId())
        {
            case R.id.single:
            {
                intent=new Intent(this,YoutubeActivity.class);
                break;
            }
            case R.id.button2:
            {
                intent=new Intent(this,StandaloneActivity.class);
                break;
            }
            default:

        }
        if(intent!=null)
        {
            startActivity(intent);
        }


    }
}