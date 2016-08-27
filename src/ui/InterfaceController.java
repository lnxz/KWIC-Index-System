package ui;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import pipeline.PipeAndFilter;
import shareddata.SharedData;

public class InterfaceController {
    @FXML
    private TextField inputTextField;
    @FXML
    private TextField ignoreTextField;
    @FXML
    private Button inputButton;
    @FXML
    private Button ignoreButton;
    @FXML
    private Button sharedDataButton;
    @FXML
    private Button pipeAndFilterButton;
    @FXML
    private ListView<String> resultsListView;
    
    public InterfaceController() {
    }
    
    @FXML
    private void initialize() {
        
    }
    
    public void setMainApp(MainApp mainApp) {
        final ObservableList<String> resultsList = FXCollections.observableArrayList();
        resultsListView.setItems(resultsList);
        
        inputButton.setOnAction((event) -> {
            FileChooser fileChooser = new FileChooser();
            FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
            fileChooser.getExtensionFilters().add(extFilter);
            File file = fileChooser.showOpenDialog(mainApp.getPrimaryStage());
            if (file != null) {
                inputTextField.setText(file.getPath());
                inputTextField.positionCaret(file.getPath().length());
            }
        });
        
        ignoreButton.setOnAction((event) -> {
            FileChooser fileChooser = new FileChooser();
            FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
            fileChooser.getExtensionFilters().add(extFilter);
            File file = fileChooser.showOpenDialog(mainApp.getPrimaryStage());
            if (file != null) {
                ignoreTextField.setText(file.getPath());
                ignoreTextField.positionCaret(file.getPath().length());
            }
        });
        
        sharedDataButton.setOnAction((event) -> {
            try {
                resultsList.clear();
                
                SharedData sharedData = new SharedData();
                ArrayList<String> results = sharedData.start(inputTextField.getText(), ignoreTextField.getText());
                
                for (String s : results) {
                    resultsList.add(s);
                }
                
                createOutput("sharedDataOutput.txt", results);
            } catch (Exception e) {
                resultsList.clear();
            }
        });
        
        pipeAndFilterButton.setOnAction((event) -> {
            try {
                resultsList.clear();
                
                PipeAndFilter pipeAndFilter = new PipeAndFilter();
                ArrayList<String> results = pipeAndFilter.start(inputTextField.getText(), ignoreTextField.getText());
                
                for (String s : results) {
                    resultsList.add(s);
                }
                
                createOutput("pipeAndFilterOutput.txt", results);
            } catch (Exception e) {
                resultsList.clear();
            }
        });
    }
    
    private void createOutput(String fileName, ArrayList<String> results) {
        try {
            PrintWriter writer = new PrintWriter(fileName);
            for (String result : results) {
                writer.println(result);
            }
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
