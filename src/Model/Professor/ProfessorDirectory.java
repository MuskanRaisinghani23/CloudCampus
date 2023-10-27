/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Professor;

import Model.Database.SQLiteDatabaseConnection;
import java.util.ArrayList;
import java.sql.*;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author raisi
 */
public class ProfessorDirectory {
    private ArrayList<Professor> professorList;
    private int professorId;
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
    
    public Professor addProfessor(int professorId, String professorName, int professorAge, String professorAddress, float yearsOfExperience, 
            String langOfInstruction, ArrayList<String> coursesOffered, ArrayList<String> topicsCovered, ArrayList<Integer> ratingsList, 
            int researchPaperPublished, String description, String location){
        Professor professor = new Professor(professorId, professorName, professorAge, professorAddress, yearsOfExperience, langOfInstruction,
                coursesOffered, topicsCovered, ratingsList, researchPaperPublished, description, location);
        professorList.add(professor);
        return professor;
    }
    
    // Get details of logged in professor
    public int getLoggedProfessorID() {
        return professorId;
    }

    // Set details of logged in professor
    public void setLoggedProfessorID(int professorId) {
        this.professorId = professorId;
    }
    
    public Professor getProfessorByProfessorId(int professorId){
        for(Professor professor:professorList){
            if(professor.getProfessorId()==professorId){
                return professor;
            }
        }
        return null;
    }

    private void fetchProfessorsFromDB() {
        Connection conn = SQLiteDatabaseConnection.connect(); 
        try{
            Statement statement = conn.createStatement();
            String query = "SELECT * FROM Professor;";
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                int professorId = resultSet.getInt("professorId");
                String professorName = resultSet.getString("professorName");
                int professorAge = resultSet.getInt("age");
                String professorAddress = resultSet.getString("address");
                float yearsOfExperience = resultSet.getFloat("yearsOfExperience"); 
                String langOfInstruction = resultSet.getString("langOfInstruction");
                ArrayList<String> coursesOffered = new ArrayList<>(); // Need to fetch courses from course table using for loop
                ArrayList<String> topicsCovered = new ArrayList<>();  // Need to figure this out
                ArrayList<Integer> ratingsList = new ArrayList<>();  // Need to figure this out
                int researchPaperPublished = resultSet.getInt("researchPaperPublished");
                String description = resultSet.getString("description");
                String location = "Boston"; // Modify this in DB 
                Professor professor = new Professor(professorId, professorName, professorAge, professorAddress, yearsOfExperience, langOfInstruction, coursesOffered, topicsCovered, ratingsList, researchPaperPublished, description, location);
//                System.out.println(professorName);
                professorList.add(professor);
            }
        }
        catch(Exception e){
            System.out.println("Exception raised: " + e);
        }
    }
    
   public ArrayList<String> getProfessorNameList(){
       for(Professor prof: professorList){
           String name = prof.getProfessorName();
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
           String location = prof.getLocation();
           if(Location.add(location)){
                ProfessorLocation.add(location);
           }
       }
       return ProfessorLocation;
   } 
   
}
