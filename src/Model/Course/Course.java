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
    private int courseId;
    private String courseName;
    private int professorAssociated;
    private String semester;
    private int classCapacity;

    public Course(int courseId, String courseName, int professorAssociated, String semester, int classCapacity) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.professorAssociated = professorAssociated;
        this.semester = semester;
        this.classCapacity = classCapacity;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
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

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public int getClassCapacity() {
        return classCapacity;
    }

    public void setClassCapacity(int classCapacity) {
        this.classCapacity = classCapacity;
    }
    
    @Override
    public String toString(){
        return String.valueOf(courseId);
    }
}
