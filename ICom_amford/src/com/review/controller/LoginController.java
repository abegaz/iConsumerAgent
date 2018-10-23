package com.review.controller;


import com.review.model.DatabaseConfig;
import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.fxml.Initializable;
import javafx.stage.Stage;
import javafx.util.Duration;


import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;



public class LoginController implements Initializable {



    @FXML
    ImageView progress;
    @FXML
    Button Login, SignUp;
    @FXML
    CheckBox RememberMe;
    @FXML
    TextField txtUsername;
    @FXML
    PasswordField txtPassword;





    @Override
    public void initialize(URL arg0, ResourceBundle rb) {

    }

    @FXML
    public void LoginUser(ActionEvent actionEvent) throws SQLException, IOException {



        //Pulls from the database to login user
         Connection conn = DatabaseConfig.getConnection();
         PreparedStatement ps = null;
         ResultSet rs = null;

        String userName = txtUsername.getText().trim();
        String password = txtPassword.getText().trim();

        String sql = "SELECT * From userinfo WHERE username = ? AND password = ?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, userName);
            ps.setString(2, password);
            rs = ps.executeQuery();

            if (rs.next()) {
                Login.getScene().getWindow().hide();

                Stage SignUp = new Stage();
                Parent root = FXMLLoader.load(getClass().getResource("/com/review/view/Home.fxml"));
                Scene scene = new Scene(root);
                SignUp.setScene(scene);
                SignUp.show();
                SignUp.setResizable(false);
            } else {
                wrongInputFXML();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void wrongInputFXML() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(
                "/com/review/view/WrongInput.fxml"));
        Stage errorStage = new Stage();
        errorStage.setScene(new Scene(root));
        errorStage.setTitle("Error");
        errorStage.centerOnScreen();
        errorStage.show();
    }

            //button "Sign Up", when clicked changes the view to SignUP.fxml
            @FXML
            public void SignUpUser (ActionEvent actionEvent) throws IOException {

                Login.getScene().getWindow().hide();

                Stage SignUp = new Stage();
                Parent root = FXMLLoader.load(getClass().getResource("/com/review/view/SignUp.fxml"));
                Scene scene = new Scene(root);
                SignUp.setScene(scene);
                SignUp.show();
                SignUp.setResizable(false);


            }

        }

