/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Faculty;

import Business.Database.SQLiteDatabaseConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author raisi
 */
public class StudentGradeRequestDirectory {
    private ArrayList<StudentGradeRequest> gradeRequestList;

    public StudentGradeRequestDirectory() {
        this.gradeRequestList = new ArrayList<>();
    }

    public ArrayList<StudentGradeRequest> getStudentRequest(int activeProfessorId) {
        SQLiteDatabaseConnection.disconnect();
        Connection conn = SQLiteDatabaseConnection.connect(); 
        try{
            Statement statement = conn.createStatement();
            String query = "SELECT sc.courseid, c.courseName, c.professorAssociated, p.name, sc.studentid, sc.gradepointachieved \n" +
            "FROM StudentCourse sc \n" +
            "JOIN Course c ON sc.courseId = c.courseid\n" +
            "JOIN Person p ON sc.studentid = p.personId\n" +
            "WHERE gradepointachieved=0 and c.professorAssociated = "+activeProfessorId+";";
            ResultSet resultSet = statement.executeQuery(query);
            gradeRequestList.clear();
            while (resultSet.next()) {
                int courseId = resultSet.getInt("courseId");
                String courseName = resultSet.getString("courseName");
                int studentId = resultSet.getInt("studentId");
                String studentName = resultSet.getString("name");
                StudentGradeRequest gradeRequest = new StudentGradeRequest(courseId, courseName, studentId, studentName, 0);
                gradeRequestList.add(gradeRequest);
            }
            return gradeRequestList;
        }
        catch(Exception e){
            System.out.println("Exception raised: " + e);
        }
        return null;
    }

    public Boolean updateGrade(int courseId, int studentId, float grade) {
        SQLiteDatabaseConnection.disconnect();
        Connection conn = SQLiteDatabaseConnection.connect(); 
        try{
            Statement statement = conn.createStatement();
            String updateGradeQuery = "UPDATE StudentCourse SET gradePointAchieved="+grade+" WHERE courseId="+courseId+" and studentId="+studentId+";";
//            System.out.println(updateGradeQuery);
            statement.executeUpdate(updateGradeQuery);
            return true;
        }
        catch(Exception e){
            System.out.println("Exception raised: " + e);
        }
        return false;
    }
    
}
