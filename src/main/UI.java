package main;

import item.itmTray;

import java.awt.*;
import java.awt.image.BufferedImage;

public class UI {
Graphics2D g2;
    GamePanel gp;
    Font roman_forty;
    BufferedImage keyImage;
    public boolean messageOn = true;
    public String message = "";
    public int messageCounter = 0;
    public boolean dialogueOn;
    public int dialogueCounter = 0;

    public UI(GamePanel gp) {
        this.gp = gp;
        roman_forty = new Font("Times New Roman", Font.BOLD, 20);

        dialogueOn = false;

    }

    public void showMessage(String text) {
        message = text;
        messageOn = true;

    }

    public void draw(Graphics2D g2) {
        this.g2 = g2; // Save g2 for use in other methods

        if (messageOn) {
            // Display a simple message
            g2.setFont(roman_forty);
            g2.setColor(Color.BLACK);
            g2.drawString(message, 30, 40);

            // Increment the message counter
            messageCounter++;
            if (messageCounter == 300) {
                messageCounter = 0;
                messageOn = false;
            }




        }
    }

    public void drawDialogueScreen(Graphics2D g2, String text) {
        if (dialogueCounter < 400) {
            dialogueCounter++;
            if (g2 == null) {
                System.out.println("Graphics2D object is null!"); // Debugging message
                return;
            }


            int x = gp.tileSize * 2;
            int y = gp.tileSize / 2;
            int width = gp.screenWidth - (gp.tileSize * 3);
            int height = gp.tileSize * 2;

// Draw the background with rounded corners
            g2.setColor(Color.BLACK);
            g2.fillRoundRect(x, y, width, height, 35, 35);

// Draw the border
            g2.setColor(Color.WHITE);
            g2.setStroke(new BasicStroke(5));
            g2.drawRoundRect(x, y, width, height, 20, 20);

// Set text color and font
            g2.setColor(Color.WHITE);
            g2.setFont(new Font("Times New Roman", Font.PLAIN, 24));

// Split the text into multiple lines
            String[] lines = text.split("\n");

// Calculate the height of each line
            int lineHeight = g2.getFontMetrics().getHeight();

// Draw each line of text
            for (int i = 0; i < lines.length; i++) {
                g2.drawString(lines[i], x + 20, y + gp.tileSize + (i * lineHeight)); // Adjust y-position for each line
            }


        } else if (dialogueCounter <= 400) {
            dialogueOn = false;
            dialogueCounter = 0;

        }


    }





}



