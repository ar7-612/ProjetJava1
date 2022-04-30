package Vue;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.InputStream;

public class Imagegaufre {
    Image img;

    Imagegaufre(InputStream in) {
        try {
            // Chargement d'une image utilisable dans Swing
            img = ImageIO.read(in);
        } catch (Exception e) {
            System.out.println();
            System.exit(1);
        }
    }

    Image image() {
        return img;
    }
}
