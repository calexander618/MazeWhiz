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
public abstract class AbstractNavigator {
    
    protected Tile[][] tileMap;
    protected AnchorPane mazePane;
    
    protected int currentRow;
    protected int currentColumn;
        
    public Tile getCurrentTile() {
        return tileMap[currentRow][currentColumn];
    }
    
    public Tile[][] getTileMap() {
        return tileMap;
    }
    
    protected abstract boolean moveUp();

    protected abstract boolean moveDown();
    
    protected abstract boolean moveLeft();

    protected abstract boolean moveRight();


}
