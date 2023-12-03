package controller;

import javafx.collections.*;
import javafx.event.*;
import javafx.fxml.*;
import javafx.scene.text.*;
import javafx.scene.control.*;
import javafx.application.*;
import javafx.stage.*;
import javafx.beans.property.*;
import java.io.*;
import au.edu.uts.ap.javafx.*;
import javafx.scene.image.Image;
import model.*;

public class TMSController extends Controller<TMS> {
    @FXML private TableView<Report> reportsTv;
    @FXML private TableColumn<Report, String> tuitionClm;
    @FXML private TableColumn<Report, String> scholarshipClm;
    @FXML private TableColumn<Report, String> deductionClm;
    @FXML private TableColumn<Report, String> netFeeClm;
    @FXML private Text totalTuitionTxt;
    @FXML private Text totalNetFeeTxt;
    @FXML private Text totalBASTxt;
    @FXML private Text totalScholarshipTxt;
    @FXML private Text totalDeductionTxt;
    
    public final TMS getTMS(){
        return model;
    }
    
    @FXML private void initialize(){
        stage.getIcons().add(new Image("view/uts.jpeg"));
        reportsTv.setItems(model.reports());
        tuitionClm.setCellValueFactory(cellData -> cellData.getValue().totalFeeProperty().asString("$%.2f"));
        scholarshipClm.setCellValueFactory(cellData -> cellData.getValue().scholarshipProperty().asString("$%.2f"));
        deductionClm.setCellValueFactory(cellData -> cellData.getValue().deductionProperty().asString("$%.2f"));
        netFeeClm.setCellValueFactory(cellData -> cellData.getValue().netFeeProperty().asString("$%.2f"));
        totalTuitionTxt.textProperty().bind(model.totalTuitionFeeProperty().asString("$%.2f"));
        totalNetFeeTxt.textProperty().bind(model.totalNetFeeProperty().asString("$%.2f"));
        totalBASTxt.textProperty().bind(model.basProperty().asString("$%.2f"));
        totalScholarshipTxt.textProperty().bind(model.totalScholarshipProperty().asString("$%.2f"));
        totalDeductionTxt.textProperty().bind(model.totalDeductionProperty().asString("$%.2f"));
    }
    
    @FXML private void handleClose(){
        stage.close();
    }
}
