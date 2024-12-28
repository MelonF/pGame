package main;


import javax.imageio.ImageIO;
import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import java.io.InputStream;

public class fire {

    private int x, y; // Position of the fire on the map
    private Image frame1, frame2; // Two frames for the animation
    private boolean currentFrame; // Toggles between frame1 and frame2
    private int animationSpeed; // Speed of the animation
    private int frameCounter; // Counts the frames for toggling
    private GamePanel gp;
    private final int width;
    private final int height;


    public fire(GamePanel gp,int x, int y) {
        this.gp = gp; // Assign GamePanel
       this.x = x;
       this.y = y;
        width = 30;
        height = 30;
        this.animationSpeed = 30; // Set animation speed
        this.currentFrame = true; // Start with frame1
        this.frameCounter = 0;
        getImage(); // Load the images
    }


    // Load images for the animation frames
    public void getImage() {
        try {
            InputStream input;

            // Load frame1
            input = getClass().getResourceAsStream("/res/sprites/items/fire1_item.png");
            if (input == null) throw new IOException("Resource not found: fire1_item.png");
            frame1 = ImageIO.read(input);

            // Load frame2
            input = getClass().getResourceAsStream("/res/sprites/items/fire2_item.png");
            if (input == null) throw new IOException("Resource not found: fire2_item.png");
            frame2 = ImageIO.read(input);

        } catch (IOException e) {
            e.printStackTrace(); // Log error for debugging
            throw new RuntimeException("Failed to load fire images!", e);
        }
    }

    // Update the animation
    public void update() {
        frameCounter++;
        if (frameCounter >= animationSpeed) {
            currentFrame = !currentFrame; // Toggle frame
            frameCounter = 0;
        }
    }

    // Render the fire on the screen

    public void render(Graphics g, int playerWorldX, int playerWorldY, int screenX, int screenY) {
        // Calculate the fire's screen position relative to the player
        int screenPosX = x - playerWorldX + screenX;
        int screenPosY = y - playerWorldY + screenY;

        // Check if the fire is within the visible screen
        if (screenPosX + width > 0 && screenPosX < gp.screenWidth &&
                screenPosY + height > 0 && screenPosY < gp.screenHeight) {
            // Render the fire with scaling
            if (currentFrame) {
                g.drawImage(frame1, screenPosX, screenPosY, width, height, null);
            } else {
                g.drawImage(frame2, screenPosX, screenPosY, width, height, null);
            }
        }

    }


}

