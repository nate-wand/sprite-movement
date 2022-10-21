package entity;

import main.GamePanel;
import main.InputHandler;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;


public class Player extends Entity {
    
    GamePanel gp;
    InputHandler playerInput;
    public BufferedImage playerImage, idleLeft, idleRight;
    public BufferedImage playerSpriteSheet, extraSpriteSheet;
    String direction;
    
    
    public Player(GamePanel gp, InputHandler playerInput) {
        this.gp = gp;
        this.playerInput = playerInput;

        setDefaultValues();
        getPlayerImage();
    }

    public void setDefaultValues() {
        
        x = 100;
        y = 100;
        speed = 2;
    }

    public void getPlayerImage(){
        playerSpriteSheet = loadImage("res/megaman/32pxmegamanspritesheet.png");
        
        idleLeft = grabSprite(1, 1, gp.tileSize, gp.tileSize, playerSpriteSheet);
        idleRight = flip(grabSprite(1, 1, gp.tileSize, gp.tileSize, playerSpriteSheet));


    }

    public void update() {
        
        if(playerInput.leftPress == true) {
            x -= speed;
            playerImage = idleLeft;
        }
        else if (playerInput.rightPress == true) {
            x += speed;
            playerImage = idleRight;

        }
    }

    public void draw(Graphics2D g2) {
        
        g2.drawImage(playerImage, x, y, gp.tileSize, gp.tileSize, null);
        

    }
}
