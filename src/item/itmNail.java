package item;

import javax.imageio.ImageIO;
import java.io.IOException;

public class itmNail extends SuperItem{

    public itmNail() {
        name = "nail";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/res/sprites/items/nailFloor_itm.png"));


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
