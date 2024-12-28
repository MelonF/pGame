package main;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        new Main();
    }
    public Main() {


        JFrame window = new JFrame();
        window.setDefaultCloseOperation(3);
        window.setResizable(false);
        window.setTitle("l game");
        window.setLocationRelativeTo((Component)null);
        GamePanel gamePanel = new GamePanel();
        window.add(gamePanel);
        window.pack();
        window.setVisible(true);
        gamePanel.requestFocus();
        gamePanel.setUpGame();
        gamePanel.StartGameThread();







    }
}