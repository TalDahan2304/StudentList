package com.example.studentlist;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.studentlist.model.Model;
import com.example.studentlist.model.Student;

import java.util.List;

public class StudentListRvActivity extends AppCompatActivity {

    List<Student> data;
    MyAdapter adapter;
    Button addstudent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_list_rv);

        // Intents:
        Intent intentnew = new Intent(this, NewStudentActivity.class);
        Intent intentdetails = new Intent(this, DetailsStudentActivity.class);

        addstudent = findViewById(R.id.studentlistrv_addstudent_btn);

       addstudent.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               startActivity(intentnew);
           }
       });


        data = Model.instance.getAllStudents();
        RecyclerView list = findViewById(R.id.studentlist_rv);
        list.setHasFixedSize(true);
        list.setLayoutManager(new LinearLayoutManager(this));

        adapter = new MyAdapter();
        list.setAdapter(adapter);

        adapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void OnItemClick(int position) {

//                Student student = data.get(position);
//                Log.d("TAG", "row was clicked" + position);
//                Log.d("TAG", "name of student:" + data.get(position).getName());
//                Log.d("TAG", "id of student:" + data.get(position).getId());

                intentdetails.putExtra("position", position);
                startActivity(intentdetails);

            }
        });
    }


    class MyViewHolder extends RecyclerView.ViewHolder{

        TextView nameTv;
        TextView idTv;
        CheckBox cb;

        public MyViewHolder(@NonNull View itemView, OnItemClickListener listener) {
            super(itemView);
            nameTv = itemView.findViewById(R.id.listrow_name_tv);
            idTv = itemView.findViewById(R.id.listrow_id_tv);
            cb = itemView.findViewById(R.id.listrow_cb);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = getAdapterPosition();
                    listener.OnItemClick(pos);
                }
            });
        }
    }

    interface OnItemClickListener{
        void OnItemClick(int position);
    }

    class MyAdapter extends RecyclerView.Adapter<MyViewHolder>{

        OnItemClickListener listener;
        public void setOnItemClickListener(OnItemClickListener listener){

            this.listener = listener;
        }


        @NonNull
        @Override
        public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view =  getLayoutInflater().inflate(R.layout.student_list_row, parent, false);
            MyViewHolder holder = new MyViewHolder(view,listener);
            return holder;
        }

        @Override
        public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

            Student student = data.get(position);
            holder.nameTv.setText(student.getName());
            holder.idTv.setText(student.getId());
            holder.cb.setChecked(student.isFlag());
        }

        @Override
        public int getItemCount() {
            return data.size();
        }
    }

    protected void onResume() {
        super.onResume();
        adapter.notifyDataSetChanged();
    }
}