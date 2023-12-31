/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package UserInterface.WorkAreas.LoginFramework;

import Business.Course.CourseDirectory;
import Business.Faculty.ProfessorDirectory;
import Business.Person.PersonDirectory;
import Business.Student.StudentDirectory;
import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author dwive
 */
public class SignUpJPanel extends javax.swing.JPanel {

    /**
     * Creates new form SignUpJPanel
     */
    private JPanel homeJPanel;
    private PersonDirectory manageperson;
    private ProfessorDirectory manageprofessor;
    private CourseDirectory managecourse;
    private StudentDirectory managestudent;
    
    public SignUpJPanel(JPanel homeJPanel, PersonDirectory manageperson,ProfessorDirectory manageprofessor, StudentDirectory managestudent) {
        initComponents();
        this.homeJPanel = homeJPanel;
        this.manageperson = manageperson;
        this.manageprofessor = manageprofessor;
        this.managestudent = managestudent; 
        
        int nextUserId = manageperson.fetchNextUserId();
        StudentSignupJPanel panel = new StudentSignupJPanel(homeJPanel,nextUserId, managestudent);
        jSplitPane1.setRightComponent(panel);
        
        studentRadioButton.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                if (studentRadioButton.isSelected()) {
                    StudentSignupJPanel panel = new StudentSignupJPanel(homeJPanel,nextUserId, managestudent);
                    jSplitPane1.setRightComponent(panel);
                }
            }
        });
         
        professorRadioButton.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                if (professorRadioButton.isSelected()) {
                    ProfessorSignupJPanel panel = new ProfessorSignupJPanel(homeJPanel,nextUserId, manageprofessor);
                    jSplitPane1.setRightComponent(panel);
                }
            }
        });
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        userselectionbtngrp = new javax.swing.ButtonGroup();
        jSplitPane1 = new javax.swing.JSplitPane();
        jPanel1 = new javax.swing.JPanel();
        studentRadioButton = new javax.swing.JRadioButton();
        professorRadioButton = new javax.swing.JRadioButton();
        backbtn = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();

        setBackground(new java.awt.Color(255, 255, 255));

        jSplitPane1.setDividerLocation(80);
        jSplitPane1.setDividerSize(1);
        jSplitPane1.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        userselectionbtngrp.add(studentRadioButton);
        studentRadioButton.setFont(new java.awt.Font("Cambria Math", 1, 18)); // NOI18N
        studentRadioButton.setForeground(new java.awt.Color(102, 51, 0));
        studentRadioButton.setSelected(true);
        studentRadioButton.setText("Student");
        studentRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                studentRadioButtonActionPerformed(evt);
            }
        });

        userselectionbtngrp.add(professorRadioButton);
        professorRadioButton.setFont(new java.awt.Font("Cambria Math", 1, 18)); // NOI18N
        professorRadioButton.setForeground(new java.awt.Color(102, 51, 0));
        professorRadioButton.setText("Professor");
        professorRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                professorRadioButtonActionPerformed(evt);
            }
        });

        backbtn.setBackground(new java.awt.Color(102, 51, 0));
        backbtn.setFont(new java.awt.Font("Cambria Math", 1, 14)); // NOI18N
        backbtn.setForeground(new java.awt.Color(255, 255, 255));
        backbtn.setText("<< back to Homepage");
        backbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backbtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(485, Short.MAX_VALUE)
                .addComponent(studentRadioButton, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addComponent(professorRadioButton, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(249, 249, 249)
                .addComponent(backbtn)
                .addGap(19, 19, 19))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(studentRadioButton)
                    .addComponent(professorRadioButton)
                    .addComponent(backbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jSplitPane1.setTopComponent(jPanel1);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1200, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 619, Short.MAX_VALUE)
        );

        jSplitPane1.setRightComponent(jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addComponent(jSplitPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1200, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(jSplitPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 700, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void studentRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_studentRadioButtonActionPerformed
        // TODO add your handling code here:
       // professorRadioButton.setEnabled(false);
    }//GEN-LAST:event_studentRadioButtonActionPerformed

    private void professorRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_professorRadioButtonActionPerformed
        // TODO add your handling code here:
        //studentRadioButton.setEnabled(false);
    }//GEN-LAST:event_professorRadioButtonActionPerformed

    private void backbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backbtnActionPerformed
        // TODO add your handling code here:
        homeJPanel.remove(this);
        CardLayout layout = (CardLayout) homeJPanel.getLayout();
        layout.previous(homeJPanel);
    }//GEN-LAST:event_backbtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backbtn;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JRadioButton professorRadioButton;
    private javax.swing.JRadioButton studentRadioButton;
    private javax.swing.ButtonGroup userselectionbtngrp;
    // End of variables declaration//GEN-END:variables

}
