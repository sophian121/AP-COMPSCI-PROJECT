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

/**
 * Class control the words guessed. 
 * @author sophianunez
 * 
 */


public class ChosenWord {
	private String word;
    private boolean[] chars_guessed; 

    public ChosenWord(String word){
    	
    	//Determines if characters types are the word
    	
        this.word = word.toLowerCase();
        chars_guessed = new boolean[word.length()]; }
        public boolean isEntireWordGuessed() {

            for (boolean b : chars_guessed) {
                if (!b)
                    return false;
            }

            return true;}
        
        
        //If the character guessed is in the right spot
        public void charGuess(char guess) {
            int index = word.indexOf(guess);
            while (index >= 0) {
                chars_guessed[index] = true; 
                index = word.indexOf(guess, index + 1);
            }
        }

        // Strings together guesses 
        
        @Override
        public String toString(){
            StringBuilder formatted_word = new StringBuilder();

            for(int index = 0; index < word.length(); index++) {
                if (chars_guessed[index]) {
                    formatted_word.append(word.charAt(index));
                } else {
                    formatted_word.append('_');
                }

                formatted_word.append(' ');
            }

            return formatted_word.toString();
        }
}
