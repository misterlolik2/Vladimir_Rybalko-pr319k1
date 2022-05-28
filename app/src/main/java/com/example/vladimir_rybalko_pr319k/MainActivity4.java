package com.example.vladimir_rybalko_pr319k;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity4 extends AppCompatActivity {

private TextView name, zamet, dat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        init();
        getIntentMain();
    }

    public void onClick123(View v){
        Intent intent;
        switch (v.getId()){
            case R.id.imageView4:
                intent = new Intent(MainActivity4.this, MainActivity3.class);
                startActivity(intent);
                break;
        }
    }

    private void init(){
        name = findViewById(R.id.nameZZ);
        dat = findViewById(R.id.Dataz);
        zamet = findViewById(R.id.Zamet);
    }

    private void getIntentMain(){
        Intent i = getIntent();
        if(i !=null)
        {
            name.setText(i.getStringExtra("summ_show"));
            dat.setText(i.getStringExtra("comm_show"));
            zamet.setText(i.getStringExtra("date_show"));
        }
    }
}