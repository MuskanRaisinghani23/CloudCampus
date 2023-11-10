/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Person;

/**
 *
 * @author kal bugrara
 */
public class Person {

    public int personId;
    public String name;
    public int age;
    public String region;
    public long phone;
    public String email;
    public String role;
    public char[] password;

    public Person(int personId, String name, char[] password, int age, String region, long phone, String email, String role) {
        this.personId = personId;
        this.name = name;
        this.password = password;
        this.age = age;
        this.region = region;
        this.phone = phone;
        this.email = email;
        this.role = role;
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public char[] getPassword() {
        return password;
    }

    public void setPassword(char[] password) {
        this.password = password;
    }

    public boolean isMatch(int id) {
        if (getPersonId() == id) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return String.valueOf(getPersonId());
    }
    
    
}
