import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

class TopPanel extends JPanel{
    Surface surface;
    private JButton infoButton = new JButton("info");
    // TO DO more buttons
    
    TopPanel(Surface surface){
        this.surface = surface;
        
        infoButton.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                        
                }
         });
        this.add(infoButton);
    }  
}

public class Surface extends JFrame {
	
	Container content = this.getContentPane();
	TopPanel top = new TopPanel(this);
		
	public void init() {
		setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));
		
		add(top);
		
	}
		
	public void paint(Graphics g){
		super.paint(g);
		doDrawing();
	}

	public void doDrawing() {}
  
}
