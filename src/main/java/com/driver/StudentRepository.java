package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


@Repository
public class StudentRepository {


    HashMap<String,Student> studentDB = new HashMap<>();
    HashMap<String,Teacher> teacherDB = new HashMap<>();

    HashMap<String, List<String>> pair = new HashMap<>();





    public String addStudentToDB(Student student){

        String sname = student.getName();
        studentDB.put(sname,student);
        return "Student added successfully";
    }

    public String addTeacherToDb(Teacher teacher){
        String tName = teacher.getName();
        teacherDB.put(tName,teacher);
        return "Teacher added successfully";
    }

    public String addPair(String sName,String tName){
        if(studentDB.containsKey(sName) && teacherDB.containsKey(tName)){
            if(!pair.containsKey(tName)){
                List<String> studentList = new ArrayList<>();
                studentList.add(sName);
                pair.put(tName,studentList);
            }
            else{
                List<String> studentList = pair.get(tName);
                studentList.add(sName);
                pair.put(tName,studentList);
            }
            return "Paired Successfully";
        }
        return "Pair Does Not Exist";
    }

    public Student getStudentFromDB(String sName){
        if(studentDB.containsKey(sName)){
            return studentDB.get(sName);
        }
        else{
            return null;
        }
    }

    public Teacher getTeacherFromDB(String tName){
        if(teacherDB.containsKey(tName)){
            return teacherDB.get(tName);
        }
        else{
            return null;
        }
    }

    public List<String> listOfStudentsByTeacherName(String tName){
        if(pair.containsKey(tName)){
            return pair.get(tName);
        }
        return null;
    }

    public List<String> getAllStudents(){
        List<String> studentList=new ArrayList<>();
        for(String st:studentDB.keySet()){
            studentList.add(st);
        }
        return studentList;
    }

    public String deleteTeacherFromDB(String tName){
        if(teacherDB.containsKey(tName)){
            if(pair.containsKey(tName)){
                List<String> students = pair.get(tName);
                for(String s : students){
                    if(studentDB.containsKey(s)){
                        studentDB.remove(s);
                    }
                }
                pair.remove(tName);
            }
            teacherDB.remove(tName);
            return "Teacher Deleted Successfully";
        }
        return "Teacher Doesnot Exist";
    }




}
