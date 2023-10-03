/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package transactions;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Gungun
 */
public class ShowTransactions {
    public void showTransactions(String userid){
     try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bob","root","Nishi@123456");
            String qry="Select * from transaction where userid='"+userid+"'";
            PreparedStatement pst=con.prepareStatement(qry); 
            ResultSet rs = pst.executeQuery(); 
            con.close();
    }
     catch(Exception e){
         
     }
    }
 
}
