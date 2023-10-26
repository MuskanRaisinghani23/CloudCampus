/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Course;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author raisi
 */
public class CourseDirectory {
    private ArrayList<Course> courseList;
    public Set<String> Name;
    public ArrayList<String> courseName;
    
    // Constructor declaration for the class
    public CourseDirectory() {
        this.courseList = new ArrayList<>();
        this.Name = new HashSet<>();
        this.courseName = new ArrayList<>();
    }
    
    // Getter for courseList
    public ArrayList<Course> getCourseList() {
        return courseList;
    }
    
    //Setter for courseList
    public void setCourseList(ArrayList<Course> courseList) {
        this.courseList = courseList;
    }
    
    public Course addCourse(int CourseId, String courseName, int professorAssociated){
        Course course = new Course(CourseId, courseName, professorAssociated);
        courseList.add(course);
        return course;
    }
    
    public ArrayList<String> getCourseName(){
       for(Course course: courseList){
           String name = course.getCourseName();
           if(Name.add(name)){
               courseName.add(name);
           }
       }
       return courseName;
   } 
}
