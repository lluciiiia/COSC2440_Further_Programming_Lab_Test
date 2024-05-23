package com.example.seokyungkim_s3939114.Repository;

import com.example.seokyungkim_s3939114.ConnectionManager;
import com.example.seokyungkim_s3939114.Model.Item;
import com.example.seokyungkim_s3939114.Request.InsertItemRequest;
import com.example.seokyungkim_s3939114.Request.UpdateItemRequest;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ItemRepository {

    private Connection connection;

    public ItemRepository() {
        this.connection = ConnectionManager.getConnection();
    }

    public Item getItemById(int id) {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Item item = null;

        try {
            String sql = "SELECT * FROM items WHERE id = ?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String name = resultSet.getString("name");
                double price = resultSet.getDouble("price");
                Date createdAt = resultSet.getDate("created_at");

                item = new Item(id, name, price, createdAt);
            }
        } catch (SQLException e) {
            System.err.println("Error retrieving item: " + e.getMessage());
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

        return item;
    }

    public boolean deleteItemById(int id) {
        PreparedStatement statement = null;

        try {
            String sql = "DELETE FROM items WHERE id = ?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, id);

            int rowsDeleted = statement.executeUpdate();
            return rowsDeleted > 0;
        } catch (SQLException e) {
            System.err.println("Error deleting item: " + e.getMessage());
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

    public void addItem(InsertItemRequest request) {
        PreparedStatement statement = null;

        try {
            String sql = "INSERT INTO items (name, price) VALUES (?, ?)";
            statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, request.getName());
            statement.setDouble(2, request.getPrice());

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new item was inserted successfully!");
            }
        } catch (SQLException e) {
            System.err.println("Error creating item: " + e.getMessage());
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

    public void updateItem(UpdateItemRequest request) {
        PreparedStatement statement = null;

        try {
            String sql = "UPDATE items SET name = ?, price = ? WHERE id = ?";
            statement = connection.prepareStatement(sql);
            statement.setString(1, request.getName());
            statement.setDouble(2, request.getPrice());
            statement.setInt(3, request.getId());

            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Item with ID " + request.getId() + " was updated successfully!");
            } else {
                System.out.println("No item found with ID " + request.getId());
            }
        } catch (SQLException e) {
            System.err.println("Error updating item: " + e.getMessage());
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

    public List<Item> searchItemsByName(String name) {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Item> items = new ArrayList<>();

        try {
            String sql = "SELECT * FROM items WHERE name LIKE ? ORDER BY name ASC";
            statement = connection.prepareStatement(sql);
            statement.setString(1, "%" + name + "%");
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String itemName = resultSet.getString("name");
                double price = resultSet.getDouble("price");
                Date createdAt = resultSet.getDate("created_at");

                Item item = new Item(id, itemName, price, createdAt);
                items.add(item);
            }
        } catch (SQLException e) {
            System.err.println("Error searching items by name: " + e.getMessage());
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

        return items;
    }
}
