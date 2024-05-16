/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Librairie;

/**
 *
 * @author OUADI
 */

import java.sql.*;
import javax.swing.JOptionPane;

public class Login extends javax.swing.JFrame {

    public Login() {
        initComponents();
    }

    void log() {
        String userName = user.getText();
        String password = new String(pwd.getPassword()); // Use getPassword() to get the password as a char array

        try {
            Connection connection = DriverManager.getConnection("jdbc:sqlite:data.db"); // Change URL to SQLite

            PreparedStatement st = connection.prepareStatement("SELECT username, password FROM user WHERE username=? AND password=?");

            st.setString(1, userName);
            st.setString(2, password);
            ResultSet rs = st.executeQuery();

           if (rs.next()) {
            dispose();
            LibrairieHome librairieHome = new LibrairieHome(); // Create an instance of LibrairieHome
            librairieHome.setTitle("Librairie"); // Set the title
            librairieHome.setVisible(true); // Make it visible
           } else {
            JOptionPane.showMessageDialog(btn_con, "Veuillez vérifier votre nom d'utilisateur et votre mot de passe");
        }

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }

        user.setText("");
        pwd.setText("");
    }

       public static void main(String args[]) throws Exception {
             
                java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new Login().setVisible(true);
            }
        });
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        jLabel2 = new javax.swing.JLabel();
        pwd = new javax.swing.JPasswordField();
        user = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        buttonMakeOver7 = new komponenMakeOver.buttonMakeOver();
        buttonMakeOver6 = new komponenMakeOver.buttonMakeOver();
        btn_con = new komponenMakeOver.buttonMakeOver();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jDesktopPane1.setBackground(new java.awt.Color(153, 102, 255));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("NOM D'UTILISATER");
        jDesktopPane1.add(jLabel2);
        jLabel2.setBounds(10, 130, 110, 14);

        pwd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pwdActionPerformed(evt);
            }
        });
        jDesktopPane1.add(pwd);
        pwd.setBounds(135, 180, 220, 22);

        user.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userActionPerformed(evt);
            }
        });
        jDesktopPane1.add(user);
        user.setBounds(135, 130, 220, 22);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("MOT DE PASSE");
        jDesktopPane1.add(jLabel3);
        jLabel3.setBounds(20, 180, 100, 14);

        buttonMakeOver7.setForeground(new java.awt.Color(255, 255, 255));
        buttonMakeOver7.setText("Se connecter");
        buttonMakeOver7.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        buttonMakeOver7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonMakeOver7ActionPerformed(evt);
            }
        });
        jDesktopPane1.add(buttonMakeOver7);
        buttonMakeOver7.setBounds(-10, 0, 420, 80);

        buttonMakeOver6.setForeground(new java.awt.Color(255, 255, 255));
        buttonMakeOver6.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jDesktopPane1.add(buttonMakeOver6);
        buttonMakeOver6.setBounds(-10, 70, 480, 10);

        btn_con.setForeground(new java.awt.Color(255, 255, 255));
        btn_con.setText("SE CONNECTER");
        btn_con.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_conActionPerformed(evt);
            }
        });
        jDesktopPane1.add(btn_con);
        btn_con.setBounds(100, 250, 210, 40);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void pwdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pwdActionPerformed
       
    }//GEN-LAST:event_pwdActionPerformed

    private void btn_conActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_conActionPerformed
        log();
    }//GEN-LAST:event_btn_conActionPerformed

    private void buttonMakeOver7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonMakeOver7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonMakeOver7ActionPerformed

    private void userActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_userActionPerformed

  
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private komponenMakeOver.buttonMakeOver btn_con;
    private komponenMakeOver.buttonMakeOver buttonMakeOver6;
    private komponenMakeOver.buttonMakeOver buttonMakeOver7;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPasswordField pwd;
    private javax.swing.JTextField user;
    // End of variables declaration//GEN-END:variables
}
