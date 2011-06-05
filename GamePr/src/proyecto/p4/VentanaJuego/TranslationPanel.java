package proyecto.p4.VentanaJuego;

import java.awt.event.MouseListener;

import javax.swing.JPanel;


public class TranslationPanel extends JPanel implements MouseListener{
	
	boolean mover = false;

	private static final long serialVersionUID = 1L;

	public TranslationPanel(){
		this.setOpaque(false);
		this.addMouseListener(this);
	}

	@Override
	public void mouseClicked(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
			mover = true;
		
	}

	@Override
	public void mouseExited(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
		mover = false;
	}

	public boolean isMover() {
		return mover;
	}

	public void setMover(boolean mover) {
		this.mover = mover;
	}

	@Override
	public void mousePressed(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	

}
