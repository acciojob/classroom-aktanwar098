package com.driver;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public String addStudent(Student student){
        return studentRepository.addStudentToDB(student);
    }

    public String addTeacher(Teacher teacher){
        return studentRepository.addTeacherToDb(teacher);
    }
    public String addStudentTeacherPair(String sName,String tName){
        return studentRepository.addPair(sName,tName);
    }
    public Student getStudentByName(String sName){
        return studentRepository.getStudentFromDB(sName);
    }
    public List<String> getStudentsByTeacherName(String tName){
        return studentRepository.listOfStudentsByTeacherName(tName);
    }

    public List<String> getAllStudents(){
        return studentRepository.getAllStudents();
    }
    public String deleteTeacherByName(String tName){
        return studentRepository.deleteTeacherFromDB(tName);
    }

    public String deleteAllTeachers(){
        return studentRepository.deleteAllTeacherFromDB();
    }







}
