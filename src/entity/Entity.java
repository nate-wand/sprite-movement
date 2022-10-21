package entity;

import java.awt.image.BufferedImage;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


import javax.imageio.ImageIO;

public class Entity {
    
    public int x, y;
    public int speed;
    public int spriteCounter= 0;
    public int spriteNum = 1;
    
    private BufferedImage image;
    public BufferedImage spriteSheet;

    // load a spritesheet
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

    // obtain a sprite from a spritesheet
    public BufferedImage grabSprite(int col, int row, int width, int height, BufferedImage spriteSheetparam) {
        BufferedImage sprite = spriteSheetparam.getSubimage((col*32) - 32, (row *32)-32, width, height);
        return sprite;
    }

    // Flip an image horizontally (somehow)
    public BufferedImage flip(BufferedImage entityImage) {
        AffineTransform tx = AffineTransform.getScaleInstance(-1, 1);
        tx.translate(-entityImage.getWidth(null), 0);
        AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
        entityImage = op.filter(entityImage, null);
        return entityImage;
    }

    
}
