/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Faculty;

/**
 *
 * @author raisi
 */
public class StudentGradeRequest {
    private int registeredCourseId;
    private String registeredCourseName;
    private int registeredStudentId;
    private String registeredStudentName;
    private float gradePointerAchieved;

    public StudentGradeRequest(int registeredCourseId, String registeredCourseName, int registeredStudentId, String registeredStudentName, float gradePointerAchieved) {
        this.registeredCourseId = registeredCourseId;
        this.registeredCourseName = registeredCourseName;
        this.registeredStudentId = registeredStudentId;
        this.registeredStudentName = registeredStudentName;
        this.gradePointerAchieved = gradePointerAchieved;
    }

    public int getRegisteredCourseId() {
        return registeredCourseId;
    }

    public void setRegisteredCourseId(int registeredCourseId) {
        this.registeredCourseId = registeredCourseId;
    }

    public int getRegisteredStudentId() {
        return registeredStudentId;
    }

    public void setRegisteredStudentId(int registeredStudentId) {
        this.registeredStudentId = registeredStudentId;
    }

    public float getGradePointerAchieved() {
        return gradePointerAchieved;
    }

    public void setGradePointerAchieved(float gradePointerAchieved) {
        this.gradePointerAchieved = gradePointerAchieved;
    }

    public String getRegisteredCourseName() {
        return registeredCourseName;
    }

    public void setRegisteredCourseName(String registeredCourseName) {
        this.registeredCourseName = registeredCourseName;
    }

    public String getRegisteredStudentName() {
        return registeredStudentName;
    }

    public void setRegisteredStudentName(String registeredStudentName) {
        this.registeredStudentName = registeredStudentName;
    }
    
    @Override
    public String toString(){
        return String.valueOf(registeredCourseId);
    }
}
