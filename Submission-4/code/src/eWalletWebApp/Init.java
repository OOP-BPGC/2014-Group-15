package eWalletWebApp;
/*
 * RUN this class only once for the Project Setup- to create the Database and the Required Tables
 */


import java.sql.*;
public class Init {
	// JDBC driver name and database URL
	   static String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	   static String DB_URL = "jdbc:mysql://localhost/";

	   //  Database credentials
	   static final String USER = "root";
	   static final String PASS = "abhi1204";
	   
	   public static void main(String[] args) {
	   Connection conn = null;
	   Statement stmt = null;
	   try{
		   
	     //CREATE DATABASE
	      Class.forName("com.mysql.jdbc.Driver");
	      System.out.println("Connecting to database...");
	      conn = DriverManager.getConnection(DB_URL, USER, PASS);
	      System.out.println("Creating database...");
	      stmt = conn.createStatement();
	      String sql = "CREATE DATABASE EWALLET";
	      stmt.executeUpdate(sql);
	      System.out.println("Database created successfully...");
	     
	     //CREATE TABLES 
	      DB_URL="jdbc:mysql://localhost/EWALLET";
	      System.out.println("Creating Tables..");
	      conn = DriverManager.getConnection(DB_URL, USER, PASS);
	      stmt = conn.createStatement();
	      stmt.executeUpdate("CREATE TABLE users(firstName varchar(20),lastName varchar(20), userName varchar(50) not NULL, email varchar(50) not NULL,password varchar(50),status varchar(15),balance double)");
	      stmt.executeUpdate("CREATE TABLE transactions(id int primary key auto_increment,sender varchar(20),receiver varchar(20),amount double,date date)");
	      stmt.executeUpdate("CREATE TABLE offers(seller varchar(20),discount int)");
	      System.out.println("Tables successfully created");
	      
	      //creating the virtual bank user
	      stmt.executeUpdate("INSERT into users VALUES('-','-','virtualbank','-','virtualadmin','v',100000)");
	      stmt.close();
	      conn.close();
	   }catch(Exception e){
	      System.out.println("ERROR CREATING DATABASE");
	      e.printStackTrace();
	   }
	   
	}
}
