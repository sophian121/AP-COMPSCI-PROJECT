package bgame;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Main {

	//Starts game 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        SwingUtilities.invokeLater(Game::new);

	}

}
