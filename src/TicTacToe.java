
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class TicTacToe extends JPanel{
	
	JButton button[] = new JButton[9];
	Font font = new Font("sans-serif", Font.PLAIN, 32);
	
	// if this number is even -> put "X". if its odd -> put "O"
	int alt = 0;
	
	public TicTacToe(){
		setLayout(new GridLayout(3,3));
		initializeButtons();
	}
	
	
	
	
	public void initializeButtons() {
		
		// initialize 9 buttons 
		for(int i=0;i<=8;i++){
			button[i] = new JButton();
			
			// there is no text until user click the button
			button[i].setText("");
			
			button[i].addActionListener(new buttonListner());
			
			add(button[i]);
		}
	}
	
	public void resetButton(){
		for(int i=0;i<=8;i++){
			button[i].setText("");
		}
	}
	
	private class buttonListner implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			// get the button that was clicked
			JButton buttonClicked = (JButton)e.getSource();
			
			if(alt%2==0){
				buttonClicked.setText("X");
				buttonClicked.setFont(font);		
				buttonClicked.setForeground(Color.RED);
			}else{
				buttonClicked.setText("O");
				buttonClicked.setFont(font);
				buttonClicked.setForeground(Color.BLUE);
			}
			
			// this method can check the game
			if(checkForWin()==true){
				JOptionPane.showConfirmDialog(null, "Game Over!");
				resetButton();
			}
			
			alt++;
		}
		
	}
	
	public boolean checkAdjacent(int a,int b){
		if(button[a].getText().equals(button[b].getText())&& !button[a].getText().equals("")){
			return true;
		}else{
			return false;
		}
	}
	
	public boolean checkForWin(){
		
		// 0 1 2 
		// 3 4 5
		// 6 7 8 
		 
		//horizontal win check
		// 012,345,678
		if(checkAdjacent(0,1) && checkAdjacent(1,2)){
			return true;
		}else if(checkAdjacent(3,4) && checkAdjacent(4,5)){
			return true;
		}else if(checkAdjacent(6,7) && checkAdjacent(7,8)){
			return true;
		}
		
		// vertical win check
		// 036,147,258
		else if(checkAdjacent(0,3) && checkAdjacent(3,6)){
			return true;
		}else if(checkAdjacent(1,4) && checkAdjacent(4,7)){
			return true;
		}else if(checkAdjacent(2,5) && checkAdjacent(5,8)){
			return true;
		}
		
		// diagonal win check
		// 048,246
		else if(checkAdjacent(0,4) && checkAdjacent(4,8)){
			return true;
		}else if(checkAdjacent(2,4) && checkAdjacent(4,6)){
			return true;
		}else {
			return false;
		}
	}
	
	

	public static void main(String args[]){
		
		// make frame with title
		JFrame window = new JFrame("Tic Tac Toe");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().add(new TicTacToe());
		// bounds = x,y,width,height
		window.setBounds(300,200,300,300);
		
		window.setVisible(true);
	}
	
	

}
