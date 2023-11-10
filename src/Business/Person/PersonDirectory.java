/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Person;
import Business.Database.SQLiteDatabaseConnection;
import Business.Encryption.HashPassword;
import Business.Faculty.Professor;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author kal bugrara
 */
public class PersonDirectory {
    
    private ArrayList<Person> personlist ;
    
    public PersonDirectory (){  
        personlist = new ArrayList<>();
    }

    public Person newPerson(int id, String name, char[] password, int age, String region, int phone, String email, String role) {
        Person p = new Person(id, name, password, age, region, phone, email, role);
        personlist.add(p);
        return p;
    }

//    public Person findPerson(int id) {
//        for (Person p : personlist) {
//            if (p.isMatch(id)) {
//                return p;
//            }
//        }
//        return null; //not found after going through the whole list
//    }
    
    public int fetchNextUserId(){
        SQLiteDatabaseConnection.disconnect();
        Connection conn = SQLiteDatabaseConnection.connect(); 
        try{
            Statement statement = conn.createStatement();
            String query = "SELECT seq FROM sqlite_sequence WHERE name='Person';";
            ResultSet resultSet = statement.executeQuery(query);
            int nextUserId = resultSet.getInt(1) + 1;
            return nextUserId;
        }
        catch(Exception e){
            System.out.println("Exception raised: " + e);
        }
        return 100001;
    }

    public Boolean updatePerson(int personId, String name, int age, String region, long phno, String email) {
        SQLiteDatabaseConnection.disconnect();
        Connection conn = SQLiteDatabaseConnection.connect(); 
        try{
            Statement statement = conn.createStatement();
            String updatePersonQuery = "UPDATE PERSON SET name='"+name+"', age="+age+", region ='"+region+"', phone="+phno+", email='"+email+"' WHERE personId="+personId+";";
            statement.executeUpdate(updatePersonQuery);
            
            return true;
        }
        catch(Exception e){
            System.out.println("Exception raised: " + e);
        }
        return false;
    }

    public Boolean updatePassword(int personId, String password) {
        SQLiteDatabaseConnection.disconnect();
        Connection conn = SQLiteDatabaseConnection.connect(); 
        try{
            Statement statement = conn.createStatement();
            String encryptedPass = HashPassword.hashPassword(password);
            String updatePersonQuery = "UPDATE PERSON SET password='"+encryptedPass+"' WHERE personId="+personId+";";
            statement.executeUpdate(updatePersonQuery);
            return true;
        }
        catch(Exception e){
            System.out.println("Exception raised: " + e);
        }
        return false;
    }

    public Boolean checkExistingPass(int personId, String prevPassword) {
        SQLiteDatabaseConnection.disconnect();
        Connection conn = SQLiteDatabaseConnection.connect(); 
        try{
            Statement statement = conn.createStatement();
            String query = "SELECT password FROM PERSON WHERE personId = "+personId+";";
            ResultSet resultSet = statement.executeQuery(query);
            String existingPassword = resultSet.getString(1);
            String encryptedPass = HashPassword.hashPassword(prevPassword);
//            System.out.println(existingPassword +"--"+ encryptedPass);
            return existingPassword.equals(encryptedPass);
        }
        catch(Exception e){
            System.out.println("Exception raised: " + e);
        }
        return false;
    }
}
