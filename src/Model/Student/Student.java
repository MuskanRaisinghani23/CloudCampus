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
    private String studentUserName;
    private String studentPassword;
    public ArrayList<String> passwordhistory = new ArrayList<String>();
    private String studentConfirmPassword;

    public Student(int studentId, String studentName, Date dateStudentCreated, boolean certificateIssued, boolean wantToGraduate) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.dateStudentCreated = dateStudentCreated;
        this.coursesRegisteredList = new ArrayList<>();
        this.transcript = new ArrayList<>();
        this.certificateIssued = certificateIssued;
        this.wantToGraduate = wantToGraduate;
    }  

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public Date getDateStudentCreated() {
        return dateStudentCreated;
    }

    public void setDateStudentCreated(Date dateStudentCreated) {
        this.dateStudentCreated = dateStudentCreated;
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

    public String getStudentPassword() {
        return studentPassword;
    }

    public void setStudentPassword(String studentPassword) {
        this.studentPassword = studentPassword;
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

    public String getStudentConfirmPassword() {
        return studentConfirmPassword;
    }

    public void setStudentConfirmPassword(String studentConfirmPassword) {
        this.studentConfirmPassword = studentConfirmPassword;
    }
}
