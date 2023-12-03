package controller;

import javafx.collections.*;
import javafx.event.*;
import javafx.fxml.*;
import javafx.scene.text.*;
import javafx.scene.control.*;
import javafx.stage.*;
import javafx.application.*;
import javafx.beans.property.*;
import java.io.*;
import au.edu.uts.ap.javafx.*;
import model.*;

public class SessionController extends Controller<Session>{
   public final Session getSession(){
       return model;
   }
   
   @FXML private void initialize() {
       stage.setOnCloseRequest(e -> Platform.exit());
   }

   @FXML private void handleLogin(ActionEvent event) throws Exception {
        ViewLoader.showStage(new Faculties(), "/view/login.fxml", "Sign In", new Stage());
   }
   
   @FXML private void handleExit(ActionEvent event) throws Exception {
       Platform.exit();
   }
}
