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
public class ProfessorDirectory {
    private ArrayList<Professor> professorList;

    // Constructor declaration for the class
    public ProfessorDirectory() {
        this.professorList = new ArrayList<>();
    }
    
    // Getter for certificateIssuedList
    public ArrayList<Professor> getProfessorList() {
        return professorList;
    }
    
    // Setter for certificateIssuedList
    public void setProfessorList(ArrayList<Professor> professorList) {
        this.professorList = professorList;
    }
    
    public Professor addProfessor(int professorId, String professorName, String langOfInstruction){
        Professor professor = new Professor( professorId, professorName, langOfInstruction);
        professorList.add(professor);
        return professor;
    }
    
    
    
    
}
