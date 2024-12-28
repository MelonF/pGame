package item;

import main.GamePanel;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.IOException;

public class itmCodeDoor extends SuperItem {

    public itmCodeDoor() {

        name = "codeDoor";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/res/sprites/items/bars_item.png"));


        } catch (IOException e) {
            e.printStackTrace();
        }
        collision = true;

    }

    @Override
    public void playerInteractWithDoor(SuperItem door, GamePanel gp) {
        if (!(door instanceof itmCodeDoor)) {
            System.out.println("This is not a door.");
            return;
        }

        itmCodeDoor codeDoor = (itmCodeDoor) door;

        if (!codeDoor.collision) { // Already unlocked
            System.out.println("The door is already open.");
            return;
        }
        gp.p.isInteracting = true;

        resetMovementKeys(gp);
        String input = JOptionPane.showInputDialog("Enter the code to open the door:");
        if (input != null) {
            if (enterCode(input, codeDoor)) {
                System.out.println("The door opens!");
            } else {
                System.out.println("Incorrect code. The door remains closed.");
            }
        } else {
            System.out.println("You canceled the interaction.");
        }
        gp.p.isInteracting = false;
    }

    public boolean enterCode(String input, itmCodeDoor door) {
        if (input.equals("18")) {
            door.collision = false;
            return true;
        }
        return false;
    }

    private void resetMovementKeys(GamePanel gp) {
        gp.p.keyH.upPressed = false;
        gp.p.keyH.downPressed = false;
        gp.p.keyH.leftPressed = false;
        gp.p.keyH.rightPressed = false;
    }
}

