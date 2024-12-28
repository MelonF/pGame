package item;

import javax.imageio.ImageIO;
import java.io.IOException;

public class itmSpoon extends SuperItem{

    public itmSpoon() {
        name = "spoon";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/res/sprites/items/spoon_item.png"));


        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
