package entity;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Random;



public class men extends entity {

    public int worldx, worldy;

    private int actionLockCounter = 0;



    public men(GamePanel gp) {

        super(gp);
direction = "down";
    speed = 5;

        if (gp == null) {
            System.err.println("Error: GamePanel is null!");
        } else {
            System.out.println("GamePanel initialized successfully.");
        }



        getMenImage();

    }





    public void getMenImage()
    {
        try {
            InputStream input;


        input = getClass().getResourceAsStream("/res/sprites/NPC/manDown1.png");
        if (input == null) throw new IOException("Resource not found: manDown1.png");
        down1 = ImageIO.read(input);

        input = getClass().getResourceAsStream("/res/sprites/NPC/manDown2.png");
        if (input == null) throw new IOException("Resource not found: manDown2.png");
        down2 = ImageIO.read(input);

        input = getClass().getResourceAsStream("/res/sprites/NPC/manRight1.png");
        if (input == null) throw new IOException("Resource not found: manRight1.png");
        right1 = ImageIO.read(input);

        input = getClass().getResourceAsStream("/res/sprites/NPC/manRight2.png");
        if (input == null) throw new IOException("Resource not found: manRight2.png");
        right2 = ImageIO.read(input);

        input = getClass().getResourceAsStream("/res/sprites/NPC/manLeft1.png");
        if (input == null) throw new IOException("Resource not found: manLeft1.png");
        left1 = ImageIO.read(input);

        input = getClass().getResourceAsStream("/res/sprites/NPC/manLeft2.png");
        if (input == null) throw new IOException("Resource not found: manLeft2.png");
        left2 = ImageIO.read(input);

            input = getClass().getResourceAsStream("/res/sprites/NPC/manUp1.png");
            if (input == null) throw new IOException("Resource not found: manUp1.png");
            up1 = ImageIO.read(input);

            input = getClass().getResourceAsStream("/res/sprites/NPC/manUp2.png");
            if (input == null) throw new IOException("Resource not found: manUp2.png");
            up2 = ImageIO.read(input);


            System.out.println("All images loaded successfully!");


        } catch (IOException e) {
            System.err.println("Failed to load an image: " + e.getMessage());
            e.printStackTrace();
        }

    }

    @Override
    public void setAction() {
        actionLockCounter++;

        if (actionLockCounter >= 120 || on) { // Change direction if stuck
            boolean foundValidDirection = false;
            int attempts = 0;

            while (!foundValidDirection && attempts < 4) { // Try up to 4 directions
                Random rand = new Random();
                int i = rand.nextInt(100) + 1;

                String newDirection = "";
                if (i <= 25) {
                    newDirection = "down";
                } else if (i > 25 && i <= 50) {
                    newDirection = "left";
                } else if (i > 50 && i <= 75) {
                    newDirection = "right";
                } else {
                    newDirection = "up";
                }

                // Check if the new direction is valid
                if (canMoveInDirection(newDirection)) {
                    direction = newDirection;
                    foundValidDirection = true;
                }

                attempts++;
            }

            if (!foundValidDirection) {
                System.out.println("No valid direction found. NPC is pausing.");
                direction = "idle"; // Explicitly set direction to "idle"
                actionLockCounter = -60; // Pause for 60 frames
            }

            actionLockCounter = 0; // Reset lock counter
        }
    }


    @Override
    public void move() {
        // Do nothing if direction is "idle"
        if ("idle".equals(direction)) {
            System.out.println("NPC is idle, no movement.");
            return; // Skip movement logic
        }

        int tileSize = gp.tileSize;

        // Calculate the target position
        int targetX = worldx;
        int targetY = worldy;

        switch (direction) {
            case "up":
                targetY -= speed;
                break;
            case "down":
                targetY += speed;
                break;
            case "left":
                targetX -= speed;
                break;
            case "right":
                targetX += speed;
                break;
        }

        // Convert target position to map tile indices
        int col = targetX / tileSize;
        int row = targetY / tileSize;

        // Debugging logs

        // Check map boundaries
        if (col >= 0 && row >= 0 && col < gp.maxWorldCol && row < gp.maxWorldRow) {
            int tileNum = gp.tM.mapTileNum[col][row]; // Get tile type

            if (!gp.tM.tile[tileNum].collision) { // Check if walkable
                worldx = targetX;
                worldy = targetY;
                System.out.println("Moved to X=" + worldx + ", Y=" + worldy);
            } else {
                System.out.println("Blocked by tile " + tileNum + " at Col=" + col + ", Row=" + row);
            }
        } else {
            System.out.println("Out of bounds: TargetX=" + targetX + ", TargetY=" + targetY);
        }
    }




    private boolean canMoveInDirection(String direction) {
        int tileSize = gp.tileSize;
        int targetX = worldx;
        int targetY = worldy;

        switch (direction) {
            case "up":
                targetY -= speed;
                break;
            case "down":
                targetY += speed;
                break;
            case "left":
                targetX -= speed;
                break;
            case "right":
                targetX += speed;
                break;
        }

        int col = targetX / tileSize;
        int row = targetY / tileSize;

        // Check bounds and tile collision
        if (col >= 0 && row >= 0 && col < gp.maxWorldCol && row < gp.maxWorldRow) {
            int tileNum = gp.tM.mapTileNum[col][row];
            return !gp.tM.tile[tileNum].collision; // Return true if the tile is walkable

        }


        return false; // Out of bounds or blocked
    }




    @Override
    public void draw(Graphics2D g2) {
        // Calculate screen coordinates based on world position and player position
        int screenX = worldx - gp.p.worldx + gp.p.screenX;
        int screenY = worldy - gp.p.worldy + gp.p.screenY;

        // Check if the entity is within the visible screen bounds
        if (worldx + gp.tileSize > gp.p.worldx - gp.p.screenX &&
                worldx - gp.tileSize < gp.p.worldx + gp.p.screenX &&
                worldy + gp.tileSize > gp.p.worldy - gp.p.screenY &&
                worldy - gp.tileSize < gp.p.worldy + gp.p.screenY) {

            BufferedImage image = null;

            // Select the appropriate sprite based on direction and spriteNum
            switch (direction) {
                case "up":
                    image = (spriteNum == 1) ? up1 : up2;
                    break;
                case "down":
                    image = (spriteNum == 1) ? down1 : down2;
                    break;
                case "left":
                    image = (spriteNum == 1) ? left1 : left2;
                    break;
                case "right":
                    image = (spriteNum == 1) ? right1 : right2;
                    break;
            }

            // Debugging logs
            System.out.println("Drawing men: ScreenX=" + screenX + ", ScreenY=" + screenY);
            System.out.println("Direction: " + direction + ", SpriteNum: " + spriteNum);
            System.out.println("Image Selected: " + (image != null ? "Valid" : "Null"));

            // Draw the sprite
            g2.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize, null);

            // Optional: Draw hitbox for debugging

        }
    }



    @Override
    public void update() {
        setAction(); // Determine the direction

        on = false; // Reset collision flag

        gp.cC.checkCollision(this); // Perform collision checks

        // If no collision, call move() to update position with tile validation
        if (!on) {
            move();
        }

        // Increment spriteCounter for animation
        spriteCounter++;
        if (spriteCounter > 15) { // Adjust threshold for animation speed
            spriteNum = (spriteNum == 1) ? 2 : 1; // Toggle between 1 and 2
            spriteCounter = 0; // Reset counter
        }
    }
















}

























//
//    @Override
//    public void setAction() {
//        actionLockCounter++;
//
//        if (actionLockCounter == 120) {
//            Random rand = new Random();
//            int i = rand.nextInt(100) + 1;
//
//            // Set direction to valid values
//            if (i <= 25) {
//                direction = "down"; // Changed from "down1" to "down"
//            } else if (i > 25 && i <= 50) {
//                direction = "left"; // Changed from "left1" to "left"
//            } else if (i > 50 && i <= 75) {
//                direction = "right"; // Changed from "right1" to "right"
//            } else if (i > 75 && i <= 100) {
//                direction = "up"; // Changed from "up1" to "up"
//            }
//            actionLockCounter = 0;
//        }
//    }
//
////
























