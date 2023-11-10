/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Faculty;

import Business.Database.SQLiteDatabaseConnection;
import Business.Encryption.HashPassword;
import java.util.ArrayList;
import java.sql.*;
import java.text.DecimalFormat;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author raisi
 */
public class ProfessorDirectory {
    private ArrayList<Professor> professorList;
    private int personId;
//    private int professorId;
    public Set<String> Name;
    public Set<String> Language;
    public Set<String> Location;
    public ArrayList<String> professorNameList;
    public ArrayList<String> ProfessorLanguage;
    public ArrayList<String> ProfessorLocation;

    // Constructor declaration for the class
    public ProfessorDirectory() {
        this.professorList = new ArrayList<>();
        this.Language = new HashSet<>();
        this.Name = new HashSet<>();
        this.Location = new HashSet<>();
        this.professorNameList = new ArrayList<>();
        this.ProfessorLanguage = new ArrayList<>();
        this.ProfessorLocation = new ArrayList<>();
        fetchProfessorsFromDB();
    }
    
    // Getter for certificateIssuedList
    public ArrayList<Professor> getProfessorList() {
        return professorList;
    }
    
    // Setter for certificateIssuedList
    public void setProfessorList(ArrayList<Professor> professorList) {
        this.professorList = professorList;
    }
    
    public Professor addProfessor(float yearsOfExperience, String langOfInstruction, ArrayList<String> coursesOffered, ArrayList<String> topicsCovered, ArrayList<Integer> ratingsList, int researchPaperPublished, int professorId, String professorName, char[] professorPassword, int professorAge, String professorRegion, long professorPhone, String professorEmail, String role){
        
//        Encrypt password
        String encryptProfessorPassword = HashPassword.hashPassword(new String(professorPassword));
        
        Professor professor = new Professor(yearsOfExperience, langOfInstruction, coursesOffered, topicsCovered, ratingsList, researchPaperPublished, professorId, professorName, encryptProfessorPassword.toCharArray(), professorAge, professorRegion, professorPhone, professorEmail, role);
        professorList.add(professor);
        SQLiteDatabaseConnection.disconnect();
        try{
            Connection conn = SQLiteDatabaseConnection.connect(); 
            Statement statement = conn.createStatement();
            conn.setAutoCommit(false); // Start a transaction

//            Insert data in person and professor table
            String insertProfessorQuery = "INSERT INTO PROFESSOR VALUES("+professorId+","+ yearsOfExperience +", '"+langOfInstruction+"', '','',"+researchPaperPublished+");";
            statement.executeUpdate(insertProfessorQuery);
            String insertPersonQuery = "INSERT INTO PERSON VALUES("+professorId+",'"+ professorName +"', '"+new String(encryptProfessorPassword)+"',"+professorAge+" ,'"+professorRegion+"',"+professorPhone+", '"+professorEmail+"','"+ role +"');";
            statement.executeUpdate(insertPersonQuery);

            conn.commit();
        }
        catch(Exception e){
            System.out.println("Exception raised: " + e);
        }
        
        return professor;
    }

    private void fetchProfessorsFromDB() {
        SQLiteDatabaseConnection.disconnect();
        Connection conn = SQLiteDatabaseConnection.connect(); 
        try{
            Statement statement = conn.createStatement();
            String query = "SELECT * FROM PERSON JOIN Professor WHERE personid = professorId;";
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                int professorId = resultSet.getInt("personId");
                String professorName = resultSet.getString("name");
                char[] professorPassword = resultSet.getString("password").toCharArray();
                int professorAge = resultSet.getInt("age");
                float yearsOfExperience = resultSet.getFloat("yearsOfExperience"); 
                String langOfInstruction = resultSet.getString("langOfInstruction");
                ArrayList<String> coursesOffered = new ArrayList<>(); // Need to fetch courses from course table using for loop
                ArrayList<String> topicsCovered = new ArrayList<>();  // Need to figure this out
                ArrayList<Integer> ratingsList = new ArrayList<>();  // Need to figure this out
                int researchPaperPublished = resultSet.getInt("researchPaperPublished");
                String professorRegion = resultSet.getString("region");
                long professorPhone = resultSet.getLong("phone");
                String professorEmail = resultSet.getString("email"); 
                String professorRole = "Professor";
                Professor professor = new Professor(yearsOfExperience, langOfInstruction, coursesOffered, topicsCovered, ratingsList, researchPaperPublished, professorId, professorName, professorPassword, professorAge, professorRegion, professorPhone, professorEmail, professorRole);
                professorList.add(professor);
            }
        }
        catch(Exception e){
            System.out.println("Exception raised: " + e);
        }
    }  
    
    // Get details of logged in professor
    public int getLoggedProfessorID() {
        return personId;
    }

    // Set details of logged in professor
    public void setLoggedProfessorID(int professorId) {
        this.personId = professorId;
    }
    
    public Professor getProfessorByProfessorId(int professorId){
        for(Professor professor:professorList){
            if(professor.getPersonId()==professorId){
                return professor;
            }
        }
        return null;
    }
    
    public Boolean searchProfessorIfExist(int userId) {
       for(Professor professorInfo: professorList){
            if(professorInfo.getPersonId()== userId){
                return true;
            }
        }
        return false;
    }
    
    public Boolean checkPasswordByProfessorId(int userId, char[] password) {
       for(Professor professorInfo: professorList){
            String storedPass = new String(professorInfo.getPassword());
            String enteredPass = HashPassword.hashPassword(new String(password));
            //System.out.println(storedPass + "---- " + enteredPass);
            if(storedPass.equals(enteredPass)){
                return true;
            }
        }
        return false; 
    }
    
    public ArrayList<String> getProfessorNameList(){
       for(Professor prof: professorList){
           String name = prof.getName();
           if(Name.add(name)){
                professorNameList.add(name);
           }
       }
       return professorNameList;
   } 
   public ArrayList<String> getProfessorLanguage(){
       for(Professor prof: professorList){
           String language = prof.getLangOfInstruction();
           if(Language.add(language)){
                ProfessorLanguage.add(language);
           }
       }
       return ProfessorLanguage;
   } 
   public ArrayList<String> getProfessorLocation(){
       for(Professor prof: professorList){
           String location = prof.getRegion();
           if(Location.add(location)){
                ProfessorLocation.add(location);
           }
       }
       return ProfessorLocation;
   } 

    public Boolean updateProfessor(int personId, String language, int researchPaper, int experience) {
        SQLiteDatabaseConnection.disconnect();
        Connection conn = SQLiteDatabaseConnection.connect(); 
        try{
            Statement statement = conn.createStatement();
            String updateProfQuery = "UPDATE PROFESSOR SET yearsOfExperience="+experience+", langOfInstruction = '"+language+"', researchPaperPublished ="+researchPaper+" WHERE professorId="+personId+";";
            statement.executeUpdate(updateProfQuery);
            return true;
        }
        catch(Exception e){
            System.out.println("Exception raised: " + e);
        }
        return false;
    }

    public Boolean addCourse(int loggedProfId, String courseName, String semester, int classCapacity) {
        SQLiteDatabaseConnection.disconnect();
        Connection conn = SQLiteDatabaseConnection.connect(); 
        try{
            Statement statement = conn.createStatement();
            String insertCourseQuery = "INSERT INTO Course(courseName, professorAssociated, semester, classCapacity, courseRating) VALUES('"+courseName+"', "+loggedProfId+", '"+semester+"', "+classCapacity+", '');";
            statement.executeUpdate(insertCourseQuery);
            return true;
        }
        catch(Exception e){
            System.out.println("Exception raised: " + e);
        }
        return false;
    }

    public Boolean updateCourse(int courseId, String courseName, String semester, int classCapacity) {
        SQLiteDatabaseConnection.disconnect();
        Connection conn = SQLiteDatabaseConnection.connect(); 
        try{
            Statement statement = conn.createStatement();
            String updateCourseQuery = "UPDATE Course set courseName='"+courseName+"', semester='"+semester+"', classCapacity="+classCapacity+" WHERE courseId = "+courseId+";";
            statement.executeUpdate(updateCourseQuery);
            return true;
        }
        catch(Exception e){
            System.out.println("Exception raised: " + e);
        }
        return false;
    }
    public ArrayList<String> fetchProfessorAnalytics() {
        SQLiteDatabaseConnection.disconnect();
        Connection conn = SQLiteDatabaseConnection.connect(); 
         ArrayList <String> values = new ArrayList<>();
        try{
            Statement statement = conn.createStatement();
            String query = "SELECT p.personid, p.name, COUNT(c.courseid) as courseCount, r.ratingsList FROM PERSON p \n" +
            "JOIN Professor r ON personid = professorId\n" +
            "JOIN Course c ON c.professorAssociated=r.professorId\n" +
            "GROUP BY r.professorId;\n" +
            "";
            ResultSet resultSet = statement.executeQuery(query);
 
            while (resultSet.next()) {
                int professorId = resultSet.getInt("personId");
                String professorName = resultSet.getString("name");
                int courseCount = resultSet.getInt("courseCount");
                String ratingsListStr = resultSet.getString("ratingsList");
                int sum = 0;
                int count = 0;
                for (String value : ratingsListStr.split(",")) {
                    int intValue = Integer.parseInt(value.trim());
                    sum += intValue;
                    count++;
                }
                String rating = String.valueOf((double) sum / count);
                DecimalFormat df = new DecimalFormat("#.##");
                rating = df.format(Double.parseDouble(rating));
                String record = professorId + "," + professorName + "," + courseCount+","+rating;
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
