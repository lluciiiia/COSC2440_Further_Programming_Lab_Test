package com.example.seokyungkim_s3939114.Repository;

import com.example.seokyungkim_s3939114.ConnectionManager;
import com.example.seokyungkim_s3939114.Model.Order;
import com.example.seokyungkim_s3939114.Request.InsertOrderRequest;
import com.example.seokyungkim_s3939114.Request.UpdateOrderRequest;

import java.sql.*;

public class OrderRepository {

    private Connection connection;

    public OrderRepository() {
        this.connection = ConnectionManager.getConnection();
    }

    public Order getOrderById(int id) {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Order order = null;

        try {
            String sql = "SELECT * FROM orders WHERE id = ?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                int customerId = resultSet.getInt("customer_id");
                int deliverymanId = resultSet.getInt("deliveryman_id");
                double totalPrice = resultSet.getDouble("total_price");
                Date createdAt = resultSet.getDate("created_at");

                order = new Order(id, customerId, deliverymanId, totalPrice, createdAt);
            }
        } catch (SQLException e) {
            System.err.println("Error retrieving order: " + e.getMessage());
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    System.err.println("Error closing ResultSet: " + e.getMessage());
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    System.err.println("Error closing PreparedStatement: " + e.getMessage());
                }
            }
        }

        return order;
    }

    public boolean deleteOrderById(int id) {
        PreparedStatement statement = null;

        try {
            String sql = "DELETE FROM orders WHERE id = ?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, id);

            int rowsDeleted = statement.executeUpdate();
            return rowsDeleted > 0;
        } catch (SQLException e) {
            System.err.println("Error deleting order: " + e.getMessage());
            return false;
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    System.err.println("Error closing PreparedStatement: " + e.getMessage());
                }
            }
        }
    }

    public void addOrder(InsertOrderRequest order) {
        PreparedStatement statement = null;

        try {
            String sql = "INSERT INTO orders (customer_id, deliveryman_id, total_price) " +
                    "VALUES (?, ?, ?)";
            statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, order.getCustomerId());
            statement.setInt(2, order.getDeliverymanId());
            statement.setDouble(3, order.getTotalPrice());

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new order was inserted successfully!");
            }

        } catch (SQLException e) {
            System.err.println("Error creating order: " + e.getMessage());
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    System.err.println("Error closing PreparedStatement: " + e.getMessage());
                }
            }
        }
    }

    public void updateOrder(UpdateOrderRequest order) {
        PreparedStatement statement = null;

        try {
            String sql = "UPDATE orders SET deliveryman_id = ?, total_price = ? WHERE id = ?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, order.getDeliverymanId());
            statement.setDouble(2, order.getTotalPrice());
            statement.setInt(3, order.getId());

            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Order with ID " + order.getId() + " was updated successfully!");
            } else {
                System.out.println("No order found with ID " + order.getId());
            }

        } catch (SQLException e) {
            System.err.println("Error updating order: " + e.getMessage());
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    System.err.println("Error closing PreparedStatement: " + e.getMessage());
                }
            }
        }
    }
}
