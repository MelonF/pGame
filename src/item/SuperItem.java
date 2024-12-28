package item;

import main.GamePanel;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class SuperItem {

    public BufferedImage image;
    public String name;
    public boolean collision = false;
    public int worldX;
    public int worldY;
    public Rectangle solidArea = new Rectangle(0,0, 48, 48);
    public int solidAreaDefaultX = 0;
    public int solidAreaDefaultY = 0;

    public void draw(Graphics g2, GamePanel gp) {


        int screenX = worldX - gp.p.worldx + gp.p.screenX;
        int screenY = worldY - gp.p.worldy + gp.p.screenY;



        if (worldX + gp.tileSize > gp.p.worldx - gp.p.screenX
                && worldX - gp.tileSize < gp.p.worldx + gp.p.screenX
                && worldY + gp.tileSize > gp.p.worldy - gp.p.screenY
                && worldY - gp.tileSize < gp.p.worldy + gp.p.screenY) {


            g2.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize, null);
        }



    }

    public void playerInteractWithDoor(SuperItem Door, GamePanel gp) {

    }





}
