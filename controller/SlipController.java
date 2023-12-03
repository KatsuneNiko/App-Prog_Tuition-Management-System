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

public class SlipController extends Controller<Student> {
    @FXML private Text creditsTxt;
    @FXML private Text totalFeeTxt;
    @FXML private Text netFeeTxt;
    @FXML private Text payPerCreditTxt;
    @FXML private Text scholarshipTxt;
    @FXML private Text deductionTxt;
    
    public final Student getStudent(){
        return model;
    }
    
    @FXML private void initialize(){
        stage.getIcons().add(new Image("view/edit.png"));
        creditsTxt.textProperty().bind(model.creditsProperty().asString().concat(" credits"));
        totalFeeTxt.textProperty().bind(model.totalFeeProperty().asString("$%.2f"));
        netFeeTxt.textProperty().bind(model.netFeeProperty().asString("$%.2f"));
        payPerCreditTxt.textProperty().bind(model.payPerCreditProperty().asString("$%.2f"));
        scholarshipTxt.textProperty().bind(model.scholarshipProperty().asString("$%.2f"));
        deductionTxt.textProperty().bind(model.deductionProperty().asString("$%.2f"));
    }
    
    @FXML private void handleClose(){
        stage.close();
    }
}
