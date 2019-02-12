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
public class MazeNavigator extends AbstractNavigator{
    
    private boolean finishReached = false;
    
    public MazeNavigator(Tile[][] map, AnchorPane canvas, int currentRow, int currentColumn) {
        tileMap = map;
        mazePane = canvas;
        this.currentRow = currentRow;
        this.currentColumn = currentColumn;
    }
    
    @Override
    public boolean moveUp() {
        if (currentRow-1 >= 0) {
            if (tileMap[currentRow-1][currentColumn].getType() != 0 && finishReached == false)  {
                if (tileMap[currentRow-1][currentColumn].getType() == 3 ) {
                    currentRow -= 1;
                    getCurrentTile().setType(1);
                    getCurrentTile().drawTile(mazePane);
                    tileMap[currentRow+1][currentColumn].setType(2);
                    tileMap[currentRow+1][currentColumn].drawTile(mazePane);
                    
                    finishReached = true;
                }
                else {
                    currentRow -= 1;
                    getCurrentTile().setType(1);
                    getCurrentTile().drawTile(mazePane);
                    tileMap[currentRow+1][currentColumn].setType(2);
                    tileMap[currentRow+1][currentColumn].drawTile(mazePane);
                }
            }
        }
        return finishReached;
    }

    @Override
    public boolean moveDown() {
        if (currentRow+1 < tileMap[0].length) {
            if (tileMap[currentRow+1][currentColumn].getType() != 0 && finishReached == false)  {
                if (tileMap[currentRow+1][currentColumn].getType() == 3 ) {
                    currentRow += 1;
                    getCurrentTile().setType(1);
                    getCurrentTile().drawTile(mazePane);
                    tileMap[currentRow-1][currentColumn].setType(2);
                    tileMap[currentRow-1][currentColumn].drawTile(mazePane);
                    
                    finishReached = true;
                }
                else {
                    currentRow += 1;
                    getCurrentTile().setType(1);
                    getCurrentTile().drawTile(mazePane);
                    tileMap[currentRow-1][currentColumn].setType(2);
                    tileMap[currentRow-1][currentColumn].drawTile(mazePane);
                }    
            }
        }
        return finishReached;
    }
    //
    @Override
    public boolean moveLeft() {
        if (currentColumn-1 >= 0) {
            if (tileMap[currentRow][currentColumn-1].getType() != 0 && finishReached == false)  {
                if (tileMap[currentRow][currentColumn-1].getType() == 3 ) {
                    currentColumn -= 1;
                    getCurrentTile().setType(1);
                    getCurrentTile().drawTile(mazePane);
                    tileMap[currentRow][currentColumn+1].setType(2);
                    tileMap[currentRow][currentColumn+1].drawTile(mazePane);
                    
                    finishReached = true;
                }
                else {
                    currentColumn -= 1;  
                    getCurrentTile().setType(1);
                    getCurrentTile().drawTile(mazePane);
                    tileMap[currentRow][currentColumn+1].setType(2);
                    tileMap[currentRow][currentColumn+1].drawTile(mazePane);
                }
            }
        }
        return finishReached;
    }
    
    @Override
    public boolean moveRight() {
        if (currentColumn+1 < tileMap[0].length) {
            if (tileMap[currentRow][currentColumn+1].getType() != 0 && finishReached == false)  {
                if (tileMap[currentRow][currentColumn+1].getType() == 3 ) {
                    currentColumn += 1;
                    getCurrentTile().setType(1);
                    getCurrentTile().drawTile(mazePane);
                    tileMap[currentRow][currentColumn-1].setType(2);
                    tileMap[currentRow][currentColumn-1].drawTile(mazePane);
                    
                    finishReached = true;
                }
                else {
                    currentColumn += 1;
                    getCurrentTile().setType(1);
                    getCurrentTile().drawTile(mazePane);
                    tileMap[currentRow][currentColumn-1].setType(2);
                    tileMap[currentRow][currentColumn-1].drawTile(mazePane);
                }
            }
        }
        return finishReached;
    }

}
