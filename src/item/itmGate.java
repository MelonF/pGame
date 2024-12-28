package item;

import javax.imageio.ImageIO;
import java.io.IOException;

public class itmGate extends SuperItem {


    public itmGate() {
        name = "gate";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/res/sprites/items/gate_item.png"));


        } catch (IOException e) {
            e.printStackTrace();
        }
        collision = true;


    }
}

