/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Business.Faculty.ProfessorDirectory;
import Business.Student.StudentDirectory;
import Business.Course.CourseDirectory;

/**
 *
 * @author kal bugrara
 */
public class Business {

    String name;
    CourseDirectory courseDirectory; //all people profiles regardless of the role
    StudentDirectory studentDirectory;
    ProfessorDirectory professorDirectory;


    public Business(String n) {
        name = n;
        professorDirectory = new ProfessorDirectory();
        studentDirectory = new StudentDirectory();
        courseDirectory = new CourseDirectory();
    }

    public CourseDirectory getCourseDirectory() {
        return courseDirectory;
    }

    public StudentDirectory getStudentDirectory() {
        return studentDirectory;
    }

    public ProfessorDirectory getProfessorDirectory() {
        return professorDirectory;
    }
}
