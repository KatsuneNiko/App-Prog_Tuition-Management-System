package controller;

import javafx.collections.*;
import javafx.event.*;
import javafx.fxml.*;
import javafx.scene.text.*;
import javafx.scene.control.*;
import javafx.stage.*;
import javafx.beans.property.*;
import java.io.*;
import au.edu.uts.ap.javafx.*;
import javafx.scene.image.Image;
import model.*;

public class LoginController extends Controller<Faculties> {
    @FXML private Label invalidLbl;
    @FXML private TextField emailTf;
    @FXML private PasswordField passwordPf;
    
    public final Faculties getFaculties(){
       return model;
   }
   
   @FXML private void initialize() {
       stage.getIcons().add(new Image("view/book.png"));
   }

   @FXML private void handleOK(ActionEvent event) throws Exception {
        Faculty faculty = model.getFaculty(emailTf.getText(), passwordPf.getText());
        if(faculty != null){
            invalidLbl.setText("");
            emailTf.setText("");
            passwordPf.setText("");
            ViewLoader.showStage(faculty, "/view/faculty.fxml", "Session Admin: " + faculty.getName(), new Stage());
            stage.close();
        }
        else{
            invalidLbl.setText("Invalid login details");
            emailTf.setText("");
            passwordPf.setText("");
        }
   }
   
   @FXML private void handleCancel(ActionEvent event) throws Exception {
       stage.close();
   }
    
}
