package com.example.vladimir_rybalko_pr319k;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }

    public void onClick123(View v){
        Intent intent;
        switch (v.getId()){
            case R.id.imageView111:
                intent = new Intent(MainActivity2.this, MainActivity1.class);
                startActivity(intent);
                break;
        }
    }
}