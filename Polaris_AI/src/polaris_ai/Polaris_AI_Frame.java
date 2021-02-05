package polaris_ai;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import java.net.URL;
import javax.swing.JFrame;

public class Polaris_AI_Frame extends JFrame
{
    public static final int FRAME_HEIGHT = 600;
    public static final int FRAME_WIDTH = 1120;
    
    public Polaris_AI_Frame(URL media_url, URL left_url, URL right_url)
    {
        super("Polaris_AI");
        
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int w = (int) (screenSize.getWidth() / 2 - FRAME_WIDTH / 2);
        int h = (int) (screenSize.getHeight() / 2 - FRAME_HEIGHT / 2) - 10;
        
        Polaris_AI_Panel new_panel = new Polaris_AI_Panel(media_url, left_url, right_url);
        new_panel.setBounds(0, 0, FRAME_WIDTH, FRAME_HEIGHT);
        this.add(new_panel);
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        this.setLocation(new Point(w, h));
        this.setLayout(null);
        this.setVisible(true);
    }
}
