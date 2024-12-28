package entity;

import item.SuperItem;

import main.GamePanel;
import main.KeyHandler;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public class player extends entity{


    public KeyHandler keyH;
    private boolean keyHandled = false;


    public final int screenX;
    public final int screenY;

    public int pinCounter = 0;
    public int keyCounter = 0;

    public boolean isInteracting = false;







    public player (GamePanel gp, KeyHandler keyH) {



      super(gp);

        this.keyH = keyH;



        screenX = gp.screenWidth/2 - (gp.tileSize/2);
        screenY = gp.screenHeight/2 - (gp.tileSize/2);



        solidArea = new Rectangle(12, 20, 20, 20);
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;


        setDefault();
        getPlayerImage();
    }


    public void setDefault ()
    {



        worldx = gp.tileSize * 23;
        worldy = gp.tileSize * 21;
        speed = 4;
        direction = "down";


    }

    public void getPlayerImage ()
    {


     //up 1 = setup()
    // up2 = setup()








        try {
            InputStream input;

            input = getClass().getResourceAsStream("/res/sprites/p_up1.png");
            if (input == null) throw new IOException("Resource not found: lem_up1.png");
            up1 = ImageIO.read(input);

            input = getClass().getResourceAsStream("/res/sprites/p_up2.png");
            if (input == null) throw new IOException("Resource not found: lem_up2.png");
            up2 = ImageIO.read(input);

            input = getClass().getResourceAsStream("/res/sprites/p_down1.png");
            if (input == null) throw new IOException("Resource not found: lem_down1.png");
            down1 = ImageIO.read(input);

            input = getClass().getResourceAsStream("/res/sprites/p_down2.png");
            if (input == null) throw new IOException("Resource not found: lem_down2.png");
            down2 = ImageIO.read(input);

            input = getClass().getResourceAsStream("/res/sprites/p_right1Fixed.png");
            if (input == null) throw new IOException("Resource not found: lem_right1.png");
            right1 = ImageIO.read(input);

            input = getClass().getResourceAsStream("/res/sprites/p_right2.png");
            if (input == null) throw new IOException("Resource not found: lem_right2.png");
            right2 = ImageIO.read(input);

            input = getClass().getResourceAsStream("/res/sprites/p_left1Fixed.png");
            if (input == null) throw new IOException("Resource not found: lem_left1.png");
            left1 = ImageIO.read(input);

            input = getClass().getResourceAsStream("/res/sprites/p_left2.png");
            if (input == null) throw new IOException("Resource not found: lem_left2.png");
            left2 = ImageIO.read(input);

            System.out.println("All images loaded successfully!");

        } catch (IOException e) {
            System.err.println("Failed to load an image: " + e.getMessage());
            e.printStackTrace();
        }


    }


































//    public BufferedImage setup(String imageName)
//    {
//
//
//        try {
//            InputStream input;
//
//            input = getClass().getResourceAsStream("/res/sprites/lem_left2.png");
//            if (input == null) throw new IOException("Resource not found: lem_left2.png");
//            left2 = ImageIO.read(input);
//
//            System.out.println("All images loaded successfully!");
//
//        } catch (IOException e) {
//            System.err.println("Failed to load an image: " + e.getMessage());
//            e.printStackTrace();
//        }
//    return 1;
//
//        }





    public void update() {

        if (isInteracting) {

            return;
        }




            if (keyH.nPressed) {
                gp.nB.isOpen = true;
            } else {
                gp.nB.isOpen = false;
            }


            if (keyH.upPressed == true || keyH.downPressed == true || keyH.leftPressed == true || keyH.rightPressed == true) {
                if (this.keyH.upPressed) {
                    direction = "up";

                } else if (this.keyH.downPressed) {
                    direction = "down";

                } else if (this.keyH.leftPressed) {
                    direction = "left";

                } else if (this.keyH.rightPressed) { // Correctly associate the block
                    direction = "right";

                }


                //check collision
                on = false;
                gp.cC.checkCollision(this);

                //check item collsion

                int itemIndex = gp.cC.checkItem(this, true);
                pickUpItem(itemIndex);
                //checl npc collsion
                int npcIndex = gp.cC.checkEntity(this, gp.rat);
                interactNPCRat(npcIndex);

                int menIndex = gp.cC.checkEntity(this,gp.m);
                interactNPCMen(menIndex);

//            int npcIndex = gp.cC.checkEntity(this, gp.npc);
//            interactNpc(npcIndex);
//

                //if collision is false, player can move
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

                spriteCounter++;

                if (spriteCounter > 12) {
                    if (spriteNum == 1) {
                        spriteNum = 2;
                    } else if (spriteNum == 2) {
                        spriteNum = 1;
                    }
                    spriteCounter = 0;
                }
            }




    }






    public void pickUpItem(int i)
    {
        if (i != 999)
        {
            String itemName = gp.iT[i].name;

            switch (itemName) {
                case "key":
                    gp.playSoundEffect(2);

                    gp.iT[i] = null;
                    gp.ui.showMessage("You found a key!");

                    gp.tM.tile[6].collision = false;
                    break;

                case "spoon":
                    gp.playSoundEffect(2);

                    if (keyH.iPressed) {
                        gp.iT[i] = null;
                        gp.ui.showMessage("You found a spoon!");
                        pinCounter++;
                    }
                    break;

                case "cabnet":
                    if(keyH.iPressed)
                    {
                      gp.ui.showMessage("There's a note inside: rtnfeigtkc ?  ");
                    }


                    break;
                case "bed":

                    gp.playSoundEffect(2);

                    if (keyH.iPressed) {
                        gp.ui.showMessage("You found a bed spring!");
                        pinCounter++;
                    }
                    break;

                case "bars":
                    gp.playSoundEffect(2);
                    if (pinCounter > 3 && keyH.iPressed) {

                        gp.iT[i].collision = false;
                        gp.ui.showMessage("Lock picked!");

                    }
                    break;

                case "nail":
                    gp.playSoundEffect(2);
                    if (keyH.iPressed) {
                        gp.iT[i] = null;
                        gp.ui.showMessage("You found a nail!");
                        pinCounter++;
                        System.out.println(pinCounter);
                    }
                    break;

                case "paper":
                    gp.playSoundEffect(2);

                    gp.iT[i] = null;
                    gp.ui.showMessage("Journal Entry Found, press n");
                    gp.nB.addEntries("I know no one will read this...");
                    gp.nB.addEntries("But I must write...");
                    gp.nB.addEntries("All I am given to eat is oatmeal cookies");
                    gp.nB.addEntries("and to drink, Vigenere");
                    gp.nB.addEntries("I am a terrible writer, I hate big words");
                    gp.nB.addEntries("They feel glabrous on my tongue");
                    gp.nB.addEntries("What a shame I will die here.");
                    gp.nB.addEntries("On Christmas.");





                    break;

                case "bBush":
                    gp.playSoundEffect(2);
                    gp.nB.addEntries("you have a place for everything");
                    gp.iT[i] = null;
                    gp.ui.showMessage("You found a ButterflyBush (Press N to open NoteBook)");
                    break;

                case "codeDoor":


                    if (keyH.iPressed && !keyHandled) {
                        keyHandled = true; // Mark the key as handled
                        gp.iT[i].playerInteractWithDoor(gp.iT[i], gp);
                    }

                    if (!keyH.iPressed) {
                        keyHandled = false; // Reset when the key is released
                    }
                    break;


                case "library":
                    gp.ui.showMessage("A Library...?");

                    break;








            }





        }




    }



    public void interactNPCRat(int i)
    {
if (i != 999 )
{

 gp.ui.dialogueOn = true;

}
    }



public void interactNPCMen(int i)
{
    if (i != 999)
    {
        worldx = gp.tileSize * 23;
        worldy = gp.tileSize * 21;
    }
}









//    public void update() {d
//
//        if (keyH.upPressed == true || keyH.downPressed == true || keyH.leftPressed == true || keyH.rightPressed == true)
//        {
//            if (this.keyH.upPressed) {
//                direction = "up";
//                worldy -= speed;
//            } else if (this.keyH.downPressed) {
//                direction = "down";
//                worldy += speed;
//            } else if (this.keyH.leftPressed) {
//                direction = "left";
//                worldx -= speed;
//            } else if (this.keyH.rightPressed) {
//                direction = "right";
//                worldx += speed;
//            }
//            spriteCounter++;
//
//            if (spriteCounter > 12) {
//                if (spriteNum == 1) {
//                    spriteNum = 2;
//                } else if (spriteNum == 2) {
//                    spriteNum = 1;
//                }
//                spriteCounter = 0;
//            }
//        }
//
//        worldx = Math.max(0, Math.min(worldx, gp.maxWorldCol * gp.tileSize - gp.screenWidth));
//        worldy = Math.max(0, Math.min(worldy, gp.maxWorldRow * gp.tileSize - gp.screenHeight));
//
//    }

@Override
    public void draw (Graphics2D g2) {

//g2.setColor(Color.white);
//g2.fillRect(x,y,gp.tileSize,gp.tileSize );


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
