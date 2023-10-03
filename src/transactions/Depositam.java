/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package transactions;
import bob.*;
import bob.Errorhandle;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author Gungun
 */
public class Depositam {
    public Depositam(String username,int amountc,String pwd){
        int userid=0;
         try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bob","root","Nishi@123456");
            String qry="Select userid from logindetails where username='"+username+"'";
            PreparedStatement pst=con.prepareStatement(qry); 
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                userid=rs.getInt("userid");
            }
            else{
                    Errorhandle ee=new Errorhandle();
           ee.setVisible(true);
            }con.close();
         }
         catch(Exception e){
               Errorhandle ee=new Errorhandle();
           ee.setVisible(true);  
         }
        int balance=0;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bob","root","Nishi@123456");
            String qry2="Select balance from logindetails where userid='"+userid+"'";
            PreparedStatement pst=con.prepareStatement(qry2); 
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                balance=rs.getInt("balance")+amountc;
                con.close();
            }
      
           try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con1=DriverManager.getConnection("jdbc:mysql://localhost:3306/bob","root","Nishi@123456"); 
            String qry1="Insert into transaction(userid,amount,balance,t_type,this_date) values ('"+userid+"','"+amountc+"','"+balance+"','cred','"+java.time.LocalDate.now()+"')";
               PreparedStatement pst1=con1.prepareStatement(qry1); 
               pst1.executeUpdate();
               
               try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con2=DriverManager.getConnection("jdbc:mysql://localhost:3306/bob","root","Nishi@123456"); 
            String qry3="Update logindetails set balance="+balance+" where userid='"+userid+"'";
               PreparedStatement pst2=con2.prepareStatement(qry3); 
               pst2.executeUpdate();
               con2.close();
            }
        catch(Exception e){
             Errorhandle ee=new Errorhandle();
           ee.setVisible(true);   
        }
               con1.close();
        }
        catch(Exception e){
             Errorhandle ee=new Errorhandle();
           ee.setVisible(true);   
        }
        }
        catch(Exception e){
                Errorhandle ee=new Errorhandle();
           ee.setVisible(true);
        }
    }
}

