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

    
    
}
