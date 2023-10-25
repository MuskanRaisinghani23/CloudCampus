/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Course;

import java.util.ArrayList;

/**
 *
 * @author raisi
 */
public class CourseDirectory {
    private ArrayList<Course> courseList;
    
    // Constructor declaration for the class
    public CourseDirectory() {
        this.courseList = new ArrayList<>();
    }
    
    // Getter for courseList
    public ArrayList<Course> getCourseList() {
        return courseList;
    }
    
    //Setter for courseList
    public void setCourseList(ArrayList<Course> courseList) {
        this.courseList = courseList;
    }
    
    // Getter for courseList based on professor
    public ArrayList<Course> getCourseListByProfessor(int professorId) {
        
        return courseList;
    }
    
    public Course addCourse(int courseId, String courseName, int professorAssociated, String semester, int classCapacity){
        Course course = new Course(courseId, courseName, professorAssociated, semester, classCapacity);
        courseList.add(course);
        return course;
    }
    
}
