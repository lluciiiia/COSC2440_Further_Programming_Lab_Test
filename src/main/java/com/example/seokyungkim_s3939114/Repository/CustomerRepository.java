package com.example.seokyungkim_s3939114.Repository;

import com.example.seokyungkim_s3939114.ConnectionManager;
import com.example.seokyungkim_s3939114.Model.Customer;
import com.example.seokyungkim_s3939114.Request.InsertCustomerRequest;
import com.example.seokyungkim_s3939114.Request.UpdateCustomerRequest;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepository {

    private Connection connection;

    public CustomerRepository() {
        this.connection = ConnectionManager.getConnection();
    }

    public Customer getCustomerById(int id) {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Customer customer = null;

        try {
            String sql = "SELECT * FROM customers WHERE id = ?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String name = resultSet.getString("name");
                String address = resultSet.getString("address");
                String phoneNumber = resultSet.getString("phone_number");
                Date createdAt = resultSet.getDate("created_at");

                customer = new Customer(id, name, address, phoneNumber, createdAt);
            }
        } catch (SQLException e) {
            System.err.println("Error retrieving customer: " + e.getMessage());
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

        return customer;
    }

    public boolean deleteCustomerById(int id) {
        PreparedStatement statement = null;

        try {
            String sql = "DELETE FROM customers WHERE id = ?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, id);

            int rowsDeleted = statement.executeUpdate();
            return rowsDeleted > 0;
        } catch (SQLException e) {
            System.err.println("Error deleting customer: " + e.getMessage());
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

    public void addCustomer(InsertCustomerRequest request) {
        PreparedStatement statement = null;

        try {
            String sql = "INSERT INTO customers (name, address, phone_number) " +
                    "VALUES (?, ?, ?)";
            statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, request.getName());
            statement.setString(2, request.getAddress());
            statement.setString(3, request.getPhoneNumber());

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new customer was inserted successfully!");
            }

        } catch (SQLException e) {
            System.err.println("Error creating log: " + e.getMessage());
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

    public void updateCustomer(UpdateCustomerRequest request) {
        PreparedStatement statement = null;

        try {
            String sql = "UPDATE customers SET name = ?, address = ?, phone_number = ? WHERE id = ?";
            statement = connection.prepareStatement(sql);
            statement.setString(1, request.getName());
            statement.setString(2, request.getAddress());
            statement.setString(3, request.getPhoneNumber());
            statement.setInt(4, request.getId());

            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Customer with ID " + request.getId() + " was updated successfully!");
            } else {
                System.out.println("No customer found with ID " + request.getId());
            }

        } catch (SQLException e) {
            System.err.println("Error updating customer: " + e.getMessage());
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

    public List<Customer> searchCustomersByName(String name) {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Customer> customers = new ArrayList<>();

        try {
            String sql = "SELECT * FROM customers WHERE name LIKE ? ORDER BY name ASC";
            statement = connection.prepareStatement(sql);
            statement.setString(1, "%" + name + "%");
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String customerName = resultSet.getString("name");
                String address = resultSet.getString("address");
                String phoneNumber = resultSet.getString("phone_number");
                Date createdAt = resultSet.getDate("created_at");

                Customer customer = new Customer(id, customerName, address, phoneNumber, createdAt);
                customers.add(customer);
            }
        } catch (SQLException e) {
            System.err.println("Error searching for customers by name: " + e.getMessage());
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

        return customers;
    }
}
