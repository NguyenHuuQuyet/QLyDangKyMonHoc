/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Minh Hai
 */
public class ConnectDatabase {
    public Connection conn;
    Statement sta = null;
    ResultSet res = null;
    
    public ConnectDatabase(){
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databasename=DangKyMonHoc_Nhom19;"
            + "username=aaa;password=123;encrypt=false");
            System.out.println("Kết nối thành công");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void excuteSQL(String sql){
        try {
            sta = conn.createStatement();
            sta.executeUpdate(sql);
            System.out.println("Thành công");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
