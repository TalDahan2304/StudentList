package com.example.studentlist.model;

import java.util.LinkedList;
import java.util.List;

public class Model {

    public static final Model instance = new Model();

    private Model(){
        for(int i=0;i<10;i++){
            Student s = new Student("name","id_"+i,false, "phone", "address");
            data.add(s);
        }

    }

    List<Student> data = new LinkedList<Student>();

    public List<Student> getAllStudents(){
        return data;
    }

    public void addStudent(Student student){
        data.add(student);
    }

    public void deleteStudent(int pos){ data.remove(pos); }

    public Student getStudent(int pos){ return data.get(pos); }

}
