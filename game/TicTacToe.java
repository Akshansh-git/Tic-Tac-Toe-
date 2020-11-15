package game;
import java.util.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
public class TicTacToe implements ActionListener{
	
	Random random=new Random();
	JFrame frame=new JFrame();
	JPanel title_panel=new JPanel();
	JPanel button_panel=new JPanel();
	JLabel textfield=new JLabel();
	JButton[] button=new JButton[9];
	boolean player1_turn;
	
	
	
	
	TicTacToe(){
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800, 800);
		frame.getContentPane().setBackground(new Color(218,165,32));
		frame.setLayout(new BorderLayout());
		frame.setVisible(true);
		
		textfield.setBackground(Color.BLACK);
		textfield.setForeground(Color.GREEN);
		textfield.setFont(new Font("Ink Free",Font.BOLD,75));
		textfield.setHorizontalAlignment(JLabel.CENTER);
		textfield.setText("Tic-Tac-Toe");
		textfield.setOpaque(true);
		
		title_panel.setLayout(new BorderLayout());
		title_panel.setBounds(0, 0, 800, 100);
		
		button_panel.setLayout(new GridLayout(3,3));
		button_panel.setBackground(new Color(150,150,150));
		
		for(int i=0;i<9;i++) {
			button[i]=new JButton();
			button_panel.add(button[i]);
			button[i].setFont(new Font("MV Boli",Font.BOLD,120));
			button[i].setFocusable(false);
			button[i].addActionListener(this);
		}
		
		title_panel.add(textfield);
		frame.add(title_panel,BorderLayout.NORTH);
		frame.add(button_panel);
		
		firstTurn();
	}
	public void actionPerformed(ActionEvent e) {
		for(int i=0;i<9;i++) {
			if(e.getSource()==button[i]) {
				if(player1_turn) {
					if(button[i].getText()=="") {
						button[i].setForeground(new Color(255,0,0));
						button[i].setText("X");
						player1_turn=false;
						textfield.setText("O turn");
						check();
					}
				}
				else {
					if(button[i].getText()=="") {
						button[i].setForeground(new Color(0,0,255));
						button[i].setText("O");
						player1_turn=true;
						textfield.setText("X turn");
						check();
					}
				}
			}			
		}
		
	}
	public void firstTurn() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(random.nextInt(2)==0) {
			player1_turn=true;
			textfield.setText("X's turn");
		}else {
			player1_turn=false;
			textfield.setText("O's turn");
		}
		
	}
	public void check() {
		//check X win conditions
				if(
						(button[0].getText()=="X") &&
						(button[1].getText()=="X") &&
						(button[2].getText()=="X")
						) {
					xWins(0,1,2);
				}
				else if(
						(button[3].getText()=="X") &&
						(button[4].getText()=="X") &&
						(button[5].getText()=="X")
						) {
					xWins(3,4,5);
				}
				else if(
						(button[6].getText()=="X") &&
						(button[7].getText()=="X") &&
						(button[8].getText()=="X")
						) {
					xWins(6,7,8);
				}
				else if(
						(button[0].getText()=="X") &&
						(button[3].getText()=="X") &&
						(button[6].getText()=="X")
						) {
					xWins(0,3,6);
				}
				else if(
						(button[1].getText()=="X") &&
						(button[4].getText()=="X") &&
						(button[7].getText()=="X")
						) {
					xWins(1,4,7);
				}
				else if(
						(button[2].getText()=="X") &&
						(button[5].getText()=="X") &&
						(button[8].getText()=="X")
						) {
					xWins(2,5,8);
				}
				else if(
						(button[0].getText()=="X") &&
						(button[4].getText()=="X") &&
						(button[8].getText()=="X")
						) {
					xWins(0,4,8);
				}
				else if(
						(button[2].getText()=="X") &&
						(button[4].getText()=="X") &&
						(button[6].getText()=="X")
						) {
					xWins(2,4,6);
				}
				//check O win conditions
				else if(
						(button[0].getText()=="O") &&
						(button[1].getText()=="O") &&
						(button[2].getText()=="O")
						) {
					oWins(0,1,2);
				}
				else if(
						(button[3].getText()=="O") &&
						(button[4].getText()=="O") &&
						(button[5].getText()=="O")
						) {
					oWins(3,4,5);
				}
				else if(
						(button[6].getText()=="O") &&
						(button[7].getText()=="O") &&
						(button[8].getText()=="O")
						) {
					oWins(6,7,8);
				}
				else if(
						(button[0].getText()=="O") &&
						(button[3].getText()=="O") &&
						(button[6].getText()=="O")
						) {
					oWins(0,3,6);
				}
				else if(
						(button[1].getText()=="O") &&
						(button[4].getText()=="O") &&
						(button[7].getText()=="O")
						) {
					oWins(1,4,7);
				}
				else if(
						(button[2].getText()=="O") &&
						(button[5].getText()=="O") &&
						(button[8].getText()=="O")
						) {
					oWins(2,5,8);
				}
				else if(
						(button[0].getText()=="O") &&
						(button[4].getText()=="O") &&
						(button[8].getText()=="O")
						) {
					oWins(0,4,8);
				}
				else if(
						(button[2].getText()=="O") &&
						(button[4].getText()=="O") &&
						(button[6].getText()=="O")
						) {
					oWins(2,4,6);
				}
				else {
					int checkTie = 0;
					for(JButton i : button) {
					    if(i.getText()=="O" || i.getText()=="X") {
					     checkTie++; 
					    }
					    if(checkTie==9) {
					     tie();
					     //System.out.println("tie");
					    }
					}
				}
	}
	public void tie() {
		textfield.setText("It's a tie");
	}
	public void xWins(int a,int b,int c) {
		button[a].setBackground(Color.GREEN);
		button[b].setBackground(Color.GREEN);
		button[c].setBackground(Color.GREEN);
		
		for(int i=0;i<9;i++) {
			button[i].setEnabled(false);
		}
		textfield.setText("X wins");
		
	}
    public void oWins(int a,int b,int c) {
    	button[a].setBackground(Color.GREEN);
		button[b].setBackground(Color.GREEN);
		button[c].setBackground(Color.GREEN);
		
		for(int i=0;i<9;i++) {
			button[i].setEnabled(false);
		}
		textfield.setText("O wins");
		
	}

}
