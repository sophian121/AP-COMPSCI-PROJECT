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
 * This class determines the layout, keys, buttons on the main wordle face. 
 * @author sophia nunez
 *
 */

public class Game {
	 private final static String ALL_LETTERS = "abcdefghijklmnopqrstuvwxyz";

	    private final WordsBank words_bank = new WordsBank();
	    private final JFrame frame = new JFrame("Take a guess!");
	    private final JLabel puzzle_word;
	    private final ArrayList<JButton> letter_buttons = new ArrayList<>();

	    private int number_guesses;
	    private ChosenWord chosen_word;
//Sets fram size + Colour + words on display 
	    Game() {
	        frame.setSize(300, 300);
	        frame.setLocationRelativeTo(null);
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	        JPanel panel = new JPanel(new BorderLayout());
	        puzzle_word = new JLabel("Puzzle: ");
	        panel.add(puzzle_word, BorderLayout.PAGE_START);

	        JPanel grid = new JPanel(new GridLayout(0, 7));
	        for (int i=0; i<ALL_LETTERS.length(); i++) {
	            String letter = ALL_LETTERS.substring(i, i+1);
	            JButton btn = new JButton(letter);
	            btn.setActionCommand(letter);
	            btn.addActionListener(this::guessLetter);
	            letter_buttons.add(btn);
	            grid.add(btn);
	        }
	        panel.add(grid, BorderLayout.CENTER);

	        JButton btn = new JButton("New Game");
	        panel.add(btn, BorderLayout.PAGE_END);
	        btn.addActionListener(ActionEvent -> this.reset());

	        frame.setContentPane(panel);

	        reset();
	        frame.setVisible(true);
	    }

	    //Creates the Reset button
	    private void reset() {
	        chosen_word = new ChosenWord(words_bank.getRandomWord());
	        number_guesses = 0;

	        for(JButton btn : letter_buttons) {
	            btn.setEnabled(true);
	        }

	        update_game_state();
	     }

	    //Will block out button of letter
	    private void guessLetter(ActionEvent evt) {
	        char guessed_letter = evt.getActionCommand().charAt(0);
	        handleUserLetterGuess(guessed_letter);

	        JButton button = (JButton) evt.getSource();
	        button.setEnabled(false);

	        if (chosen_word.isEntireWordGuessed()) {
	            for (JButton btn : letter_buttons) {
	                btn.setEnabled(false);
	            }
	        }
	    }

	    //Updates keys of letters from user
	    private void handleUserLetterGuess(char guessed_char){

	        number_guesses++;
	        chosen_word.charGuess(guessed_char);
	        update_game_state();
	    }
//Update display
	    private void update_game_state() {
	        puzzle_word.setText("The Word: " + chosen_word + ", Number of Guesses: "+ number_guesses);      
	    }
}
