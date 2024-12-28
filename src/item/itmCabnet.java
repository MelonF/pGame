package item;

import javax.imageio.ImageIO;
import java.io.IOException;

public class itmCabnet extends SuperItem {


    public itmCabnet() {
        name = "cabnet";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/res/sprites/items/cabit_itm.png"));


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
