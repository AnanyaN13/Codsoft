/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package teacher;
import java.sql.*;
import studentmarksheet.*;
import java.util.Scanner;
/**
 *
 * @author Gungun
 */
public class Login {
    Scanner sc=new Scanner(System.in);
    public Login(){boolean ex=true;
        while( ex){
        System.out.println("choose:"+"\n"+"1.Sign up"+"\n"+"2.Login "+"3.Exit");
        int ch=sc.nextInt();
        if(ch==2){
       System.out.println("Enter username:"); 
       String userid=sc.next();
       System.out.println("Enter password:"); 
    String pwd=sc.next();
   try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/result","root","Nishi@123456");
            String qry="Select teacherid from teacher where userid="+"'"+userid+"' and pwd='"+pwd+"'";
            PreparedStatement pst=con.prepareStatement(qry); 
            ResultSet rs = pst.executeQuery();
             if(rs.next()){
            String teacherid=rs.getString("teacherid");
             Menu menu=new Menu(teacherid);
   }
   else{
       ex=false;
   }
   }catch(Exception e){
       System.out.println(e);
   }
        }
        else if(ch==1){
            System.out.println("Create your account");
            System.out.println("create userid:");
            String userid=sc.next();
            System.out.println("create password:");
            String pwd=sc.next();
            
       
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/result","root","Nishi@123456");
            String qry="Insert into teacher(userid,pwd) values('"+userid+"','"+pwd+"')";
            PreparedStatement pst=con.prepareStatement(qry);
           pst.executeUpdate();
            }
        catch(Exception e){
            System.err.println("ERROR"+e);
        }
        }
        else if(ch==3){
            ex=false;
        } 
        }
    }
    }
