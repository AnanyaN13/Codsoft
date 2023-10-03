/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bob;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Gungun
 */
public class Balance {
     public int balanceam(String username,String pwd){
         int bal;
       try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bob","root","Nishi@123456");
            String qry="Select balance from logindetails where username='"+username+"' and password='"+pwd+"'";
            PreparedStatement pst=con.prepareStatement(qry); 
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                bal=rs.getInt("balance");
                return bal;
            }
            else{
               return 0;
            }  
}
       catch(Exception e){
         return 0;   
       }
     }
}