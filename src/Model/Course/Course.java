/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Course;

/**
 *
 * @author raisi
 */
public class Course {
    private int CourseId;
    private String courseName;
    private int professorAssociated;

    public Course(int CourseId, String courseName, int professorAssociated) {
        this.CourseId = CourseId;
        this.courseName = courseName;
        this.professorAssociated = professorAssociated;
    }
    
}
