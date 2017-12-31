import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static javax.imageio.ImageIO.read;

public enum Tile {

    FLOOR("FLOOR", "graphics/0000_floor_default.bmp");

    private final BufferedImage sprite;
    private final String name;

    Tile(String name, String filename){
        this.name = name;
        BufferedImage sprite1;
        try {
            sprite1 = read(new File(filename));
        } catch (IOException e) {
            sprite1 = null;
            e.printStackTrace();
        }
        sprite = sprite1;
    }

    public BufferedImage getSprite() {
        return sprite;
    }

    @Override
    public String toString() {
        return name;
    }
}
