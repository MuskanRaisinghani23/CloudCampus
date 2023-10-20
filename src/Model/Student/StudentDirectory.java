/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Student;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author raisi
 */
public class StudentDirectory {
    private ArrayList<Student> studentList;

    // Constructor declaration for the class
    public StudentDirectory() {
        this.studentList = new ArrayList<>();
    }
    
    // Getter for certificateIssuedList
    public ArrayList<Student> getStudentList() {
        return studentList;
    }
    
    // Setter for certificateIssuedList
    public void setStudentList(ArrayList<Student> studentList) {
        this.studentList = studentList;
    }
    
    // Add student to Student Directory
    public Student addStudent(int studentId, String studentName, Date dateStudentCreated, boolean certificateIssued, boolean wantToGraduate){
        Student student = new Student(studentId, studentName, dateStudentCreated, certificateIssued, wantToGraduate);
        studentList.add(student);
        return student;
    }
}
