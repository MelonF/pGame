package entity;

import main.GamePanel;

import java.awt.*;
import java.awt.image.BufferedImage;



public abstract class entity {

    GamePanel gp;


    public int worldx, worldy;
    public int speed;
public BufferedImage  up1, up2, down1, down2, left1, left2, right1, right2;
public String direction;
public int spriteCounter = 0;
public int spriteNum= 1;
public Rectangle solidArea = new Rectangle(0, 0,48, 48);
public int solidAreaDefaultX, solidAreaDefaultY;

public boolean on = false;
public int actionLockCounter = 0;

public entity (GamePanel gp)
{
    this.gp = gp;
}


public void setAction()
{

}


    public void update() {
        setAction();

        on = false;

        gp.cC.checkCollision(this);

        if (!on) {
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

        // Increment spriteCounter
        spriteCounter++;
        if (spriteCounter > 15) { // Adjust threshold for animation speed
            spriteNum = (spriteNum == 1) ? 2 : 1; // Toggle between 1 and 2
            spriteCounter = 0; // Reset counter
        }
    }



    public void move()
    {

    }






    public void draw(Graphics2D g2) {


        int screenX = worldx - gp.p.worldx + gp.p.screenX;
        int screenY = worldy - gp.p.worldy + gp.p.screenY;

        // Check if the entity is within the visible screen bounds
        if (worldx + gp.tileSize > gp.p.worldx - gp.p.screenX &&
                worldx - gp.tileSize < gp.p.worldx + gp.p.screenX &&
                worldy + gp.tileSize > gp.p.worldy - gp.p.screenY &&
                worldy - gp.tileSize < gp.p.worldy + gp.p.screenY) {


            BufferedImage image = null;

            switch (direction) {

                case "up":
                    if (spriteNum == 1) {
                        image = up1;
                    }
                    if (spriteNum == 2) {
                        image = up2;
                    }
                    break;
                case "down":
                    if (spriteNum == 1) {
                        image = down1;
                    }
                    if (spriteNum == 2) {
                        image = down2;
                    }
                    break;
                case "left":
                    if (spriteNum == 1) {
                        image = left1;
                    }
                    if (spriteNum == 2) {
                        image = left2;
                    }

                    break;
                case "right":
                    if (spriteNum == 1) {
                        image = right1;
                    }
                    if (spriteNum == 2) {
                        image = right2;
                    }
                    break;


            }


            g2.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize, null);
        }

    }














//            // Determine the appropriate sprite based on direction and spriteNum
//            switch (direction) {
//                case "up":
//                    image = (spriteNum == 1) ? up1 : up2;
//                    break;
//                case "down":
//                    image = (spriteNum == 1) ? down1 : down2;
//                    break;
//                case "left":
//                    image = (spriteNum == 1) ? left1 : left2;
//                    break;
//                case "right":
//                    image = (spriteNum == 1) ? right1 : right2;
//                    break;
//            }
//
//            // Draw the image at the calculated screen position
//            if (image != null) {
//                g2.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize, null);
//            }
        }











