import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import java.awt.GridLayout;
import java.awt.Color;
import javax.swing.BoxLayout;
import java.awt.CardLayout;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Frame extends JFrame {

	private JPanel contentPanel;
	private JTextField txtMaximum;
	private JTextField txtBestScore;
	private JTextField txtGuesses;
	private JTextField numberfield;
	
	private Random random = new Random();
	private int maximum;
	private int guess;
	private int guessNumber;
	private int tryes = 0;
	private int highscore = -1;
	private JTextField txtAnswer;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame frame = new Frame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void game() {
		guess = Integer.parseInt(numberfield.getText());
		
		if(guess < guessNumber) {
			tryes++;
			txtGuesses.setText(String.valueOf(tryes));
			txtAnswer.setBackground(new Color(0, 0, 0));
			txtAnswer.setBackground(new Color(0, 255, 255));
			txtAnswer.setText(guess + " is too Low.");
		}
		else if(guess > guessNumber) {
			tryes++;
			txtGuesses.setText(String.valueOf(tryes));
			txtAnswer.setText(guess + " is too High.");
		}
		else {
			tryes++;
			txtGuesses.setText(String.valueOf(tryes));
			txtAnswer.setText("You guessed the right Number!!!");
			numberfield.setEditable(false);
			if (tryes < highscore || highscore ==-1) {
				highscore = tryes;
				txtBestScore.setText(String.valueOf(tryes));
			} 
		}
	}
	
	/**
	 * Create the frame.
	 */
	public Frame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 813, 459);
		contentPanel = new JPanel();
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPanel);
		contentPanel.setLayout(null);
		
		JPanel optionPanel = new JPanel();
		optionPanel.setBackground(Color.WHITE);
		optionPanel.setBounds(10, 11, 244, 398);
		contentPanel.add(optionPanel);
		optionPanel.setLayout(null);
		
		JLabel OptionsLabel = new JLabel("Options");
		OptionsLabel.setEnabled(true);
		OptionsLabel.setForeground(Color.WHITE);
		OptionsLabel.setBounds(86, 7, 68, 24);
		OptionsLabel.setFont(new Font("Dialog", Font.BOLD, 18));
		optionPanel.add(OptionsLabel);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 255));
		panel.setBounds(0, 0, 244, 41);
		optionPanel.add(panel);
		
		JLabel maximumLabel = new JLabel("Maximum:");
		maximumLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		maximumLabel.setBounds(10, 52, 76, 24);
		optionPanel.add(maximumLabel);
		
		txtMaximum = new JTextField();
		txtMaximum.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					
					maximum = Integer.parseInt(txtMaximum.getText());
					txtMaximum.setEditable(false);
					numberfield.setEditable(true);
					numberfield.setText("0");
					guessNumber = random.nextInt(maximum);
					numberfield.requestFocusInWindow();
					
				}
			}
		});
		txtMaximum.setBounds(10, 81, 86, 20);
		optionPanel.add(txtMaximum);
		txtMaximum.setColumns(10);
		
		JLabel scoreLabel = new JLabel("Best Score:");
		scoreLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		scoreLabel.setBounds(10, 315, 86, 14);
		optionPanel.add(scoreLabel);
		
		txtBestScore = new JTextField();
		txtBestScore.setEditable(false);
		txtBestScore.setBounds(10, 340, 86, 20);
		optionPanel.add(txtBestScore);
		txtBestScore.setColumns(10);
		
		JLabel labelGuesses = new JLabel("Guesses:");
		labelGuesses.setFont(new Font("Tahoma", Font.BOLD, 15));
		labelGuesses.setBounds(148, 315, 68, 14);
		optionPanel.add(labelGuesses);
		
		txtGuesses = new JTextField();
		txtGuesses.setEditable(false);
		txtGuesses.setBounds(148, 340, 86, 20);
		optionPanel.add(txtGuesses);
		txtGuesses.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(Frame.class.getResource("/images/atze100px.png")));
		lblNewLabel_1.setBounds(53, 131, 101, 146);
		optionPanel.add(lblNewLabel_1);
		
		JPanel GamePanel = new JPanel();
		GamePanel.setBackground(Color.WHITE);
		GamePanel.setBounds(264, 11, 523, 398);
		contentPanel.add(GamePanel);
		GamePanel.setLayout(null);
		
		JLabel lblNewLabel_5 = new JLabel("Number you are Guessing.");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_5.setBounds(170, 52, 196, 23);
		GamePanel.add(lblNewLabel_5);
		
		numberfield = new JTextField();
		numberfield.setEditable(false);
		numberfield.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
				if(e.getKeyCode() == KeyEvent.VK_DOWN && numberfield.isEditable() ==true) {
					
					numberfield.setText(String.valueOf(Integer.parseInt(numberfield.getText())-1));
					numberfield.requestFocusInWindow();
					
				}
				
				if(e.getKeyCode() == KeyEvent.VK_UP && numberfield.isEditable() ==true) {
					
					numberfield.setText(String.valueOf(Integer.parseInt(numberfield.getText())+1));
					numberfield.requestFocusInWindow();
					
				}
				
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					
					game();
					
				}
				
			}
		});
		numberfield.setFont(new Font("Tahoma", Font.BOLD, 15));
		numberfield.setHorizontalAlignment(SwingConstants.CENTER);
		numberfield.setBackground(Color.YELLOW);
		numberfield.setBounds(240, 88, 47, 41);
		GamePanel.add(numberfield);
		numberfield.setColumns(10);
		
		JButton btnGiveUp = new JButton("Give Up!");
		btnGiveUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				numberfield.setText("");
				txtMaximum.setText("");
				txtBestScore.setText("");
				txtGuesses.setText("");
				txtAnswer.setText("");
				txtMaximum.setEditable(true);
				numberfield.setEditable(false);
				txtMaximum.requestFocus();
				
				
			}
		});
		btnGiveUp.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnGiveUp.setBounds(76, 263, 105, 23);
		GamePanel.add(btnGiveUp);
		
		JButton btnTryAgain = new JButton("Try Again?");
		btnTryAgain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				txtMaximum.setText("");
				txtMaximum.setEditable(true);
				numberfield.setEditable(false);
				numberfield.setText("");
				txtAnswer.setText("");
				tryes=0;
				txtGuesses.setText(String.valueOf(0));
				txtMaximum.requestFocusInWindow();
				
			}
		});
		btnTryAgain.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnTryAgain.setBounds(323, 263, 120, 23);
		GamePanel.add(btnTryAgain);
		
		JButton btnGuess = new JButton("Guess!");
		btnGuess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				game();
				numberfield.requestFocusInWindow();
				
			}
		});
		btnGuess.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnGuess.setBounds(206, 337, 89, 23);
		GamePanel.add(btnGuess);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.BLUE);
		panel_1.setBounds(0, 0, 523, 41);
		GamePanel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Number Guessing Game!");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(153, 11, 223, 19);
		panel_1.add(lblNewLabel);
		
		txtAnswer = new JTextField();
		txtAnswer.setEditable(false);
		txtAnswer.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtAnswer.setHorizontalAlignment(SwingConstants.CENTER);
		txtAnswer.setBackground(new Color(0, 255, 255));
		txtAnswer.setBounds(76, 148, 366, 91);
		GamePanel.add(txtAnswer);
		txtAnswer.setColumns(10);
	}
}
