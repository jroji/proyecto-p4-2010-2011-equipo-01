package proyecto.p4.Ventana.JPanels;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

	public class JPanelFondo extends JPanel {

	    /**
		 * 
		 */
		private static final long serialVersionUID = -706322407912320098L;
		private Image imagen;

	    public JPanelFondo() {
	    }

	    public JPanelFondo(String nombreImagen) {
	        if (nombreImagen != null) {
	            imagen = new ImageIcon(getClass().getResource(nombreImagen)).getImage();
	        }
	    }

	    public JPanelFondo(Image imagenInicial) {
	        if (imagenInicial != null) {
	            imagen = imagenInicial;
	        }
	    }

	    public void setImagen(String nombreImagen) {
	        if (nombreImagen != null) {
	            imagen = new ImageIcon(getClass().getResource(nombreImagen)).getImage();
	        } else {
	            imagen = null;
	        }

	        repaint();
	    }

	    public void setImagen(Image nuevaImagen) {
	        imagen = nuevaImagen;

	        repaint();
	    }

	    @Override
	    public void paint(Graphics g) {
	        if (imagen != null) {
	            g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);

	            setOpaque(false);
	        } else {
	            setOpaque(true);
	        }

	        super.paint(g);
	    }
}
