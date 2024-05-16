/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Librairie;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

/**
 *
 * @author syrin
 */
public class ModifyDialog  extends JDialog{
    
    private javax.swing.JButton btnSave;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtCodeLivre;
    private javax.swing.JTextField txtTitre;
    private javax.swing.JTextField txtAuteur;
    private Connection connection;
    private PreparedStatement pst;
    private Home homePage;


// Updated constructor to accept Connection parameter
    public ModifyDialog(Librairie.Home parent, boolean modal, String codeLivre, String titre, String auteur, java.sql.Connection connection) {
    super(parent, modal);
    initComponents();
    
    // Initialize the connection
    this.connection = connection;
    this.homePage = parent; // Assign the reference to the home page
    
    // Set the text fields with the provided data
    txtCodeLivre.setText(codeLivre);
    txtTitre.setText(titre);
    txtAuteur.setText(auteur);
    
    // Initialize the PreparedStatement
    try {
        pst = connection.prepareStatement(""); // Empty query, just to initialize pst
    } catch (SQLException ex) {
        System.err.println("Error initializing PreparedStatement: " + ex.getMessage());
    }
}
      

    private void initComponents() {
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtCodeLivre = new javax.swing.JTextField();
        txtTitre = new javax.swing.JTextField();
        txtAuteur = new javax.swing.JTextField();
        btnSave = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setText("Code Livre:");

        jLabel2.setText("Titre:");

        jLabel3.setText("Auteur:");

        btnSave.setText("Enregistrer");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtCodeLivre)
                    .addComponent(txtTitre)
                    .addComponent(txtAuteur, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(174, Short.MAX_VALUE)
                .addComponent(btnSave)
                .addGap(161, 161, 161))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtCodeLivre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtTitre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtAuteur, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addComponent(btnSave)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }

 private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {
     // Check if text fields are null
        if (txtCodeLivre == null || txtTitre == null || txtAuteur == null) {
            System.err.println("Text fields are not initialized");
            return;
        }
        
        // Get the modified data from the text fields
        String newCodeLivre = txtCodeLivre.getText();
        String newTitre = txtTitre.getText();
        String newAuteur = txtAuteur.getText();
        
        // Perform any necessary actions with the modified data
        try {
            // Prepare the SQL statement to update the database
            String updateQuery = "UPDATE livres SET titre=?, auteur=? WHERE code_livre=?";
            pst = connection.prepareStatement(updateQuery);
            
            // Set the parameters for the SQL statement
            pst.setString(1, newTitre);
            pst.setString(2, newAuteur);
            pst.setString(3, newCodeLivre);
            
            // Execute the update query
            pst.executeUpdate();
            
            // Inform the user that the data has been successfully updated
            JOptionPane.showMessageDialog(this, "Data updated successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
            // Close the dialog
            dispose();
        } catch (SQLException ex) {
            // Handle any SQL exceptions
            JOptionPane.showMessageDialog(this, "Error updating data: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    
}


    
}
