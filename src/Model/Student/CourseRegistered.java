/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Student;

/**
 *
 * @author raisi
 */
public class CourseRegistered {
    private int registeredCourseId;
    private String courseName;
    private int professorAssociated;
    private float gradePointerAchieved;

    public CourseRegistered(int registeredCourseId, String courseName, int professorAssociated, float gradePointerAchieved) {
        this.registeredCourseId = registeredCourseId;
        this.courseName = courseName;
        this.professorAssociated = professorAssociated;
        this.gradePointerAchieved = gradePointerAchieved;
    }

    public int getRegisteredCourseId() {
        return registeredCourseId;
    }

    public void setRegisteredCourseId(int registeredCourseId) {
        this.registeredCourseId = registeredCourseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getProfessorAssociated() {
        return professorAssociated;
    }

    public void setProfessorAssociated(int professorAssociated) {
        this.professorAssociated = professorAssociated;
    }

    public float getGradePointerAchieved() {
        return gradePointerAchieved;
    }

    public void setGradePointerAchieved(float gradePointerAchieved) {
        this.gradePointerAchieved = gradePointerAchieved;
    }
    
}
