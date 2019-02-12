/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mazewhiz;

/**
 *
 * @author chasealexander
 */
public interface BuilderInterface {
            
    public void constructMap() ;
        
    public int[][] readMap() ;
        
    public Tile[][] buildTiles() ;
        
    public Tile[][] getTileMap() ;
        
    public int getStartRow() ;
        
    public int getStartColumn() ;

    public int getMapSize() ;
    
}

