/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mazewhiz;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author chasealexander
 */
public class EditorInterfaceController implements Initializable {

    @FXML
    private AnchorPane tilePane;
    
    @FXML
    private Button saveButton;
    
    @FXML
    private Button openButton;
    
    @FXML
    private Label sizeLabel;
    
    private Tile[][] tileMap;
    
    private EditorNavigator tileEditor;
    
    private MazeNavigator mazeNavigator;
    
    private int mapSize;
    
    private boolean editMode = true;
    
    private String currentMap = "maze0.txt";

    
    @FXML
    public void handleKeyPress(KeyEvent event) {
        switch(event.getCode()) {
            case W:
                if (editMode == true) {
                    tileEditor.moveUp();
                }
                else {
                    mazeNavigator.moveUp();
                }
                break;
            case S:
                if (editMode == true) {
                    tileEditor.moveDown();
                }
                else {
                    mazeNavigator.moveDown();
                }
                break;
            case A:
                if (editMode == true) {
                    tileEditor.moveLeft();
                }    
                else {
                    mazeNavigator.moveLeft();
                }
                break;
            case D:
                if (editMode == true) {
                    tileEditor.moveRight();
                }
                else {
                    mazeNavigator.moveRight();
                }
                break;
            case SPACE:
                if (editMode == true) {
                    tileEditor.changeSelection();
                }
            default:
                break;
        }
    }
    
    @FXML
    public void playMap(ActionEvent event) {
        editMode = false;
        MazeBuilder myMaze = new MazeBuilder("./mazes/" + currentMap, tilePane);
        myMaze.constructMap();
        tileMap = myMaze.getTileMap();

        MazeNavigator myNav = new MazeNavigator(tileMap, tilePane, myMaze.getStartRow(), myMaze.getStartColumn()); 
        mazeNavigator = myNav;
        tileMap = myNav.getTileMap();
        
        tilePane.requestFocus();
    }
    
    @FXML
    public void saveFile(ActionEvent event) {
        if (editMode == true) {

            Stage myStage = (Stage) saveButton.getScene().getWindow();

            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Save Maze");
            String currentPath = Paths.get("./mazes/").toAbsolutePath().normalize().toString();
            fileChooser.setInitialDirectory(new File(currentPath));
            File file = fileChooser.showSaveDialog(myStage);

            fileChooser.setInitialDirectory(new File("./mazes/"));
            if (file != null) {
                currentMap = file.getName();
                try {
                    FileWriter fileWriter = null;

                    fileWriter = new FileWriter(file);
                    String size = sizeLabel.getText();
                    fileWriter.write(size); 
                    fileWriter.write("\n");

                    mapSize = Integer.parseInt(size);

                    for (int i=0; i<mapSize; i++) { 
                        for (int j=0; j<mapSize; j++) {
                            if (tileMap[i][j].getType() <= 3) {
                                fileWriter.write(Integer.toString(tileMap[i][j].getType()));
                            }
                            else {
                                fileWriter.write(Integer.toString(tileMap[i][j].getType()-4));                            
                            }
                        }
                        fileWriter.write("\n");
                    }    
                    fileWriter.close();
                } catch (IOException ex) {
                    Logger.getLogger(EditorInterfaceController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            editMode = true;
            tilePane.requestFocus();
        }
    }
    
    @FXML
    public void openFile(ActionEvent event) {
        Stage myStage = (Stage) openButton.getScene().getWindow();
        
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Maze");
        String currentPath = Paths.get("./mazes/").toAbsolutePath().normalize().toString();
        fileChooser.setInitialDirectory(new File(currentPath));
        File file = fileChooser.showOpenDialog(myStage);

        if (file != null) {
            currentMap = file.getName();
            MazeBuilder myMaze = new MazeBuilder("./mazes/" + file.getName(), tilePane);
            myMaze.constructMap();
            tileMap = myMaze.getTileMap();
            sizeLabel.setText(Integer.toString(myMaze.getMapSize()));

            EditorNavigator myNav = new EditorNavigator(tileMap, tilePane, 0, 0); 
            tileEditor = myNav;
            tileMap = myNav.getTileMap();
        }
        tilePane.requestFocus();
        editMode = true;
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        MazeBuilder myMaze = new MazeBuilder("./mazes/maze0.txt", tilePane);
        myMaze.constructMap();
        tileMap = myMaze.getTileMap();

        EditorNavigator myNav = new EditorNavigator(tileMap, tilePane, 0, 0); 
        tileEditor = myNav;
        tileMap = myNav.getTileMap();

    }   
    
    
}
