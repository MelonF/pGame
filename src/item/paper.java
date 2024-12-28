package item;

import javax.imageio.ImageIO;
import java.io.IOException;

public class paper extends SuperItem{


    public paper() {
        name = "paper";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/res/sprites/items/paper_item.png"));


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
