package com.ellisdon.demo.mcp;

// File: MCPServer.java
import static spark.Spark.*;
import java.sql.*;

public class MCPServer {
    public static void main(String[] args) {
        port(8080);

        get("/query", (req, res) -> {
            String sql = req.queryParams("q");
            try (Connection conn = DriverManager.getConnection("jdbc:sqlite:orders.db")) {
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                StringBuilder sb = new StringBuilder();
                ResultSetMetaData meta = rs.getMetaData();
                int cols = meta.getColumnCount();
                while (rs.next()) {
                    for (int i = 1; i <= cols; i++) {
                        sb.append(meta.getColumnName(i)).append(": ").append(rs.getString(i)).append(", ");
                    }
                    sb.append("\n");
                }
                return sb.toString();
            }
        });

        System.out.println("Orders MCP server running on http://localhost:8080");
    }
}
