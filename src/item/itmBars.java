package item;

import javax.imageio.ImageIO;
import java.io.IOException;

public class itmBars extends SuperItem{
    public itmBars() {
        name = "bars";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/res/sprites/items/bars_item.png"));


        } catch (IOException e) {
            e.printStackTrace();
        }
        collision = true;
    }
}
