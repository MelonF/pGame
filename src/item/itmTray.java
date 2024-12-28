package item;

import javax.imageio.ImageIO;
import java.io.IOException;

public class itmTray extends SuperItem {

    public itmTray() {
        name = "tray";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/res/sprites/items/tray_item.png"));


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
