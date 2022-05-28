package com.example.vladimir_rybalko_pr319k;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity3 extends AppCompatActivity implements View.OnClickListener {

    private ListView listView;
    private ArrayAdapter<String> adapter;
    private List<String> listData;
    private DatabaseReference mDataBase;
    private List<Zametki> listTemp;
    private String zamettki = "Zametki";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        init();
        getDataFromDB();
        setOnClickItem();
    }

    private void init()
    {
        listView = findViewById(R.id.fufik);
        listData = new ArrayList<>();
        listTemp = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,listData);
        listView.setAdapter(adapter);
        mDataBase = FirebaseDatabase.getInstance().getReference("Zametki");
    }

    public void getDataFromDB()
    {
        ValueEventListener vlistener = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot)
            {
                if(listData.size() > 0) listData.clear();
                if(listTemp.size() > 0) listTemp.clear();
                for(DataSnapshot ds : snapshot.getChildren())
                {
                    Zametki zam = ds.getValue(Zametki.class);
                    assert zam != null;
                    listData.add(zam.NameZ);
                    listTemp.add(zam);
                }
                adapter.notifyDataSetChanged();
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        };
        mDataBase.addValueEventListener(vlistener);
    }

    private void setOnClickItem()
    {
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Zametki zam = listTemp.get(position);
                Intent i = new Intent(MainActivity3.this, MainActivity4.class);
                i.putExtra("summ_show",zam.data);
                i.putExtra("comm_show",zam.zametka);
                i.putExtra("date_show",zam.NameZ);
                startActivity(i);

            }
        });
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

