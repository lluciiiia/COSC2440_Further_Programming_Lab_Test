package com.example.seokyungkim_s3939114.Repository;

import com.example.seokyungkim_s3939114.ConnectionManager;
import com.example.seokyungkim_s3939114.Model.Deliveryman;
import com.example.seokyungkim_s3939114.Request.InsertDeliverymanRequest;
import com.example.seokyungkim_s3939114.Request.UpdateDeliverymanRequest;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DeliverymanRepository {
    private Connection connection;

    public DeliverymanRepository() {
        this.connection = ConnectionManager.getConnection();
    }

    public Deliveryman getDeliverymanById(int id) {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Deliveryman deliveryman = null;

        try {
            String sql = "SELECT * FROM deliverymans WHERE id = ?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String name = resultSet.getString("name");
                String phoneNumber = resultSet.getString("phone_number");
                Date createdAt = resultSet.getDate("created_at");

                deliveryman = new Deliveryman(id, name, phoneNumber, createdAt);
            }
        } catch (SQLException e) {
            System.err.println("Error retrieving deliveryman: " + e.getMessage());
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

        return deliveryman;
    }

    public boolean deleteDeliverymanById(int id) {
        PreparedStatement statement = null;

        try {
            String sql = "DELETE FROM deliverymans WHERE id = ?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, id);

            int rowsDeleted = statement.executeUpdate();
            return rowsDeleted > 0;
        } catch (SQLException e) {
            System.err.println("Error deleting deliveryman: " + e.getMessage());
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

    public void addDeliveryman(InsertDeliverymanRequest request) {
        PreparedStatement statement = null;

        try {
            String sql = "INSERT INTO deliverymans (name, phone_number) VALUES (?, ?)";
            statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, request.getName());
            statement.setString(2, request.getPhoneNumber());

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new deliveryman was inserted successfully!");
            }

        } catch (SQLException e) {
            System.err.println("Error creating deliveryman: " + e.getMessage());
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

    public void updateDeliveryman(UpdateDeliverymanRequest request) {
        PreparedStatement statement = null;

        try {
            String sql = "UPDATE deliverymans SET name = ?, phone_number = ? WHERE id = ?";
            statement = connection.prepareStatement(sql);
            statement.setString(1, request.getName());
            statement.setString(2, request.getPhoneNumber());
            statement.setInt(3, request.getId());

            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Deliveryman with ID " + request.getId() + " was updated successfully!");
            } else {
                System.out.println("No deliveryman found with ID " + request.getId());
            }

        } catch (SQLException e) {
            System.err.println("Error updating deliveryman: " + e.getMessage());
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

    public List<Deliveryman> searchDeliverymansByName(String name) {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Deliveryman> deliverymen = new ArrayList<>();

        try {
            String sql = "SELECT * FROM deliverymans WHERE name LIKE ? ORDER BY name ASC";
            statement = connection.prepareStatement(sql);
            statement.setString(1, "%" + name + "%");
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String deliverymanName = resultSet.getString("name");
                String phoneNumber = resultSet.getString("phone_number");
                Date createdAt = resultSet.getDate("created_at");

                Deliveryman deliveryman = new Deliveryman(id, deliverymanName, phoneNumber, createdAt);
                deliverymen.add(deliveryman);
            }
        } catch (SQLException e) {
            System.err.println("Error searching deliverymen by name: " + e.getMessage());
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

        return deliverymen;
    }
}
