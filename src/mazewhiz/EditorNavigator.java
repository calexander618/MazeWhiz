/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mazewhiz;

import javafx.scene.layout.AnchorPane;

/**
 *
 * @author chasealexander
 */
public class EditorNavigator extends AbstractNavigator {
        
    EditorNavigator(Tile[][] map, AnchorPane canvas, int currentRow, int currentColumn) {
        tileMap = map;
        mazePane = canvas;
        this.currentRow = currentRow;
        this.currentColumn = currentColumn;
        getCurrentTile().setType(tileMap[currentRow][currentColumn].getType() + 4);
        getCurrentTile().drawTile(mazePane);
    }
    
    @Override
    public boolean moveUp() {
        if (currentRow-1 >= 0) {
            int previousType = getCurrentTile().getType();
            currentRow -= 1;
            getCurrentTile().setType(getCurrentTile().getType()+4);
            getCurrentTile().drawTile(mazePane);
            tileMap[currentRow+1][currentColumn].setType(previousType-4);
            tileMap[currentRow+1][currentColumn].drawTile(mazePane);
        }
        return true;
    }

    @Override
    public boolean moveDown() {
        if (currentRow+1 < tileMap[0].length) {
            int previousType = getCurrentTile().getType();
            currentRow += 1;
            getCurrentTile().setType(getCurrentTile().getType()+4);
            getCurrentTile().drawTile(mazePane);
            tileMap[currentRow-1][currentColumn].setType(previousType-4);
            tileMap[currentRow-1][currentColumn].drawTile(mazePane);
        }
        return true;
    }
    //
    @Override
    public boolean moveLeft() {
        if (currentColumn-1 >= 0) {
            int previousType = getCurrentTile().getType();
            currentColumn -= 1; 
            getCurrentTile().setType(getCurrentTile().getType()+4);
            getCurrentTile().drawTile(mazePane);
            tileMap[currentRow][currentColumn+1].setType(previousType-4);
            tileMap[currentRow][currentColumn+1].drawTile(mazePane);               
        }
        return true;        
    }
    
    @Override
    public boolean moveRight() {
        if (currentColumn+1 < tileMap[0].length) {
            int previousType = getCurrentTile().getType();
            currentColumn += 1;           
            getCurrentTile().setType(getCurrentTile().getType()+4);
            getCurrentTile().drawTile(mazePane);
            tileMap[currentRow][currentColumn-1].setType(previousType-4);
            tileMap[currentRow][currentColumn-1].drawTile(mazePane); 
        }
        return true;        
    }
    
    public void changeSelection() {
        if (getCurrentTile().getType() < 7) {
            getCurrentTile().setType(getCurrentTile().getType()+1);
            getCurrentTile().drawTile(mazePane);

        }
        else {
            getCurrentTile().setType(4);
            getCurrentTile().drawTile(mazePane);
        }
    }
  
}
