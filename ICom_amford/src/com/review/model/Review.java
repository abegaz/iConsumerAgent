package com.review.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class Review {

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    String Username, Password, Email;

    // This method  implements PreparedStatement properly.
    public int addSubribtionToDatabase() {
        int affectedRow=0;
        String query = "insert into IComReview" + "(category, title, description, link)"
                + "values(?,?,?)";

        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement sqlStatement = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);) {
            sqlStatement.setString(1, getUsername());
            sqlStatement.setString(2, getPassword());
            sqlStatement.setString(3, getEmail());



            // get the number of return rows
            affectedRow = sqlStatement.executeUpdate();

        } catch (Exception e) {
            System.out.println("Status: operation failed due to " + e);

        }
        return affectedRow;

    }


}
