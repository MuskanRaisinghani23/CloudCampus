/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Course;

import Model.Database.SQLiteDatabaseConnection;
import Model.Professor.Professor;
import java.sql.*;
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
        Connection conn = SQLiteDatabaseConnection.connect();
        
        try{
            Statement statement = conn.createStatement();
            String query = "SELECT * FROM Course WHERE professorassociated="+ professorId +";";
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                int courseId = resultSet.getInt("courseId");
                String courseName = resultSet.getString("courseName");
                int professorAssociated = resultSet.getInt("professorAssociated");
                String semester = resultSet.getString("semester");
                int classCapacity = resultSet.getInt("classCapacity");
                Course course = new Course(courseId, courseName, professorAssociated, semester, classCapacity);
                courseList.add(course);
            }
        }
        catch(Exception e){
            System.out.println("Exception raised: " + e);
        }
        return courseList;
    }
    
    public Course addCourse(int courseId, String courseName, int professorAssociated, String semester, int classCapacity){
        Course course = new Course(courseId, courseName, professorAssociated, semester, classCapacity);
        courseList.add(course);
        return course;
    }
    
}
