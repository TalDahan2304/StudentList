package com.example.studentlist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.example.studentlist.model.Model;
import com.example.studentlist.model.Student;

import java.util.List;

public class EditStudentActivity extends AppCompatActivity {

    EditText name, id, phone, address;
    CheckBox cb;
    Button save, delete, cancel;
    List<Student> data;
    int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit2_student);

        name = findViewById(R.id.editstudent_name_ed);
        id = findViewById(R.id.editstudent_id_ed);
        phone = findViewById(R.id.editstudent_phone_ed);
        address = findViewById(R.id.editstudent_address_ed);
        cb = findViewById(R.id.editstudent_cb);
        save = findViewById(R.id.editstudent_save2_btn);
        delete = findViewById(R.id.editstudent_detele2_btn);
        cancel = findViewById(R.id.editstudent_cancel2_btn);

        data = Model.instance.getAllStudents();

        Bundle extras = getIntent().getExtras();
        if(extras != null){

            position = extras.getInt("position");
        }
        name.setText(Model.instance.getStudent(position).getName());
        id.setText(Model.instance.getStudent(position).getId());
        phone.setText(Model.instance.getStudent(position).getPhone());
        address.setText(Model.instance.getStudent(position).getAddress());
        cb.setChecked(Model.instance.getStudent(position).isFlag());


        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Model.instance.getStudent(position).setName(name.getText().toString());
                Model.instance.getStudent(position).setId(id.getText().toString());
                Model.instance.getStudent(position).setPhone(phone.getText().toString());
                Model.instance.getStudent(position).setAddress(address.getText().toString());
                Model.instance.getStudent(position).setFlag(cb.isChecked());

                finish();

            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Model.instance.deleteStudent(position);
                finish();
            }
        });





    }
}