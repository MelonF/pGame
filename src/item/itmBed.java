package item;

import javax.imageio.ImageIO;
import java.io.IOException;

public class itmBed extends SuperItem {

    public itmBed() {
        name = "bed";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/res/sprites/items/bedFixed_itm.png"));


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
