package proyecto.p4.Ventana.Button;

/**
 *
 * @author Jon
 *
 *
 */
	import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;
public class BotoneraH extends JPanel implements MouseListener {

    private OldWarriorButton oldWarriorButton1;
    private OldWarriorButton oldWarriorButton2;
    private OldWarriorButton oldWarriorButton3;
    private int ButtonP;
	
	private static final long serialVersionUID = 1L;
	
	/** Creates new form BotoneraH */
    public BotoneraH(String Button1, String Button2,String Button3) {

        oldWarriorButton1 = new OldWarriorButton(Button1);
        oldWarriorButton2 = new OldWarriorButton(Button2);
        oldWarriorButton3 = new OldWarriorButton(Button3);

        this.setOpaque(false);
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(oldWarriorButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 134, Short.MAX_VALUE)
            .addComponent(oldWarriorButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(117, 117, 117)
            .addComponent(oldWarriorButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(oldWarriorButton3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(oldWarriorButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(oldWarriorButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getComponent()==oldWarriorButton1){
			ButtonP=1;
		}if(e.getComponent()==oldWarriorButton2){
			ButtonP=2;
		}if(e.getComponent()==oldWarriorButton3){
			ButtonP=3;
		}
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
