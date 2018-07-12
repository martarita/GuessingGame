import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

//zmienne powinny być private bo nie chcemy by spoza klasy coś mogło na nie wpływać - jak do konta bankowego ma dostep tylko jego właściciel
public class GuessingGame extends JFrame {
	private JTextField txtGuess;
	private JLabel lblOutput;
	 JButton btnPlayAgain; //tu zdefiniowany bo musi byc dostepny w różnych miejscach
	private int theNumber;
private int numberOfTries;

	

	// 1. pobiera z pola tekstowego wartość,przerabia txt na int sprawdza czy odpowiada randomowej wartości  do zgadnięcia
	// tu program może się wywalić wiec jest try  -co srawdzamy catch - działanie gdy się wywali,fachowo -wystąpi wyjątek,
	//finally - działanie gdy jest ok

	//2. metody są public bo chcemy by były dostępne tak jak funkcja wpłacania pieniędzy na konto jst dostepna publicznie

	public void checkGuess() {
		String guessText = txtGuess.getText();  //zawartość pola tekstowego staje sie zmienna typu string
		
		
		int maxNumberOfTries=8;
		String message = "";    //iniciowanie komunikatu - konsolowa wersja- na razie bez zawartości
		try {		
			int guess = Integer.parseInt(guessText);  // przerobienie tekstu na inta
			numberOfTries++;
			if ((guess < theNumber) && (numberOfTries) <= (maxNumberOfTries))    //
			{message = guess + " is too low. Try again";}
			else if ((guess > theNumber) && (numberOfTries <= maxNumberOfTries))
				message = guess + " is too high. Try again";  
			else if ((guess > theNumber) && (numberOfTries > maxNumberOfTries))
			{message = "Game Over! Let's play again!";
			btnPlayAgain.setVisible(true);}
			else if ((guess < theNumber) && (numberOfTries > maxNumberOfTries))
			{message =  "Game Over! Let's play again!";
			btnPlayAgain.setVisible(true);}
		
		// komunikaty, które się wyświetlają w zaleznosci czy wpisana wart jest za niska za wysoka czy ok + ilość prób 
		//guess to int powstały ze stringa guessText wyjętego z pola tekstowego txtGuess
		else
		{message = guess + " is correct. You win after " + numberOfTries +" tries ! Let's play again!"; //tekst o wygranej
		btnPlayAgain.setVisible(true);
	}}  //metoda -ponieważ po wygranej chemy zagrać raz jeszcze
	catch (Exception e)
	{message = "Enter the whole number between 1 and 100";}
	finally{
		lblOutput.setText(message);  //message to zmienna "konsolowa" której wartośc chcemy pokazać w etykiecie w oknie
		txtGuess.requestFocus();   //dzięki temu kursor znajduje sie znowu w polu tekstowym 
		txtGuess.selectAll();   // zaznacza cały tekst w olu tekstowym co ułatwia korzystanie z gry - nie trzeba mozolnie kasować
		
	}
}
public void newGame() { //rozpoczecie gry wylosowanie liczby
	theNumber = (int) (Math.random() * 100 + 1);
	numberOfTries=0;
	btnPlayAgain.setVisible(false);
}

public GuessingGame() // to w większości genruje sie samo po budowaniu okna w window builiderze i dotyczy elementów okna i ich ustawień
{   
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
	lblGuessANumber.setBounds(86, 93, 275, 20);
	getContentPane().add(lblGuessANumber);

	txtGuess = new JTextField();
	txtGuess.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) { //po wpisaniu w pole tekstowe i przycisnięciu na klawiaturze ENTER przywołana jest metoda sprawdzajaca warunki jak to co wpisane ma się do randoma
			checkGuess();
		}
	});
	txtGuess.setHorizontalAlignment(SwingConstants.LEFT);
	txtGuess.setBounds(361, 94, 38, 19);
	getContentPane().add(txtGuess);
	txtGuess.setColumns(10);

	JButton btnGuess = new JButton("Guess!");
	btnGuess.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) { //przycisniecie buttona guess wywołuje metode sprawdzania poprawnosci odowiedzi (warunki)
			checkGuess();
		}
	});
	btnGuess.setFont(new Font("Konfuciuz", btnGuess.getFont().getStyle(), btnGuess.getFont().getSize() + 5));
	btnGuess.setBounds(198, 143, 117, 25);
	getContentPane().add(btnGuess);

	lblOutput = new JLabel("Enter a number above and click Guess!");
	lblOutput.setHorizontalAlignment(SwingConstants.CENTER);
	lblOutput.setBounds(12, 198, 489, 15);
	getContentPane().add(lblOutput);
	
	btnPlayAgain = new JButton("Play again");
	btnPlayAgain.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			newGame();}   //przycisniecie Play Again powoduje rozpoczecie na nowo gry
	});
	btnPlayAgain.setBounds(198, 243, 117, 25);
	
	getContentPane().add(btnPlayAgain);
	
}

public static void main(String[] args) {
	GuessingGame theGame = new GuessingGame(); //tworzymy obiekt gra - budujemy okno zgodnie z "projektem" GuessingGame, okno jeszcze nie wdoczne
	theGame.newGame(); //rozpoczynamy gre z nowa liczba
	theGame.setSize(new Dimension(450, 300)); //okno o wymiarach...to tez instrukcie
	theGame.setVisible(true);    //staje sie widoczne
	
}
}

//metoda guessing game- "layout"- odwołuje się do metody checkGuess, nic nie jest pominięte

