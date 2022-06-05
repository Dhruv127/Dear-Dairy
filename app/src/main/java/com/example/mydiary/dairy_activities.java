package com.example.mydiary;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.mydiary.modules.dairy;

import java.text.SimpleDateFormat;
import java.util.Date;

public class dairy_activities extends AppCompatActivity {
    EditText entry;
    ImageView icon_save;
    dairy dairy;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dairy_activities);
        icon_save=findViewById(R.id.icon_save);
//       diary_title=findViewById(R.id.diary_title);
        entry=findViewById(R.id.entry);
        icon_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                String title =diary_title.getText().toString();
                SimpleDateFormat formatter=new SimpleDateFormat( "EEE,MMM d, yyy");
                String description=entry.getText().toString();

                if(description.isEmpty())
                {
                    Toast.makeText(dairy_activities.this,"add your today diary",Toast.LENGTH_SHORT).show();
                    return;
                }

                Date date=new Date();
                dairy=new dairy();
//           dairy.setTitle(title);
                dairy.setDate(formatter.format(date));
                dairy.setDairy(description);

                Intent intent=new Intent();
                intent.putExtra("dairy",dairy);
                setResult(Activity.RESULT_OK,intent);
                finish();
            }
        });
    }
}