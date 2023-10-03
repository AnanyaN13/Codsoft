/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

    package studentmarksheet;
import static java.lang.Integer.parseInt;
import java.sql.*;
import java.util.Scanner;
    import teacher.*;


/**
 *
 * @author Gungun
 */public class Menu{

    public Menu(String teacherid) {
        // TODO code application logic here
        Scanner sc=new Scanner(System.in);
        System.out.println("*****MENU******");
         System.out.println("1.Show student marksheet");
          System.out.println("2.Insert student marksheet");
          System.out.println("3.Delete student marksheet");
          System.out.println("4.Exit");
          System.out.println("Choose from menu:");
          int ch=sc.nextInt();
          switch(ch){
              case(1)->{
           
         try{
           Class.forName("com.mysql.jdbc.Driver");
           Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/result","root","Nishi@123456");
           String qry="SELECT * from result_marksheet where teacherid='"+teacherid+"'";
           PreparedStatement pst=con.prepareStatement(qry);
           ResultSet rs = pst.executeQuery();
           while(rs.next()){
               
               System.out.println(rs.getString("student_name") );
               System.out.println(rs.getInt("english"));
               System.out.println(rs.getString("hindi"));
               System.out.println(rs.getString("maths"));
               System.out.println(rs.getString("science"));
               System.out.println(rs.getString("sst"));
               System.out.println(rs.getString("teacherid"));
               String subarr[]={"english","hindi","maths","science","sst"};
               
               int marks=0;
               for(int i=0;i<5;i++){
                   marks+=parseInt(rs.getString(subarr[i]));
               }
               System.out.println("Grade is "+grade(marks/5));

               
           }
       }
   
catch(Exception e){
    System.out.println(e);
}
   }
       case(2)->{
          
        System.out.println("Enter name:");
        String name=sc.next();
        System.out.println("Enter english marks:");
        int  english=sc.nextInt();
       System.out.println("Enter hindi marks:");
        int  hindi=sc.nextInt();
        System.out.println("Enter science marks:");
        int  science=sc.nextInt();
        System.out.println("Enter sst marks:");
        int  sst=sc.nextInt();
        System.out.println("Enter maths marks:");
        int  maths=sc.nextInt();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/result","root","Nishi@123456");
            String qry="Insert into result_marksheet values(?,?,?,?,?,?,?)";
            PreparedStatement pst=con.prepareStatement(qry);
            pst.setString(1, name);
            pst.setInt(2,english);
            pst.setInt(3, hindi);
            pst.setInt(4, maths);
            pst.setInt(5, science);
            pst.setInt(6, sst);
            pst.setString(7,teacherid);
            pst.executeUpdate();
        }
        catch(Exception e){
            System.out.println("ERROR "+e);
        }
    }
       case(3)->{
           System.out.println("Enter name u have to delete:");
        String name=sc.next();
        try{
                Class.forName("com.mysql.jdbc.Driver");
           Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/result","root","Nishi@123456");
           String qry="Delete from result_marksheet where student_name='"+name+"'";
           PreparedStatement pst=con.prepareStatement(qry);
           pst.executeUpdate();
        }
        catch(Exception e){
            System.err.println(e);
        }
        
       }
       case (4)->{
           Login lg=new Login();
       }
       default ->{
           System.err.println("You entered wrong details...");
           Login lg=new Login();
       }
          }
    }
    public String grade(int marks){
        String grad="";
        if(marks>=90 && marks<=100){
           grad="A+" ;
        }
        else if(marks>=80 && marks<=89){
           grad="A" ;
        }
        else if(marks>=70 && marks<=79){
           grad="B" ;
        }
        else if(marks>=60 && marks<=69){
           grad="C" ;
        }
        else if(marks>=50 && marks<=59){
           grad="D" ;
        }
        else if(marks>=40 && marks<=49){
           grad="E" ;
        }
        else if(marks>=30 && marks<=39){
           grad="F" ;
        }
      return grad;  
    }
 }
   
