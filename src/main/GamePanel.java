package main;


import entity.men;
import entity.nPC_Rat;
import entity.player;
import item.SuperItem;

import res.sprites.items.NoteBook;
import res.sprites.tiles.tileManager;

import javax.swing.*;
import java.awt.*;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;
import javax.swing.text.html.parser.Entity;

public class GamePanel extends JPanel implements Runnable {


    final int originalTileSize = 16;
    final int scale = 3;
   public final int tileSize = 48;
   public final int maxScreenCol = 16;
   public final int maxScreenRow = 12;
   public  final int screenWidth = 768;
    public final int screenHeight = 576;

    int FPS = 60;

    //WORLD SETTINGS

    public final int maxWorldCol = 50;
    public final int maxWorldRow = 50;



   public tileManager tM = new tileManager(this);


    KeyHandler keyH = new KeyHandler();

    public NoteBook nB = new NoteBook(this);


    sounds sound = new sounds();

   public  CollisionCheck cC = new CollisionCheck(this);

   public AssetSetter aSet = new AssetSetter(this);

   public UI ui = new UI(this);
    Thread gameThread;




   public player p = new player(this, keyH);




public SuperItem[] iT = new SuperItem[15];
public nPC_Rat[] rat = new nPC_Rat[10];
public men [] m = new men[13];



    //gameState
    public int dialougeState  = 3;












    public GamePanel() {
        this.setPreferredSize(new Dimension(768, 576));
        this.setBackground(new Color(56, 36, 36));
        this.setDoubleBuffered(true);
        this.addKeyListener(this.keyH);
        this.setFocusable(true);
    }

    public void setUpGame()
    {
        aSet.setItem();
        aSet.setNPC();
//        aSet.setMen();
        aSet.setMen();
        playMusic(0);
    }

    public void StartGameThread() {
        this.gameThread = new Thread(this);
        this.gameThread.start();
    }

    public void run() {
        double drawInterval = (double)(1000000000 / this.FPS);
        double nextDrawTime = (double)System.nanoTime() + drawInterval;

        while(this.gameThread != null) {
            this.update();
            this.repaint();

            double remainingTime = nextDrawTime - (double)System.nanoTime();
            remainingTime /= 1000000.0;
            if (remainingTime < 0.0) {
                remainingTime = 0.0;
            }

            try {
                Thread.sleep((long)remainingTime);
                nextDrawTime += drawInterval;
            } catch (InterruptedException var8) {
                InterruptedException e = var8;
                throw new RuntimeException(e);
            }
        }

    }

    public void update() {

        p.update();
        for(int i = 0; i < rat.length; i++) {
            if (rat[i] != null) {
                rat[i].update();
            }
        }

        for(int i = 0; i < m.length; i++) {
            if (m[i] != null) {
                m[i].update();
            }
        }





    }

    public void paintComponent(Graphics g) {



        if (nB.isOpen)
        {
            nB.renderNotebook(g);
        }
       else {


            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g;




            tM.draw(g2);


            for (int i = 0; i < this.iT.length; i++) {
                if (this.iT[i] != null) {
                    iT[i].draw(g2, this);
                }
            }
            for (int i = 0; i < rat.length; i++)
            {
                if (this.rat[i] != null) {
                    rat[i].draw(g2);
                }
            }



            if (p != null) {

                p.draw(g2); // Ensure player is drawn
            } else {
                System.out.println("Player object is null!");
            }


for (int i = 0; i < m.length; i++)
{
    if (m[i] != null) {


        m[i].draw(g2);



    }
}
              ui.draw(g2);

            if (ui.dialogueOn  ) {


    ui.drawDialogueScreen(g2, "Prison Rat: 'Do you have a favorite letter? mine is i, he he...'");



            }








            g2.dispose();
        }
    }

    public void playMusic (int i)
    {
        sound.setFile(i);
        sound.play();
        sound.loop();
    }

    public void stopMusic ()
    {
        sound.stop();
    }

    public void playSoundEffect (int i)
    {
        sound.setFile(i);
        sound.play();
    }
}
