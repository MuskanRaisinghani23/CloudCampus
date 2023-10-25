/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Professor;

import java.util.ArrayList;

/**
 *
 * @author raisi
 */
public class Professor {
    private int professorId;
    private String professorName;
    private int professorAge;
    private String professorAddress;
    private float yearsOfExperience; 
    private String langOfInstruction;
    private ArrayList<String> coursesOffered;
    private ArrayList<String> topicsCovered;
    private ArrayList<Integer> ratingsList;
    private int researchPaperPublished;
    private String description;

    public Professor(int professorId, String professorName, int professorAge, String professorAddress, float yearsOfExperience, String langOfInstruction, ArrayList<String> coursesOffered, ArrayList<String> topicsCovered, ArrayList<Integer> ratingsList, int researchPaperPublished, String description) {
        this.professorId = professorId;
        this.professorName = professorName;
        this.professorAge = professorAge;
        this.professorAddress = professorAddress;
        this.yearsOfExperience = yearsOfExperience;
        this.langOfInstruction = langOfInstruction;
        this.coursesOffered = new ArrayList<>();
        this.topicsCovered = new ArrayList<>();
        this.ratingsList = new ArrayList<>();
        this.researchPaperPublished = researchPaperPublished;
        this.description = description;
    }

    public int getProfessorId() {
        return professorId;
    }

    public void setProfessorId(int professorId) {
        this.professorId = professorId;
    }

    public String getProfessorName() {
        return professorName;
    }

    public void setProfessorName(String professorName) {
        this.professorName = professorName;
    }

    public int getProfessorAge() {
        return professorAge;
    }

    public void setProfessorAge(int professorAge) {
        this.professorAge = professorAge;
    }

    public String getProfessorAddress() {
        return professorAddress;
    }

    public void setProfessorAddress(String professorAddress) {
        this.professorAddress = professorAddress;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    
    
}
