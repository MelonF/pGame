package item;

import javax.imageio.ImageIO;
import java.io.IOException;

public class itmKey extends SuperItem {


    public itmKey() {
        name = "key";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/res/sprites/items/gateKey_item.png"));


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
