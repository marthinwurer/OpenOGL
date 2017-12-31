import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends javax.swing.JFrame {

    private World world;

    private MapCanvas map;

    public MainFrame(World world){
        this.world = world;
        this.map = new MapCanvas(world);
        // Set up a panel for the buttons
        JPanel btnPanel = new JPanel(new FlowLayout());
        JButton btnIn = new JButton("Zoom In");
        btnPanel.add(btnIn);
        btnIn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                map.zoomIn();
                map.repaint();
                requestFocus(); // change the focus to JFrame to receive KeyEvent
            }
        });
        JButton btnOut = new JButton("Zoom Out");
        btnPanel.add(btnOut);
        btnOut.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                map.zoomOut();
                map.repaint();
                requestFocus(); // change the focus to JFrame to receive KeyEvent
            }
        });
        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());
        cp.add(map, BorderLayout.CENTER);
        cp.add(btnPanel, BorderLayout.SOUTH);

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.pack();
        this.requestFocus();
    }





}
