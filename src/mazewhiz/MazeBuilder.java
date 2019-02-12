/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mazewhiz;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author chasealexander
 */
public class MazeBuilder implements BuilderInterface {
    
    private AnchorPane mazePane;
    
    private String fileName;
    
    private final int screenWidth = 450;
    private final int screenHeight = 450;
    
    private int gridNum;
    
    private int[][] intMap;
    private Tile[][] tileMap;
    
    private int startRow = 0;
    private int startColumn = 0;
    
    MazeBuilder(String file, AnchorPane canvas) {
        this.mazePane = canvas;
        this.fileName = file;
    }

    @Override
    public void constructMap() {
        
        int[][] intArray;
        intArray = readMap();
        this.intMap = intArray;
        
        Tile[][] tileArray;
        tileArray = buildTiles();
        this.tileMap = tileArray;
            
    }
    
    //maybe put override and add to interface?
    @Override
    public int[][] readMap() {
        int[][] mapArray;
        mapArray = new int[gridNum][gridNum];
        
        try {
            File file = new File(fileName);
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = bufferedReader.readLine(); 
            this.gridNum = Integer.parseInt(line);
            mapArray = new int[gridNum][gridNum];

            int i = 0;
            while ((line = bufferedReader.readLine()) != null) {
                char[] lineArr = line.toCharArray();
                for (int j=0; j<lineArr.length; j++) {
                    mapArray[i][j] = Character.getNumericValue(lineArr[j]);
                    if (mapArray[i][j] == 1) {
                        startRow = i;
                        startColumn = j;
                    }
                }
                i++;
            }
            fileReader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return mapArray;
    }
    
    @Override
    public Tile[][] buildTiles() {
        int tileHeight = screenWidth / gridNum;
        int tileWidth = screenHeight / gridNum;       
    
        
        Tile[][] tileArray = new Tile[gridNum][gridNum];
        
        for (int i=0; i<gridNum; i++) {
            for (int j=0; j<gridNum; j++) {

                Tile myTile = new Tile(intMap[i][j], j*tileHeight, i*tileWidth, tileHeight, tileWidth);
                tileArray[i][j] = myTile;
                myTile.drawTile(mazePane);
            }
        }
        return tileArray;
    }
    
    @Override
    public Tile[][] getTileMap() {
        return this.tileMap;
    }
    
    @Override
    public int getStartRow() {
        return this.startRow;
    }
    
    @Override
    public int getStartColumn() {
        return this.startColumn;
    }
    
    @Override
    public int getMapSize() {
        return this.gridNum;
    }
}


