package com.ellisdon.demo;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbTest {

    public static void main(String[] args) throws Exception {
        String url = "jdbc:sqlite:orders.db";
        Connection conn = DriverManager.getConnection(url);
        System.out.println("Connected to SQLite!");
        conn.close();
    }
}
