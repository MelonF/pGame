package entity;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.Random;

public class nPC_Rat extends entity {



public nPC_Rat(GamePanel gp) {

    super(gp);

    direction = "down";
    speed = 0;

    getRatImage();

}

public void getRatImage()
{
    try {
        InputStream input;


        input = getClass().getResourceAsStream("/res/sprites/NPC/ratStill.png");
        if (input == null) throw new IOException("Resource not found: ratStill.png");
        down1 = ImageIO.read(input);

        input = getClass().getResourceAsStream("/res/sprites/NPC/ratRight.png");
        if (input == null) throw new IOException("Resource not found: ratRight.png");
        right1 = ImageIO.read(input);

//        input = getClass().getResourceAsStream("/res/sprites/ratS.png");
//        if (input == null) throw new IOException("Resource not found: lem_down1.png");
//        down1 = ImageIO.read(input);
//
//        input = getClass().getResourceAsStream("/res/sprites/lem_down2.png");
//        if (input == null) throw new IOException("Resource not found: lem_down2.png");
//        down2 = ImageIO.read(input);
//
//        input = getClass().getResourceAsStream("/res/sprites/lem_right1.png");
//        if (input == null) throw new IOException("Resource not found: lem_right1.png");
//        right1 = ImageIO.read(input);
//
//        input = getClass().getResourceAsStream("/res/sprites/lem_right2.png");
//        if (input == null) throw new IOException("Resource not found: lem_right2.png");
//        right2 = ImageIO.read(input);
//
//        input = getClass().getResourceAsStream("/res/sprites/lem_left1.png");
//        if (input == null) throw new IOException("Resource not found: lem_left1.png");
//        left1 = ImageIO.read(input);
//
//        input = getClass().getResourceAsStream("/res/sprites/lem_left2.png");
//        if (input == null) throw new IOException("Resource not found: lem_left2.png");
//        left2 = ImageIO.read(input);

        System.out.println("All images loaded successfully!");


    } catch (IOException e) {
        System.err.println("Failed to load an image: " + e.getMessage());
        e.printStackTrace();
    }

    }

    @Override
    public void setAction()
    {

        actionLockCounter++;

        if (actionLockCounter == 120) {


            Random rand = new Random();

            int i = rand.nextInt(100) + 1;


            if (i <= 25) {
                direction = "right";
            } else if (i > 25 && i <= 50) {
                direction = "down";
            }
            if (i > 50 && i <= 75) {
                direction = "down";
            }
            if (i > 75 && i <= 100) {
                direction = "right";
            }
            actionLockCounter = 0;
        }




    }


    @Override
    public void update()
{
    setAction();

    on = false;

    gp.cC.checkCollision(this);

    if (!on)
    {
        System.out.println("Current direction: " + direction);

        switch (direction) {
            case "up":
                worldy -= speed;
                break;
            case "down":
                worldy += speed;
                break;
            case "left":
                worldx -= speed;
                break;
            case "right":
                worldx += speed;
                break;
        }
    }

    spriteCounter++;


}









}











