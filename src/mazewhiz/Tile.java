/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mazewhiz;

import javafx.scene.layout.AnchorPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 * @author chasealexander
 */
public class Tile {

    private int type;
    private int x;
    private int y;
    private int height;
    private int width;
    
    Tile(int type, int x, int y, int height, int width) {
        this.type = type;
        this.x = x;
        this.y = y;
        this.width = height;
        this.height = width;
    }

    public int getType() {
        return type;
    }
    
    public void setType(int type) {
        this.type = type;
    }

    public void drawTile(AnchorPane map) {
        Image image = new Image(getClass().getResource(getSpriteFile()).toExternalForm());
        ImageView iv = new ImageView(image);
        iv.setFitHeight(height);
        iv.setFitWidth(width);
        iv.setX(x);
        iv.setY(y);
        map.getChildren().add(iv);     
    }
    
    private String getSpriteFile() {
        switch(type) {
            case 0:
                return "tilesprites/tileblue.png";
        
            case 1:
                return "tilesprites/tileyellow.png";
       
            case 2:
                return "tilesprites/tilegrey.png";
                
            case 3:
                return "tilesprites/tilered.png";
                
            case 4:
                return "tilesprites/selectblue.png";    
                
            case 5:
                return "tilesprites/selectyellow.png";
       
            case 6:
                return "tilesprites/selectgrey.png";
                
            case 7:
                return "tilesprites/selectred.png";
                
            default:
                return "tilesprites/selectgreen.png";
        }
    }
    


}