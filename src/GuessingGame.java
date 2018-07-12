import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GuessingGame extends JFrame {
	private JTextField txtGuess;
	private JLabel lblOutput;
	private int theNumber;

	public void checkGuess() {
		String guessText = txtGuess.getText();
		String message = "";
		try {		
			int guess = Integer.parseInt(guessText);

			if (guess < theNumber)
				message = guess + " is too low. Try again";
			else if (guess > theNumber)
				message = guess + " is too high. Try again";
			else
			{message = guess + " is correct. You win! Let's play again!";
			newGame();}}
		catch (Exception e)
		{message = "Enter the whole number between 1 and 100";}
		finally{
			lblOutput.setText(message);
			txtGuess.requestFocus();
			txtGuess.selectAll();
		}
	}
	public void newGame() {
		theNumber = (int) (Math.random() * 100 + 1);
	}

	public GuessingGame() {
		getContentPane().setFont(new Font("Konfuciuz Fat", Font.BOLD, 12));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Dr Payne's Hi Lo  Guessing Game");
		getContentPane().setLayout(null);

		JLabel lblDrPaynesHilo = new JLabel("Dr Payne's HiLo Guessing Game");
		lblDrPaynesHilo.setFont(new Font("Konfuciuz Fat", Font.PLAIN, 20));
		lblDrPaynesHilo.setHorizontalAlignment(SwingConstants.CENTER);
		lblDrPaynesHilo.setBounds(58, 43, 401, 20);
		getContentPane().add(lblDrPaynesHilo);

		JLabel lblGuessANumber = new JLabel("Guess a number between 1 and 100");
		lblGuessANumber.setHorizontalAlignment(SwingConstants.CENTER);
		lblGuessANumber.setBounds(86, 106, 275, 20);
		getContentPane().add(lblGuessANumber);

		txtGuess = new JTextField();
		txtGuess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				checkGuess();
			}
		});
		txtGuess.setHorizontalAlignment(SwingConstants.LEFT);
		txtGuess.setBounds(361, 107, 38, 19);
		getContentPane().add(txtGuess);
		txtGuess.setColumns(10);

		JButton btnGuess = new JButton("Guess!");
		btnGuess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				checkGuess();
			}
		});
		btnGuess.setFont(new Font("Konfuciuz", btnGuess.getFont().getStyle(), btnGuess.getFont().getSize() + 5));
		btnGuess.setBounds(212, 169, 117, 25);
		getContentPane().add(btnGuess);

		lblOutput = new JLabel("Enter a number above and click Guess!");
		lblOutput.setHorizontalAlignment(SwingConstants.CENTER);
		lblOutput.setBounds(12, 237, 489, 15);
		getContentPane().add(lblOutput);
	}

	public static void main(String[] args) {
		GuessingGame theGame = new GuessingGame();
		theGame.newGame();
		theGame.setSize(new Dimension(450, 300));
		theGame.setVisible(true);
	}
}
