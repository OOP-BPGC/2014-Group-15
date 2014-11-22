package eWalletWebApp;
/*
 * Copyright 2004-2013 H2 Group. Multiple-Licensed under the H2 License,
 * Version 1.0, and under the Eclipse Public License, Version 1.0
 * (http://h2database.com/html/license.html).
 * Initial Developer: H2 Group
 */


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;



/**
 * A very simple class that shows how to load the driver, create a database,
 * create a table, and insert some data.
 */
public class CreateDB {

    /**
     * Called when ran from command line.
     *
     * @param args ignored
     */
    public static void main(String... args) throws Exception {
        // delete the database named 'STUDENT' in the user home directory
       // DeleteDbFiles.execute("~", "STUDENT", true);

        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/eWallet","root","");   
        Statement stat = conn.createStatement();

        // this line would initialize the database
        // from the SQL script file 'init.sql'
        // stat.execute("runscript from 'init.sql'");

        stat.execute("create table USER(firstName  varchar(25), lastName  varchar(25), email  varchar(50),userName  varchar(25) primary key, password varchar(30))");
//        stat.execute("insert into USER values('a', 'a','a', 'a','a')");
//        ResultSet rs;
//        rs = stat.executeQuery("select * from USER");
//        while (rs.next()) {
//            System.out.println(rs.getString("userName"));
//        }
        stat.close();
        conn.close();
    }

}