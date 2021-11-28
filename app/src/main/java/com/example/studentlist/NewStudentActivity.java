package com.example.studentlist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.example.studentlist.model.Model;
import com.example.studentlist.model.Student;

public class NewStudentActivity extends AppCompatActivity {

    EditText name, id, phone, address;
    CheckBox cb;
    Button save, cancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_student);

        name = findViewById(R.id.editstudent_name_et);
        id = findViewById(R.id.editstudent_id_ed);
        phone = findViewById(R.id.editstudent_phone_ed);
        address = findViewById(R.id.editstudent_address_ed);
        cb = findViewById(R.id.editstudent_cb);
        save = findViewById(R.id.editstudent_save_btn);
        cancel =findViewById(R.id.newstudent_cancel_btn);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Student student = new Student(name.getText().toString(), id.getText().toString(), cb.isChecked(), phone.getText().toString(), address.getText().toString());
                if(!student.getName().isEmpty() && !student.getId().isEmpty() && !student.getPhone().isEmpty() && !student.getAddress().isEmpty()){

                    Model.instance.addStudent(student);
                    finish();
                }
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}