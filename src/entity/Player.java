package entity;

import main.GamePanel;
import main.InputHandler;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class Player extends Entity {
    
    GamePanel gp;
    InputHandler playerInput;
    public BufferedImage playerImage;
    public BufferedImage playerSpriteSheet;
    
    public Player(GamePanel gp, InputHandler playerInput) {
        this.gp = gp;
        this.playerInput = playerInput;

        setDefaultValues();
        getPlayerImage();
    }

    public void setDefaultValues() {
        
        x = 100;
        y = 100;
        speed = 4;
    }

    public void getPlayerImage(){
        playerSpriteSheet = loadImage("res/megaman/megamanspritesheet.png");
    }

    public void update() {

        playerImage = grabSprite(1, 1, gp.tileSize, gp.tileSize, playerSpriteSheet);
        
        if(playerInput.leftPress == true) {
            x -= speed;
            playerImage = grabSprite(1, 1, gp.tileSize, gp.tileSize, playerSpriteSheet);
        }
        else if (playerInput.rightPress == true) {
            x += speed;

        }
    }

    public void draw(Graphics2D g2) {
        
        g2.drawImage(playerImage, x, y, gp.tileSize, gp.tileSize, null);
    }
}
