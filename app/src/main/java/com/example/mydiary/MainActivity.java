package com.example.mydiary;

import androidx.activity.result.ActivityResult;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.mydiary.adapters.dairyadapter;
import com.example.mydiary.database.roomdb;
import com.example.mydiary.modules.dairy;
import com.example.mydiary.modules.diareslistner;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    dairyadapter dairyadapter;
    List<dairy> dairy = new ArrayList<>();
    roomdb database;
    FloatingActionButton fab_add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycle);
        fab_add = findViewById(R.id.next);
        database = roomdb.getInstance(this);
        dairy = database.dao().getAll();


        updaterecycle(dairy);
        fab_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,dairy_activities.class);
                startActivityForResult(intent,101);

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==101)
        {
            {
                if(resultCode== Activity.RESULT_OK);
                dairy new_dairy=(dairy) data.getSerializableExtra("dairy");
                database.dao().insert(new_dairy);
                dairy.clear();
                dairy.addAll(database.dao().getAll());
                dairyadapter.notifyDataSetChanged();
            }
        }
    }

    private void updaterecycle(List<dairy> dairy) {
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(1, LinearLayoutManager.VERTICAL));
        dairyadapter = new dairyadapter(MainActivity.this, dairy, diareslistner);
        recyclerView.setAdapter(dairyadapter);
    }

    private final diareslistner diareslistner = new diareslistner() {
        @Override
        public void onclick(com.example.mydiary.modules.dairy dairy) {

        }

        @Override
        public void onlongclick(com.example.mydiary.modules.dairy dairy, CardView cardView) {

        }
    };
}


