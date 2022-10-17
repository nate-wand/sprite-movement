package entity;

import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Entity {
    
    public int x, y;
    public int speed;
    
    private BufferedImage image;

    public BufferedImage loadImage(String path) {

        try {
            image = ImageIO.read(new FileInputStream(path));
        } catch(FileNotFoundException e) {
            e.printStackTrace();
        } 
        catch (IOException e) {
            e.printStackTrace();
        }
        return image;
    }

    public BufferedImage grabSprite(int col, int row, int width, int height, BufferedImage spriteSheet) {
        BufferedImage sprite = spriteSheet.getSubimage((col*24) - 24, (row *24)-24, width, height);
        return sprite;
    }

    
}
