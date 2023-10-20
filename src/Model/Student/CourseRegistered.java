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
    
}
