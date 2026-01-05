package com.ellisdon.demo;

import com.ellisdon.demo.dto.Order;

import java.sql.*;
import java.util.*;

public class OrderRepository {

    private static final String DB_URL = "jdbc:sqlite:orders.db";

    public List<Order> findOrdersByCustomer(long customerId) throws Exception {
        List<Order> orders = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement ps =
                     conn.prepareStatement("SELECT * FROM orders WHERE customer_id = ?")) {

            ps.setLong(1, customerId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Order o = new Order();
                o.id = rs.getLong("id");
                o.customerId = rs.getLong("customer_id");
                o.totalAmount = rs.getDouble("total_amount");
                o.createdAt = rs.getString("created_at");
                orders.add(o);
            }
        }
        return orders;
    }
}
