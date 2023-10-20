/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.CertificationAuthority;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author raisi
 */
public class CertificateDirectory {
    private ArrayList<Certificate> certificateIssuedList;

    // Constructor declaration for the class
    public CertificateDirectory() {
        this.certificateIssuedList = new ArrayList<>();
    }
    
    // Getter for certificateIssuedList
    public ArrayList<Certificate> getCertificateIssuedList() {
        return certificateIssuedList;
    }

    // Setter for certificateIssuedList
    public void setCertificateIssuedList(ArrayList<Certificate> certificateIssuedList) {
        this.certificateIssuedList = certificateIssuedList;
    }
    
    public Certificate addCertificateIssued(int certificateId, Date dateIssued, int issuedTo){
        Certificate certificate = new Certificate(certificateId, dateIssued, issuedTo);
        certificateIssuedList.add(certificate);
        return certificate;
    }
}
