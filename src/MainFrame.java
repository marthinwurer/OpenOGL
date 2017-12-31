import java.awt.*;

public class MainFrame extends javax.swing.JFrame {

    private World world;

    private MapCanvas map;

    public MainFrame(World world){
        this.world = world;
        this.map = new MapCanvas(world);
        this.setContentPane(map);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }





}
