/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package loginpage;
import static java.lang.Math.random;
import java.nio.charset.Charset;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Random;
import java.util.Scanner;
import bob.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Gungun
 */
public class Loginpage {
    Scanner sc=new Scanner(System.in);
        public boolean login(String username,String pwd){
            try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bob","root","Nishi@123456");
            String qry="Select userid from logindetails where username='"+username+"' and password='"+pwd+"'";
            PreparedStatement pst=con.prepareStatement(qry); 
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
           con.close();
              return true; 
            }
            else{
                con.close();
              return false; 
            }
        }
            catch(Exception e){
                
                System.out.println("Error is in login "+e);
                return false; 
            }
           
        }
        public void signup(String name,String password,String fname,String adhar,int balance,String contact){
              Random random=new Random();
              char u[]=new char[8];
              int i;
              int min=65;
              int max=122;
              for(i=0;i<8;i++)
              {
                  int j=(int)((Math.random()*(max-min))+min);
                     u[i]= (char)j;
              }
              String username=new String(u);
             int accnum=random.nextInt(9999*99999);
             try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bob","root","Nishi@123456");
            String qry="Select * from logindetails where aadhar='"+adhar+"'";
            PreparedStatement pst=con.prepareStatement(qry); 
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
               Createac create=new Createac();
               create.setVisible(true);
             }
            else{
                String qry1="Insert into logindetails(username,password,name,fname,aadhar,balance,accnum,contact_no) values('"+username+"','"+password+"','"+name+"','"+fname+"','"+adhar+"','"+balance+"','"+accnum+"','"+contact+"')";
                 PreparedStatement pst1=con.prepareStatement(qry1); 
                 if(pst1.executeUpdate()==1){
                     Createac cc=new Createac();
                     JOptionPane.showMessageDialog(cc,"Your ACCOUNT created successfully....Thank U \n Your username is : "+username+"  " );
                     Frontwelcomepage wel=new Frontwelcomepage();
                     wel.setVisible(true);
                     
                 }
                 else{
                      Errorhandle ee=new Errorhandle();
                       ee.setVisible(true); 
             
                 }
            }
            con.close();
             }
        
             catch(Exception e){
               
                   Errorhandle ee=new Errorhandle();
           ee.setVisible(true);
}
        }
        public void exitmethod(){
            
        }

    
}

