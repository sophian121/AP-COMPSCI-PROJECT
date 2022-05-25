import javax.swing.JFrame; 

/**
 * Controls the start and Sets the Size of panel and ends it 
 * Once it is closed. 
 * @author sophianunez
 *
 */

public class LifeFrame extends JFrame {

	public LifeFrame() {
		
		add(new LifePanel()); 
		
		setSize(1300, 700);
		setVisible(true); 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		
	}

	
	public static void main(String[] args) {
		
		new LifeFrame(); 
		
		
	}
	
	
}
