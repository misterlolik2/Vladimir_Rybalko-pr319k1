package com.example.vladimir_rybalko_pr319k;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity3 extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
    }
    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()) {
            case R.id.imageView:
                intent = new Intent(MainActivity3.this, MainActivity1.class);
                startActivity(intent);
                break;
            case R.id.Zametka:
                intent = new Intent(MainActivity3.this, MainActivity.class);
                startActivity(intent);
                break;
        }
    }
}

