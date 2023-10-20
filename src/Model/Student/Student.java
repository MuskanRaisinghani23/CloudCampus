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
public class Student {

    private int studentId;
    private String studentName;
    private Date dateStudentCreated;
    private ArrayList<CourseRegistered> coursesRegisteredList;
    // Below ArrayList determines the courses completed by Student, 
    // if this arrayList has 8 courses with grades > 3.2, student can graduate
    private ArrayList<CourseRegistered> transcript;               
    private boolean certificateIssued;
    private boolean wantToGraduate;

    public Student(int studentId, String studentName, Date dateStudentCreated, boolean certificateIssued, boolean wantToGraduate) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.dateStudentCreated = dateStudentCreated;
        this.coursesRegisteredList = new ArrayList<>();
        this.transcript = new ArrayList<>();
        this.certificateIssued = certificateIssued;
        this.wantToGraduate = wantToGraduate;
    }  
    
    
}
