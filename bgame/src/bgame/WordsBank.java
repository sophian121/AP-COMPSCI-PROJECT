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


//Provide the words that will be guessed and get a random word from bank to be played. 

public class WordsBank {

	private final static String[] words = { "hello", "glows", "jolly", "loved", "smile",
            "bloom", "adore", "candy", "fancy", "dream" };

    private final Random rand = new Random();
//Gets a random word that will be the Guessed word
    public String getRandomWord() {
        return words[rand.nextInt(words.length)];
    }
	
	
	
	
}
