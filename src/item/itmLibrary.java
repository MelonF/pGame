package item;

import javax.imageio.ImageIO;
import java.io.IOException;

public class itmLibrary extends SuperItem {

    public itmLibrary() {
        name = "library";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/res/sprites/items/library_itm.png"));


        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
