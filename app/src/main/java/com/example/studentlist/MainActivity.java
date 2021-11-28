package com.example.studentlist;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText nameET;
    EditText idET;
    CheckBox cb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Reference
        nameET=findViewById(R.id.editstudent_name_et);
        idET=findViewById(R.id.editstudent_id_ed);
        cb=findViewById(R.id.editstudent_cb);
        Button saveBtn=findViewById(R.id.editstudent_save_btn);
        Button cancelBtn=findViewById(R.id.newstudent_cancel_btn);

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                save();
            }
        });

    }

    private void save() {
        String name = nameET.getText().toString();
        String id =idET.getText().toString();
        boolean flag = cb.isChecked();

        Log.d("TAG", "saved name:" + name + "id:" + id + "flag" + flag);
    }

}