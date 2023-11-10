/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Course;

import Business.Database.SQLiteDatabaseConnection;
import Business.Student.CourseRegistered;
import java.sql.*;
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
    
    // Getter for courseList based on professor
    public ArrayList<Course> getCourseListByProfessor(int professorId) {
        SQLiteDatabaseConnection.disconnect();
        Connection conn = SQLiteDatabaseConnection.connect();
        String query;
        try{
            Statement statement = conn.createStatement();
            if(professorId == -1){
                query = "SELECT * FROM Course;";
            }
            else{
                query = "SELECT * FROM Course WHERE professorassociated="+ professorId +";";
            }

            ResultSet resultSet = statement.executeQuery(query);
            courseList.clear();
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
    
    public ArrayList<String> getCourseNameList(){
        ArrayList<Course> allcourse = getCourseListByProfessor(-1);
       for(Course course: allcourse){
           String name = course.getCourseName();
           if(Name.add(name)){
               courseName.add(name);
           }
       }
       return courseName;
   } 
    public ArrayList<String> fetchCourseAnalytics() {
        SQLiteDatabaseConnection.disconnect();
        Connection conn = SQLiteDatabaseConnection.connect(); 
         ArrayList <String> values = new ArrayList<>();
        try{
            Statement statement = conn.createStatement();
            String query = "SELECT sc.courseId, c.coursename, COUNT(*) AS StudentEnrolled \n" +
"FROM StudentCourse sc JOIN Course c\n" +
"ON sc.courseId=c.courseId\n" +
"group by sc.courseid ;";
            ResultSet resultSet = statement.executeQuery(query);
 
            while (resultSet.next()) {
                int courseId = resultSet.getInt("courseId");
                String coursename = resultSet.getString("courseName");
                int studentCount = resultSet.getInt("StudentEnrolled");
                String record = courseId + "," + coursename + "," + studentCount;
                values.add(record);
             
            }
            return values;
        }
        catch(Exception e){
            System.out.println("Exception raised: " + e);
        }
        return null;
    }  
}
