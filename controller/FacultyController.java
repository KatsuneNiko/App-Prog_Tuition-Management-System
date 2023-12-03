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

public class FacultyController extends Controller<Faculty> {
    @FXML private TableView<Student> studentTv;
    @FXML private TextField nameTf;
    @FXML private TextField emailTf;
    @FXML private Button addBtn;
    @FXML private Button deleteBtn;
    @FXML private Button selectBtn;
    @FXML private Button slipBtn;
    @FXML private Button reportBtn;
    @FXML private Button closeBtn;
    
    
    public final Faculty getFaculty(){
        return model;
    }
    
    @FXML private void initialize() {
       stage.getIcons().add(new Image("view/faculty.png"));
       studentTv.getSelectionModel().selectedItemProperty().addListener(
            (observable, oldStudents, newStudents) -> {
                deleteBtn.setDisable(newStudents == null);
                selectBtn.setDisable(newStudents == null);
                slipBtn.setDisable(newStudents == null);
            }
       );
       
       nameTf.textProperty().addListener(
            (observable, oldText, newText) ->{
                model.filterList(nameTf.getText(), "~");

            }
       );
       
       emailTf.textProperty().addListener(
            (observable, oldText, newText) ->{
                    model.filterList("~", emailTf.getText());
            }
       );
   }
    
    @FXML private void handleAdd(ActionEvent event) throws Exception {
        Student student = new Student("", "", "", "", "", "", 0, 0.0, "");
        student.setFaculty(model);
        ViewLoader.showStage(student, "/view/student.fxml", "Adding New Student", new Stage());
   }
    
    @FXML private void handleDelete(ActionEvent event) throws Exception {
        model.removeStudent(studentTv.getSelectionModel().getSelectedItem());
        studentTv.getSelectionModel().clearSelection();
   }
    
    @FXML private void handleSelect(ActionEvent event) throws Exception {
        Student student = studentTv.getSelectionModel().getSelectedItem();
        student.setFaculty(model);
        ViewLoader.showStage(student, "/view/student.fxml", "Accessing File: " + student.getName(), new Stage());
        studentTv.getSelectionModel().clearSelection();
   }
    
    @FXML private void handleSlip(ActionEvent event) throws Exception {
        Student student = studentTv.getSelectionModel().getSelectedItem();
        ViewLoader.showStage(student, "/view/slip.fxml", student.getName() + " SLIP Report", new Stage());
        studentTv.getSelectionModel().clearSelection();
   }
    
    @FXML private void handleReport(ActionEvent event) throws Exception {
        ViewLoader.showStage(new TMS(model), "/view/tms.fxml", "TMS Report", new Stage());
   }
    
    @FXML private void handleClose(ActionEvent event) throws Exception {
       stage.close();
   }
}
