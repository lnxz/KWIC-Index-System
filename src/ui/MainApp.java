package ui;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;

public class MainApp extends Application {
    
    private Stage primaryStage;
    
	@Override
	public void start(Stage primaryStage) {
	    this.primaryStage = primaryStage;
        this.primaryStage.setTitle("A1_A0125497W_A0134234R");

        initRootLayout();
	}
	
	/**
     * Initializes the root layout.
     */
    public void initRootLayout() {
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("Interface.fxml"));
            AnchorPane ui = (AnchorPane) loader.load();
            
            // Show the scene containing the ui.
            Scene scene = new Scene(ui);
            primaryStage.setScene(scene);
            primaryStage.show();
            
            InterfaceController controller = loader.getController();
            controller.setMainApp(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Returns the main stage.
     * @return
     */
    public Stage getPrimaryStage() {
        return primaryStage;
    }
    
	public static void main(String[] args) {
		launch(args);
	}
}
