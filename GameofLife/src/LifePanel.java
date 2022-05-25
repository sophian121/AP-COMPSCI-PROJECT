
import javax.swing.JPanel;
import javax.swing.Timer; 
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/** @author Sophia Nuñez APCSA 
* this class is respnsible for the colours of cells and board it displays, 
* where cells respawn, and where cells generated. 
*/ 
public class LifePanel extends JPanel implements ActionListener{

	int xPanel = 1300; 
	int yPanel = 700; 
	
	int size = 10; 
	int xWidth = xPanel / size; 
	int yHeight = yPanel / size; 

	int [][] life = new int [xWidth][yHeight];
	int [][] beforeLife = new int [xWidth][yHeight];
	
	boolean starts = true; 

	//backgorund Blak
	public LifePanel() {
		
		setSize(xPanel ,yPanel); 
		setLayout(null); 
		setBackground(Color.BLACK);
		
		new Timer(80, this).start(); 
		
	}
	//COLOURS
	public void paintComponent(Graphics g) {
		
		
		super.paintComponent(g);
		
		
		
		grid(g);
		
		spawn(g); 
		display(g);  
		
	}
	//COLOURS
	private void grid(Graphics g) {
		
		g.setColor(Color.DARK_GRAY);
		
		for (int i = 0; i < life.length; i++) {
			 
			g.drawLine(0, i * size, xPanel, i * size); //row
			g.drawLine(i * size, 0, i * size, yPanel); 
			
			
			
		}
	}
	//WHERE WILL SPAWN ON DISPLAY
	private void spawn(Graphics g ) {
		
		if (starts) {
			for( int x = 0; x < life.length; x++ ) {
				for ( int y = 0; y < (yHeight); y++) {
					
					if (  (int )(Math.random() * 5) ==0 ) {
						beforeLife[x][y] = 1; 
					}
					
				}
			}
			starts = false; 
		}
		
	}
//COLOUR OF CELLS	
	private void display(Graphics g) {
		g.setColor(Color.GREEN);
		
		copyArray(); 
		
		for( int x = 0; x < life.length; x++ ) {
			for ( int y = 0; y < (yHeight); y++) {
				
				if(life[x][y] == 1) {
				
				g.fillRect(x * size, y * size, size, size); 
								
			}
		}
	}
}
	private void copyArray() {
		for( int x = 0; x < life.length; x++ ) {
			for ( int y = 0; y < (yHeight); y++) {
				
				life[x][y]= beforeLife[x][y] ; 
				
		}
	}
	}
	//CHECK IF ALIVE
	private int check(int x, int y) {
		int alive = 0; 
		
		alive += life[(x+ xWidth - 1) % xWidth][(y + yHeight - 1) % yHeight]; 
		alive += life [(x+ xWidth ) % xWidth][(y + yHeight - 1) % yHeight];
		
		
		alive += life [(x+ xWidth + 1) % xWidth][(y + yHeight - 1) % yHeight];
		alive += life [(x+ xWidth - 1) % xWidth][(y + yHeight) % yHeight]; 
		
		
		alive += life [(x+ xWidth + 1) % xWidth][(y + yHeight) % yHeight]; 
		alive += life [(x+ xWidth - 1) % xWidth][(y + yHeight + 1) % yHeight]; 
		
		
		alive += life [(x+ xWidth) % xWidth][(y + yHeight + 1) % yHeight]; 
		alive += life [(x+ xWidth + 1)% xWidth][(y + yHeight + 1) % yHeight]; 
		
		return alive; 
	}
	//IF ALIVE REPAINT 
	public void actionPerformed(ActionEvent e) {
		
		int alive; 
		
		for ( int x = 0; x < life.length; x++) {
			for (int y = 0; y < (yHeight) ; y++) {
			
				 alive = check(x,y ); 

				if (alive == 3) {
					beforeLife[x][y] = 1; 
				}
				else if(alive == 2 && life[x][y] == 1) {
					beforeLife[x][y] = 1; 
				}
				else {
					beforeLife[x][y] = 0; 
				}
			}
		}
		
		
		repaint(); 
		
	}
	
}
