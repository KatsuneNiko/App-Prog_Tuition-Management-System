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

public class StudentController extends Controller<Student>{
    @FXML private TextField nameTf;
    @FXML private TextField emailTf;
    @FXML private TextField phoneTf;
    @FXML private TextField addressTf;
    @FXML private TextField IDTf;
    @FXML private TextField typeTf;
    @FXML private TextField creditsTf;
    @FXML private TextField scholarshipTf;
    @FXML private TextField deductionTf;
    @FXML private Button addBtn;
    @FXML private Button updateBtn;
    
    public final Student getStudent(){
        return model;
    }
    
    @FXML private void initialize(){
        stage.getIcons().add(new Image("view/edit.png"));
        nameTf.setText(model.getName());
        emailTf.setText(model.getEmail());
        phoneTf.setText(model.getPhone());
        addressTf.setText(model.getAddress());
        IDTf.setText(model.getID());
        typeTf.setText(model.getType());
        creditsTf.setText(String.valueOf(model.getCredits()));
        scholarshipTf.setText(String.valueOf(model.getScholarship()));
        if (model.getName() == "" && model.getEmail() == "" && model.getPhone() == "" && model.getAddress() == ""){
            addBtn.setDisable(false);
        }
        else{
            updateBtn.setDisable(false);
            deductionTf.textProperty().bind(model.deductionProperty().asString());
        }
    }
    
    @FXML private void handleAdd() throws Exception{
        Validator validator = new Validator();
        Boolean isValid = validator.isValid(nameTf.getText(), emailTf.getText(), phoneTf.getText(), addressTf.getText(), typeTf.getText(), IDTf.getText(), getCredits(), getScholarship());
        if(isValid){
            model.updateDetails(nameTf.getText(), emailTf.getText(), phoneTf.getText(), addressTf.getText(), IDTf.getText(), typeTf.getText(), getCredits(), getScholarship(), deductionTf.getText());
            model.getFaculty().addStudent(model);
            stage.close();
        }
        else{
            generateErrors(validator);
        }
    }
    
    @FXML private void handleUpdate() throws Exception{
        Validator validator = new Validator();
        Boolean isValid = validator.isValid(nameTf.getText(), emailTf.getText(), phoneTf.getText(), addressTf.getText(), typeTf.getText(), IDTf.getText(), getCredits(), getScholarship());
        if(isValid){
            String deductionCode = "";
            if(model.getDeduction() > 0){
                deductionCode = "2022AUT";
            }
            model.updateDetails(nameTf.getText(), emailTf.getText(), phoneTf.getText(), addressTf.getText(), IDTf.getText(), typeTf.getText(), getCredits(), getScholarship(), deductionCode);
            stage.close();
        }
        else{
            System.out.println("Student is not valid.");
            generateErrors(validator);
        }
    }
    
    private int getCredits(){
        try {
            return Integer.parseInt(creditsTf.getText());
        }
        catch (NumberFormatException e){
            return -1;
        }
    }
    
    private double getScholarship(){
        try {
            return Double.parseDouble(scholarshipTf.getText());
        }
        catch (NumberFormatException e){
            return -1;
        }
    }
    
    @FXML private void handleClose(){
        stage.close();
    }
    
    private void generateErrors(Validator validator) throws Exception{
        validator.generateErrors(nameTf.getText(), emailTf.getText(), phoneTf.getText(), addressTf.getText(), typeTf.getText(), IDTf.getText(), getCredits(), getScholarship());
        String temp = "";
        for (String error : validator.errors()){
            temp += error;
        }
        ViewLoader.showStage(new InputException(temp), "/view/error.fxml", "Input Exceptions", new Stage());
    }
}
