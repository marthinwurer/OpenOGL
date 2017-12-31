import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static javax.imageio.ImageIO.read;

public class MapCanvas extends JPanel {

    public static BufferedImage sprite;

    static {
        try {
            sprite = read(new File("graphics/0000_floor_default.bmp"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    World data;

    double cx = 0.0; // center x
    double cy = 0.0; // center y
    int zoom = 64;

    MapCanvas(World data){
        this.data = data;
        this.setPreferredSize(new Dimension(data.getWidth() * zoom, data.getHeight() * zoom));
    }

    public void paintComponent(Graphics g){

        // start from the top left and draw the tiles
        for(int yy = 0; yy < data.getHeight(); yy++){
            for (int xx = 0; xx < data.getWidth(); xx++){

                g.drawImage(data.getTile(xx, yy).getSprite(), xx * zoom, yy * zoom, zoom, zoom, null);
            }
        }
    }


    public void zoomIn(){
        zoom += 1;
    }

    public void zoomOut(){
        zoom -= 1;
    }
}
