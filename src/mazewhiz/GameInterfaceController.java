/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mazewhiz;


import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;

import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;

/**
 *
 * @author chasealexander
 */
public class GameInterfaceController implements Initializable {
    
    @FXML
    private AnchorPane tilePane;
    
    @FXML
    private Button levelButton;
    
    @FXML
    private Label levelLabel1;
    
    @FXML
    private Label levelLabel2;
       
    @FXML
    private Label levelLabel3;
          
    @FXML
    private Label levelLabel4;
             
    @FXML
    private Label levelLabel5;
    
    private Tile[][] tileMap;
    
    private MazeNavigator tileNavigator;
    
    private ArrayList<Label> labelArray;
        
    private int levelCounter = 1;

    @FXML
    public void handleKeyPress(KeyEvent event) {
        switch(event.getCode()) {
            case W:
                if (tileNavigator.moveUp() != false) {
                    if (levelCounter < 5) {
                        levelButton.setDisable(false);
                    }
                    else {
                        levelButton.setText("You Win!");
                        levelButton.setTextFill(Color.BLUE);                        
                    }                    
                }
                break;
            case S:
                if (tileNavigator.moveDown() != false) {
                    if (levelCounter < 5) {
                        levelButton.setDisable(false);
                    }  
                    else {
                        levelButton.setText("You Win!");
                        levelButton.setTextFill(Color.BLUE);

                    }                    
                }
                break;
            case A:
                if (tileNavigator.moveLeft() != false) {
                    if (levelCounter < 5) {
                        levelButton.setDisable(false);
                    }
                    else {
                        levelButton.setText("You Win!");
                        levelButton.setTextFill(Color.BLUE);
                    }
                }
                break;
            case D:
                if (tileNavigator.moveRight() != false) {
                    if (levelCounter < 5) {
                        levelButton.setDisable(false);
                    }      
                    else {
                        levelButton.setText("You Win!");
                        levelButton.setTextFill(Color.BLUE);                        
                    }                    
                }
                break;
            default:
                break;
        }
    }
    
    @FXML
    public void levelUp(ActionEvent event) {
        labelArray.get(levelCounter-1).setTextFill(Color.BLACK);
        levelCounter++;
        labelArray.get(levelCounter-1).setTextFill(Color.RED);

        levelButton.setDisable(true);
        tilePane.requestFocus();

        MazeBuilder myMaze = new MazeBuilder("./mazes/maze"+levelCounter+".txt", tilePane);
        myMaze.constructMap();
        tileMap = myMaze.getTileMap();

        int startRow = myMaze.getStartRow();
        int startColumn = myMaze.getStartColumn();

        MazeNavigator myNav = new MazeNavigator(tileMap, tilePane, startRow, startColumn);
        tileNavigator = myNav;    
    }
    
       
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        labelArray = new ArrayList<>();
        labelArray.add(levelLabel1);
        labelArray.add(levelLabel2);
        labelArray.add(levelLabel3);
        labelArray.add(levelLabel4);
        labelArray.add(levelLabel5);

//        labelArray[0] = levelLabel1;
//        labelArray[1] = levelLabel2;
//        labelArray[2] = levelLabel3;
//        labelArray[3] = levelLabel4;
//        labelArray[4] = levelLabel5;
        
        MazeBuilder myMaze = new MazeBuilder("./mazes/maze1.txt", tilePane);
        myMaze.constructMap();
        tileMap = myMaze.getTileMap();
        
        int startRow = myMaze.getStartRow();
        int startColumn = myMaze.getStartColumn();

        MazeNavigator myNav = new MazeNavigator(tileMap, tilePane, startRow, startColumn);
        tileNavigator = myNav;
        
    }    
    
}
