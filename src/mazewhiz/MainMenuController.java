/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mazewhiz;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author chasealexander
 */
public class MainMenuController implements Initializable {
    
    @FXML
    private Button exitButton;
    
    @FXML
    private Button startButton;
    
    @FXML
    private Button editorButton;
    
    @FXML
    public void exitScreen(ActionEvent event) {
            Stage stage = (Stage) exitButton.getScene().getWindow();
            stage.close();
    }
    
    @FXML
    public void startGame(ActionEvent event) throws Exception {
        Stage oldStage = (Stage) startButton.getScene().getWindow();
        oldStage.close();
        
        Stage newStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("GameInterface.fxml"));
        newStage.setTitle("MazeWhiz");
        
        Scene scene = new Scene(root);
        scene.getRoot().requestFocus();       
        newStage.setScene(scene);
        newStage.show();
    }
    
    @FXML
    public void openEditor(ActionEvent event) throws Exception {
        Stage oldStage = (Stage) editorButton.getScene().getWindow();
        oldStage.close();
        
        Stage newStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("EditorInterface.fxml"));
        newStage.setTitle("MazeWhiz");
        
        Scene scene = new Scene(root);
        scene.getRoot().requestFocus();       
        newStage.setScene(scene);
        newStage.show();
    }
    
    @FXML
    public void openAboutMenu(ActionEvent event) throws Exception {
        Stage newStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("AboutMenu.fxml"));
                
        Scene scene = new Scene(root);
        newStage.initStyle(StageStyle.TRANSPARENT); 
        scene.setFill(Color.TRANSPARENT);       
        newStage.setScene(scene);
        newStage.show();
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

     
    }
    
}
