import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;



public class MouseClickListener implements MouseListener{
	
	GameFrame frame;
	MouseClickListener(GameFrame gf){
		this.frame = gf;
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		
		frame.boardClicked(e.getX(), e.getY());
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
