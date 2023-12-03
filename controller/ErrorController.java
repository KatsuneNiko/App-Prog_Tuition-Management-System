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

public class ErrorController extends Controller<InputException>{
    @FXML private Text errorTxt;

    public final InputException getInputException(){
        return model;
    }
    
    @FXML private void initialize(){
        stage.getIcons().add(new Image("view/error.png"));
        errorTxt.setText(model.getMessage());
    }
    
    @FXML private void handleOkay(){
        stage.close();
    }
}
