/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Student;

import Business.Person.Person;
import java.util.ArrayList;

/**
 *
 * @author raisi
 */

public class Student extends Person{
    private ArrayList<CourseRegistered> coursesRegisteredList;
    // Below ArrayList determines the courses completed by Student, 
    // if this arrayList has 8 courses with grades > 3.2, student can graduate
    private ArrayList<CourseRegistered> transcript;               
    private boolean certificateIssued;
    private boolean wantToGraduate;
    private String studentUserName;
    public ArrayList<String> passwordhistory = new ArrayList<String>();

    public Student(ArrayList<CourseRegistered> coursesRegisteredList, ArrayList<CourseRegistered> transcript, boolean certificateIssued, boolean wantToGraduate, int personId, String name, char[] password, int age, String region, long phone, String email, String role) {
        super(personId, name, password, age, region, phone, email, role);
        this.coursesRegisteredList = new ArrayList<>();
        this.transcript = new ArrayList<>();
        this.certificateIssued = certificateIssued;
        this.wantToGraduate = wantToGraduate;
    }

    public ArrayList<CourseRegistered> getCoursesRegisteredList() {
        return coursesRegisteredList;
    }

    public void setCoursesRegisteredList(ArrayList<CourseRegistered> coursesRegisteredList) {
        this.coursesRegisteredList = coursesRegisteredList;
    }

    public ArrayList<CourseRegistered> getTranscript() {
        return transcript;
    }

    public void setTranscript(ArrayList<CourseRegistered> transcript) {
        this.transcript = transcript;
    }

    public boolean isCertificateIssued() {
        return certificateIssued;
    }

    public void setCertificateIssued(boolean certificateIssued) {
        this.certificateIssued = certificateIssued;
    }

    public boolean isWantToGraduate() {
        return wantToGraduate;
    }

    public void setWantToGraduate(boolean wantToGraduate) {
        this.wantToGraduate = wantToGraduate;
    }

    public String getStudentUserName() {
        return studentUserName;
    }

    public void setStudentUserName(String studentUserName) {
        this.studentUserName = studentUserName;
    }

    public ArrayList<String> getPasswordhistory() {
        return passwordhistory;
    }

    public void setPasswordhistory(ArrayList<String> passwordhistory) {
        this.passwordhistory = passwordhistory;
    }
    
    public void addPasswordHistory(String pass){
        passwordhistory.add(pass);
        return;
    }
    
}
