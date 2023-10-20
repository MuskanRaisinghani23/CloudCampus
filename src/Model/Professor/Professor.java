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
    private String langOfInstruction;
    private ArrayList<String> topicsCovered;
    private ArrayList<Integer> ratingsList;

    public Professor(int professorId, String professorName, String langOfInstruction) {
        this.professorId = professorId;
        this.professorName = professorName;
        this.langOfInstruction = langOfInstruction;
        this.topicsCovered = new ArrayList<>();
        this.ratingsList = new ArrayList<>() ;
    }
    
}
