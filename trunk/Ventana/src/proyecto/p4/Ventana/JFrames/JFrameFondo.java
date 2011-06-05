package proyecto.p4.Ventana.JFrames;

import java.awt.Image;
import javax.swing.JFrame;

import proyecto.p4.Ventana.JPanels.JPanelFondo;

	public class JFrameFondo extends JFrame {

	    /**
		 * 
		 */
		private static final long serialVersionUID = 8654194885150280729L;
		private final JPanelFondo contenedor = new JPanelFondo();

	    public JFrameFondo() {
	        setContentPane(contenedor);
	    }

	    public void setImagen(String nombreImagen) {
	        contenedor.setImagen(nombreImagen);
	    }

	    public void setImagen(Image nuevaImagen) {
	        contenedor.setImagen(nuevaImagen);
	    }
	}

