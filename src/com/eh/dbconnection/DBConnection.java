package com.eh.dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Md. Emran Hossain
 */
public class DBConnection {

    Connection con = null;
    static final String url = "jdbc:mysql://localhost:3306/";
//  it's MySql driver class, make sure MySql JDBC Driver libery add in class path
    static final String driver = "com.mysql.jdbc.Driver";
//    ==============user can chage this vareable value as there need======================
    static final String dbName = "cable_management";//user database name or schema name
    static final String dbUserName = "root";//user database user name 
    static final String dbPassword = "root";//user database password
    
    
    
//    static final String url = "jdbc:mysql://sql12.freemysqlhosting.net:3306/";
//    static final String driver = "com.mysql.jdbc.Driver";
//    static final String dbName = "sql12230506";//user database name or schema name
//    static final String dbUserName = "sql12230506";//user database user name 
//    static final String dbPassword = "EjCAmbUUrf";//user database password

    public Connection myConn() throws SQLException {

        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url + dbName, dbUserName, dbPassword);
            return con;//it return connection
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
        return null;
    }
}
