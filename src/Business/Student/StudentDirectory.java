/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Student;

import Business.Database.SQLiteDatabaseConnection;
import Business.Encryption.HashPassword;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 *
 * @author raisi
 */
public class StudentDirectory {
    private ArrayList<Student> studentList;
    private int studentID;

    // Constructor declaration for the class
    public StudentDirectory() {
        this.studentList = new ArrayList<>();
        fetchStudentsFromDB();
    }
    
    // Getter for certificateIssuedList
    public ArrayList<Student> getStudentList() {
        return studentList;
    }
    
    // Setter for certificateIssuedList
    public void setStudentList(ArrayList<Student> studentList) {
        this.studentList = studentList;
    }
    
    // Add student to Student Directory
    public Student addStudent(ArrayList<CourseRegistered> coursesRegisteredList, ArrayList<CourseRegistered> transcript, boolean certificateIssued, boolean wantToGraduate, int studentId, String studentName, char[] studentPassword, int studentAge, String studentRegion, long studentPhone, String studentEmail, String studentRole){
        
        String encryptStudentPassword = HashPassword.hashPassword(new String(studentPassword));
        Student student = new Student(coursesRegisteredList, transcript, certificateIssued, wantToGraduate, studentId, studentName, encryptStudentPassword.toCharArray(), studentAge, studentRegion, studentPhone, studentEmail, studentRole);
        studentList.add(student);
        SQLiteDatabaseConnection.disconnect();
        try{
            Connection conn = SQLiteDatabaseConnection.connect(); 
            Statement statement = conn.createStatement();
            conn.setAutoCommit(false); // Start a transaction

//            Insert data in person and professor table
            String insertStudentQuery = "INSERT INTO STUDENT VALUES("+ studentId +", 0, 0);";
            statement.executeUpdate(insertStudentQuery);
            String insertPersonQuery = "INSERT INTO PERSON VALUES("+studentId+",'"+ studentName +"', '"+new String(encryptStudentPassword)+"',"+studentAge+" ,'"+studentRegion+"',"+studentPhone+", '"+studentEmail+"','"+ studentRole +"');";
            statement.executeUpdate(insertPersonQuery);

            conn.commit();
        }
        catch(Exception e){
            System.out.println("Exception raised: " + e);
        }
        
        return student;
    }
    
    //To search student based on 
    public Student searchStudent(int studentId){
        for(Student studentInfo: studentList){
            if(studentInfo.getPersonId()== studentId){
                return studentInfo;
            }
        }
        return null;
    }
    
    public Boolean searchStudentIfExist(int userId) {
       for(Student studentInfo: studentList){
            if(studentInfo.getPersonId()== userId){
                return true;
            }
        }
        return false;
    }
    
    public int getLoggedStudentID() {
        return studentID;
    }

    // Set details of logged in professor
    public void setLoggedStudentID(int studentID) {
        this.studentID = studentID;
    }
    
    private void fetchStudentsFromDB() {
        SQLiteDatabaseConnection.disconnect();
        Connection conn = SQLiteDatabaseConnection.connect(); 
        try{
            Statement statement = conn.createStatement();
            String query = "SELECT * FROM PERSON JOIN STUDENT WHERE personid = studentid;";
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                int studentId = resultSet.getInt("personId");
                String studentName = resultSet.getString("name");
                char[] studentPassword = resultSet.getString("password").toCharArray();
                int studentAge = resultSet.getInt("age");
                String studentRegion = resultSet.getString("region");
                long studentPhone = resultSet.getLong("phone");
                String studentEmail = resultSet.getString("email");
                String studentRole = "Student";
                ArrayList<CourseRegistered> coursesRegisteredList = new ArrayList<>();
                ArrayList<CourseRegistered> transcript = new ArrayList<>();               
                boolean certificateIssued = resultSet.getBoolean("certificateIssued");
                boolean wantToGraduate = resultSet.getBoolean("wantToGraduate");
                
                Student student = new Student(coursesRegisteredList, transcript, certificateIssued, wantToGraduate, studentId, studentName, studentPassword, studentAge, studentRegion, studentPhone, studentEmail, studentRole);
                studentList.add(student);
            }

        }   
        catch(Exception e){
            System.out.println("Exception raised: " + e);
            e.printStackTrace();
        }
    }
    public ArrayList<String> fetchStudentAnalytics() {
        SQLiteDatabaseConnection.disconnect();
        Connection conn = SQLiteDatabaseConnection.connect(); 
         ArrayList <String> values = new ArrayList<>();
        try{
            Statement statement = conn.createStatement();
            String query = "SELECT p.personid, p.name, COUNT(sc.courseid) as courseCount, ROUND(AVG(gradepointachieved),2) AS averageGPA\n" +
            "FROM PERSON p \n" +
            "JOIN Student s ON p.personid = s.studentid\n" +
            "JOIN StudentCourse sc ON sc.studentId=s.studentId\n" +
            "WHERE sc.gradePointAchieved!=-1\n"+
            "GROUP BY sc.studentId;";
            ResultSet resultSet = statement.executeQuery(query);
 
            while (resultSet.next()) {
                int studentId = resultSet.getInt("personId");
                String studentName = resultSet.getString("name");
                int courseCount = resultSet.getInt("courseCount");
                String avgGPA = String.valueOf(resultSet.getFloat("averageGPA"));
                String record = studentId + "," + studentName + "," + courseCount+","+avgGPA;
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
