/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Faculty;

import Business.Person.Person;
import java.util.ArrayList;

/**
 *
 * @author raisi
 */
public class Professor extends Person {
    private float yearsOfExperience; 
    private String langOfInstruction;
    private ArrayList<String> coursesOffered;
    private ArrayList<String> topicsCovered;
    private ArrayList<Integer> ratingsList;
    private int researchPaperPublished;

    public Professor(float yearsOfExperience, String langOfInstruction, ArrayList<String> coursesOffered, ArrayList<String> topicsCovered, ArrayList<Integer> ratingsList, int researchPaperPublished, int personId, String name, char[] password, int age, String region, long phone, String email, String role) {
        super(personId, name, password, age, region, phone, email, role);
  
        this.yearsOfExperience = yearsOfExperience;
        this.langOfInstruction = langOfInstruction;
        this.coursesOffered = coursesOffered;
        this.topicsCovered = topicsCovered;
        this.ratingsList = ratingsList;
        this.researchPaperPublished = researchPaperPublished;
    }

    public float getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setYearsOfExperience(float yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }

    public String getLangOfInstruction() {
        return langOfInstruction;
    }

    public void setLangOfInstruction(String langOfInstruction) {
        this.langOfInstruction = langOfInstruction;
    }

    public ArrayList<String> getCoursesOffered() {
        return coursesOffered;
    }

    public void setCoursesOffered(ArrayList<String> coursesOffered) {
        this.coursesOffered = coursesOffered;
    }

    public ArrayList<String> getTopicsCovered() {
        return topicsCovered;
    }

    public void setTopicsCovered(ArrayList<String> topicsCovered) {
        this.topicsCovered = topicsCovered;
    }

    public ArrayList<Integer> getRatingsList() {
        return ratingsList;
    }

    public void setRatingsList(ArrayList<Integer> ratingsList) {
        this.ratingsList = ratingsList;
    }

    public int getResearchPaperPublished() {
        return researchPaperPublished;
    }

    public void setResearchPaperPublished(int researchPaperPublished) {
        this.researchPaperPublished = researchPaperPublished;
    }

    
}
