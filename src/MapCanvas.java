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

                Pair<Character, Integer> c = data.getHighestPriorityCharacterAndCount(xx, yy);
                if ( c.first != null){
                    g.drawImage(Tile.DUDE.getSprite(), xx * zoom, yy * zoom, zoom, zoom, null);

                    if( c.second > 1){
                        // font stuff
                        g.setColor(Color.YELLOW);
                        g.setFont(new Font("Monospaced", Font.PLAIN, 12));

                        // calculate the offset to fit in the top right corner
                        FontMetrics fm = g.getFontMetrics();
                        String msg = Integer.toString(c.second);
                        int msgWidth = fm.stringWidth(msg);
                        int msgAscent = fm.getAscent();
                        int msgLeading = fm.getLeading();

                        int x_spot = ((xx + 1) * zoom) - msgWidth;
                        int y_spot = (yy * zoom) + msgAscent + msgLeading;

                        g.drawString(msg, x_spot, y_spot);
                    }
                }
            }
        }

        // draw a
    }


    public void zoomIn(){
        zoom += 1;
    }

    public void zoomOut(){
        zoom -= 1;
    }
}
