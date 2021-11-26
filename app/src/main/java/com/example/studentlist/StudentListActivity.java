package com.example.studentlist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;

public class StudentListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_list);

        MyAdapter adapter = new MyAdapter();
        ListView listv = findViewById(R.id.studentlist_listv);
        listv.setAdapter(adapter);
    }

    class MyAdapter extends BaseAdapter{


        @Override
        public int getCount() {
            return 20;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            if (convertView == null) {
                convertView = getLayoutInflater().inflate(R.layout.student_list_row, null);
            }
            TextView nameTv = convertView.findViewById(R.id.listrow_name_tv);
            TextView idTv = convertView.findViewById(R.id.listrow_id_tv);
            CheckBox cb = convertView.findViewById(R.id.listrow_cb);
            nameTv.setText("name" + position);
            idTv.setText("123_" + position);
            return convertView;
        }
    }
}