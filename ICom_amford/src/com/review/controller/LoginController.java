package com.review.controller;


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
    public void initialize(URL arg0, ResourceBundle arg1) {

        progress.setVisible(false);
    }

    public void LoginUser(ActionEvent actionEvent) {
        progress.setVisible(true);
        PauseTransition pt = new PauseTransition();
        pt.setDuration(Duration.seconds(5));
        pt.setOnFinished(ev -> {

            System.out.print("Login Succesful");
        });

        pt.play();
    }

    @FXML
    public void SignUpUser(ActionEvent actionEvent) throws IOException {

        Login.getScene().getWindow().hide();

        Stage SignUp = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/com/review/view/SignUp.fxml"));
        Scene scene = new Scene(root);
        SignUp.setScene(scene);
        SignUp.show();
        SignUp.setResizable(false);



    }

}
