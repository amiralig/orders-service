package com.ellisdon.demo;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws Exception {
        OrderRepository repo = new OrderRepository();
        var orders = repo.findOrdersByCustomer(1);

        System.out.println("Orders found: " + orders.size());
        orders.forEach(o ->
                System.out.println("Order " + o.id + " $" + o.totalAmount)
        );
    }
}