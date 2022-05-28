package com.example.vladimir_rybalko_pr319k;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText pddata, pdzametka, pdnameZ;
    private DatabaseReference mDataBase;
    private String zamettki = "Zametki";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();


    }


    public void init() {
        pddata = findViewById(R.id.pddata);
        pdzametka = findViewById(R.id.pdzametka);
        pdnameZ = findViewById(R.id.NameZ);
        mDataBase = FirebaseDatabase.getInstance().getReference(zamettki);
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()) {
            case R.id.button22:
                intent = new Intent(MainActivity.this, MainActivity3.class);
                startActivity(intent);
        }
    }

    public void onClickSave(View View) {
        String id = mDataBase.getKey();
        String data = pddata.getText().toString();
        String zametka = pdzametka.getText().toString();
        String nameZ = pdnameZ.getText().toString();
        Zametki newdoxod = new Zametki(id, data, zametka, nameZ);
        if (!TextUtils.isEmpty(zametka)) {
            mDataBase.push().setValue(newdoxod);
            Toast.makeText(this, "Вы добавили заметку", Toast.LENGTH_SHORT).show();
            Intent i = new Intent(MainActivity.this, MainActivity3.class);
            startActivity(i);
        }
        else
        {
            Toast.makeText(this, "Заполните пустое поле", Toast.LENGTH_SHORT).show();
        }
    }
}