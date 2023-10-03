/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package transactions;

import bob.Errorhandle;
import bob.QuickTransfer;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author Gungun
 */
public class DirectTransfer {
     String tousername;
          String topwd;
        
         
    public DirectTransfer(String fromusername,String frompwd,String tou,int amount){
           
         try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bob","root","Nishi@123456");
            String qry="Select * from logindetails where contact_no ='"+tou+"'";
            PreparedStatement pst=con.prepareStatement(qry); 
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                this.tousername=rs.getString("username");
                this.topwd=rs.getString("password");
            }
            else{
                    Errorhandle ee=new Errorhandle();
           ee.setVisible(true);
            }
            con.close();
         }
         catch(Exception e){
               Errorhandle ee=new Errorhandle();
           ee.setVisible(true);  
         }
         
      Debited db=new Debited(fromusername,amount,frompwd);
      Depositam dp=new Depositam(this.tousername,amount,this.topwd);   
    }
}
