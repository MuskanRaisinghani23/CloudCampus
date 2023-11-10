/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.

*/
package Business;

import Business.Course.CourseDirectory;
import Business.Faculty.ProfessorDirectory;
import Business.Student.StudentDirectory;

/**
 *
 * @author kal bugrara
 */
class ConfigureABusiness {
    static Business initialize() {
        Business business = new Business("Information Systems");

    // Create Persons
        CourseDirectory courseDirectory = business.getCourseDirectory();

    // Create Customers
        StudentDirectory studentDirectory = business.getStudentDirectory();

    // Create Admins to manage the business
        ProfessorDirectory professorDirectory = business.getProfessorDirectory();

        return business;

    }

}
