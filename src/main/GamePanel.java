package main;

import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import entity.Player;

public class GamePanel extends JPanel implements Runnable {
    
    final int originalTileSize = 8; // 8 x 8 tiles
    final int scale = 4;
    
    public final int tileSize = scale * originalTileSize;
    final int screenCol = 8;

    final int screenWidth = tileSize * screenCol; // 768 pixels
    final int screenHeight = screenWidth / 4 * 3; // 4:3 aspect ratio (576 pixels)

    int FPS = 60;


    InputHandler inputs = new InputHandler();
    Thread gameThread;
    Player player = new Player(this, inputs);


    public GamePanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(inputs);
        this.setFocusable(true);
        
    }

    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    public void run() {

        double drawInterval = 1000000000/FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;

        while (gameThread != null) {
            
            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / drawInterval;
            lastTime = currentTime; 

            if(delta >= 1){
                update();
                repaint();
                delta--;
            }
        }
    }

    public void update() {

    }

    public void paintComponent(Graphics g) {

        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D)g;  

        player.update();
        player.draw(g2);

        g2.dispose();
    }
}
