package com.example.studentlist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.example.studentlist.model.Model;
import com.example.studentlist.model.Student;

import java.util.List;

public class DetailsStudentActivity extends AppCompatActivity {

    EditText name, id, phone, address;
    CheckBox cb;
    Button edit;
    List<Student> data;
    int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details2_student);

        name = findViewById(R.id.detailstudent_name2_ed);
        id = findViewById(R.id.detailstudent_id2_ed);
        phone = findViewById(R.id.detailstudent_phone2_ed);
        address = findViewById(R.id.detailstudent_address2_ed);
        cb = findViewById(R.id.detailstudent_cb2);
        edit = findViewById(R.id.detailstudent_edit2_btn);
        data = Model.instance.getAllStudents();

//        name.setEnabled(false);
//        id.setEnabled(false);
//        phone.setEnabled(false);
//        address.setEnabled(false);
//        cb.setEnabled(false);

        Intent intentedit = new Intent(this, EditStudentActivity.class);

        Bundle extras = getIntent().getExtras();
        if(extras != null){

            position = extras.getInt("position");
            //Student student = data.get(position);
            name.setText(Model.instance.getStudent(position).getName());
            id.setText(Model.instance.getStudent(position).getId());
            phone.setText(Model.instance.getStudent(position).getPhone());
            address.setText(Model.instance.getStudent(position).getAddress());
            cb.setChecked(Model.instance.getStudent(position).isFlag());
        }

        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                intentedit.putExtra("position", position);
                startActivity(intentedit);
            }
        });

    }
}