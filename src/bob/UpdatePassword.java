/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package bob;
import java.awt.Image;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Gungun
 */
public class UpdatePassword extends javax.swing.JPanel {
int userid;
    /**
     * Creates new form UpdatePassword
     */
    public UpdatePassword() {
        initComponents();
           
       ImageIcon imageIcon1 = new ImageIcon(new ImageIcon("C:/Users/Gungun/Documents/NetBeansProjects/bob/src/bob/backgroundimage.jpeg").getImage().getScaledInstance(background.getWidth(),background.getHeight(), Image.SCALE_DEFAULT));
       background.setIcon(imageIcon1);
    }
    public UpdatePassword(int userid) {
       initComponents();
        this.userid=userid;
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        labelc = new javax.swing.JLabel();
        password = new javax.swing.JPasswordField();
        update = new javax.swing.JButton();
        background = new javax.swing.JLabel();

        jDesktopPane1.setBackground(new java.awt.Color(0, 0, 102));
        jDesktopPane1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelc.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        labelc.setForeground(new java.awt.Color(255, 255, 255));
        labelc.setText("Enter your new password:");
        jDesktopPane1.add(labelc, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 6, 360, 40));
        jDesktopPane1.add(password, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 52, 320, 30));

        update.setBackground(new java.awt.Color(51, 51, 51));
        update.setFont(new java.awt.Font("Aharoni", 2, 12)); // NOI18N
        update.setForeground(new java.awt.Color(51, 0, 255));
        update.setText("UPDATE");
        update.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(255, 255, 0)));
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });
        jDesktopPane1.add(update, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, 150, 30));
        jDesktopPane1.add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 390, 180));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 6, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed

        // TODO add your handling code here:
        String pass=String.valueOf(password.getPassword());
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bob","root","Nishi@123456");
            String qry="Update logindetails set password="+pass+" where userid='"+userid+"'";
            PreparedStatement pst=con.prepareStatement(qry);
            if( pst.executeUpdate()==1){
                JOptionPane.showMessageDialog(this,"Your password updated sucessfully" );
            }
        }
        catch(Exception e){
            Errorhandle ee=new Errorhandle();
            ee.setVisible(true);
        }
    }//GEN-LAST:event_updateActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel background;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel labelc;
    private javax.swing.JPasswordField password;
    private javax.swing.JButton update;
    // End of variables declaration//GEN-END:variables
}