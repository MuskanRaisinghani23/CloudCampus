/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.CertificationAuthority;

import java.util.Date;

/**
 *
 * @author raisi
 */
public class Certificate {

    private int certificateId;
    private Date dateIssued;
    private int issuedTo;
    
    public Certificate(int certificateId, Date dateIssued, int issuedTo) {
        this.certificateId = certificateId;
        this.dateIssued = dateIssued;
        this.issuedTo = issuedTo;
    }
    
}
