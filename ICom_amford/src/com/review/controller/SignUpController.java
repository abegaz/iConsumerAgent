package com.review.controller;


import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SignUpController implements Initializable {

    @FXML
    TextField txtUser, txtEmail;
    @FXML
    PasswordField txtPass;
    @FXML
    Button SignUp, login;
    @FXML
    ImageView progress;


    @Override
    public void initialize (URL arg0, ResourceBundle arg1) {

        progress.setVisible(false);

    }

    @FXML
    public void SignUpUser(ActionEvent actionEvent) {

        progress.setVisible(true);
        PauseTransition pt = new PauseTransition();
        pt.setDuration(Duration.seconds(3));
        pt.setOnFinished(ev ->{
            System.out.print("Sign Up succesful");
        });
        pt.play();
    }

    public void UserLogin(ActionEvent actionEvent) {

        SignUp.getScene().getWindow().hide();

        Stage SignUp = new Stage();
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("/Com/Review/view/UserLogin.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scene scene = new Scene(root);
        SignUp.setScene(scene);
        SignUp.show();
        SignUp.setResizable(false);

    }
}
