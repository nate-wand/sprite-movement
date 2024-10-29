package entity;

import main.GamePanel;
import main.InputHandler;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;


public class Player extends Entity {
    
    GamePanel gp;
    InputHandler playerInput;
    public BufferedImage playerImage, rightIdle1, rightIdle2, rightBlink, 
    leftIdle1, leftIdle2, leftBlink, leftRun1, leftRun2, leftRun3,
    rightRun1, rightRun2, rightRun3;
    String direction = "right";
    

    
    
    public Player(GamePanel gp, InputHandler playerInput) {
        this.gp = gp;
        this.playerInput = playerInput;

        setDefaultValues();
        getPlayerImage();
    }

    public void setDefaultValues() {
        
        x = 100;
        y = 100;
        speed = 1;
    }

    public void getPlayerImage(){
        spriteSheet = loadImage("sprite-movement-main/res/megaman/32pxmegamanspritesheet.png");
        
        leftIdle1 = grabSprite(1, 1, gp.tileSize, gp.tileSize, spriteSheet);
        leftIdle2 = grabSprite(2, 1, gp.tileSize, gp.tileSize, spriteSheet);
        leftBlink = grabSprite(2, 1, gp.tileSize, gp.tileSize, spriteSheet);
        leftRun1 = grabSprite(4, 1, gp.tileSize, gp.tileSize, spriteSheet);
        leftRun2 = grabSprite(5, 1, gp.tileSize, gp.tileSize, spriteSheet);
        leftRun3 = grabSprite(6, 1, gp.tileSize, gp.tileSize, spriteSheet);
        rightRun1 = flip(grabSprite(4, 1, gp.tileSize, gp.tileSize, spriteSheet));
        rightRun2 = flip(grabSprite(5, 1, gp.tileSize, gp.tileSize, spriteSheet));
        rightRun3 = flip(grabSprite(6, 1, gp.tileSize, gp.tileSize, spriteSheet));
        rightIdle1 = flip(grabSprite(1, 1, gp.tileSize, gp.tileSize, spriteSheet));
        rightIdle2 = flip(grabSprite(2, 1, gp.tileSize, gp.tileSize, spriteSheet));

        playerImage = rightIdle1;

    }

    public void update() {
        
        int currentPosition = x;

        if(playerInput.leftPress == true) {
            x -= speed;
        }
        else if (playerInput.rightPress == true) {
            x += speed;
        } 
        
        spriteCounter++;
        if (spriteCounter > 10){
            int lastSprite = 0;

            if(spriteNum == 3) {
                spriteNum = 2;
                lastSprite = 3;
            }
            else if (spriteNum == 2 && lastSprite == 1){
                spriteNum++;
                if (lastSprite == 3) {
                    spriteNum--;
                }
            }
            else {
                spriteNum++;
                lastSprite = 1;
                
            }
            spriteCounter = 0;
        }
        
        if (x > currentPosition) {
            direction = "right";
            switch(spriteNum) {
                case 1:
                    playerImage = rightRun1;
                break;
                case 2:
                    playerImage = rightRun2;
                break;
                case 3:
                    playerImage = rightRun3;
                break;
            }
        }
        else if (x < currentPosition) {
            direction = "left";
            switch(spriteNum) {
                case 1:
                    playerImage = leftRun1;
                break;
                case 2:
                    playerImage = leftRun2;
                break;
                case 3:
                    playerImage = leftRun3;
                break;
            }
        }
        else {
            if (direction == "left") {
                switch(spriteNum) {
                    case 1:
                        playerImage = leftIdle1;
                    break;
                    case 2:
                        playerImage = leftIdle2;
                    break;
                    default:
                        playerImage = leftIdle1;
                    }
            }
            else if (direction == "right") {
                switch(spriteNum) {
                    case 1:
                        playerImage = rightIdle1;
                    break;
                    case 2:
                        playerImage = rightIdle2;
                    break;
                    default:
                        playerImage = rightIdle1;
                    }
            }   
        }

        
    }

    public void draw(Graphics2D g2) {
        
        g2.drawImage(playerImage, x, y, gp.tileSize, gp.tileSize, null);
        

    }
}
