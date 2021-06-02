package game;
import java.util.Scanner;

public class tictactoe {

	public static void main(String[] args) {

		char[][] board = new char[5][5];

		create(board);

		Scanner scanner = new Scanner(System.in);

		boolean player1 = true;
		boolean gameContinue = true;

		while(gameContinue) {

			char piece = ' ';
			if(player1) {
				System.out.println("player 1's turn:");
				piece = 'X';
			} else {
				System.out.println("player 2's turn:");
				piece = 'O';
			}

			draw(board);

			int row = 0;
			int col = 0;

			while(true) {

				System.out.print("Enter which row you want to place (top(0), middle(2), bottom(4): ");
				row = scanner.nextInt();
				System.out.print("Enter which column you want to place (left(0), middle(2), right(4): ");
				col = scanner.nextInt();

				if(row == 1 || col == 1 || row == 3 || col == 3 || row < 0 || col < 0 || row > 4 || col > 4) {
					System.out.println("This position is Invalid");
				} else if(board[row][col] == 'X' || board[row][col] == 'O') {
					System.out.println("This position has been taken");
				} else {
					break;
				}
			}

			board[row][col] = piece;

			if(checkWin(board) == 'X') {
				System.out.println("player 1 wins");
				gameContinue = false;
			} else if(checkWin(board) == 'O') {
				System.out.println("player 2 wins");
				gameContinue = false;
			} else {
				if(isFull(board)) {
					System.out.println("It's a tie!");
					gameContinue = false;
				} else {
					player1 = !player1;
				}
			}
		}
		draw(board);
	}

	public static void create(char[][] board) { 
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 5; j++) {
				if((i == 1 || i == 3) && (j == 1 || j == 3)) {
					board[i][j] = '+';
				} else if((i == 0 || i == 2 || i == 4) && (j == 1 || j == 3)) {
					board[i][j] = '|';
				} else if((i == 1 || i == 3) && (j == 0 || j == 2 || j == 4)) {
					board[i][j] = '-';
				} else {
					board[i][j] = ' ';	
				}
			}
		}
	}

	public static void draw(char[][] board) {
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 5; j++) {
				System.out.print(board[i][j]);
			}
			System.out.println();
		}
	}

	public static char checkWin(char[][] board) {
		for(int i = 0; i < 5; i += 2) {
			if(board[i][0] == board[i][2] && board[i][2] == board[i][4] && board[i][0] != ' ') {
				return board[i][0];
			}
		}

		for(int j = 0; j < 5; j += 2) {
			if(board[0][j] == board[2][j] && board[2][j] == board[4][j] && board[0][j] != ' ') {
				return board[0][j];
			}
		}

		if(board[0][0] == board[2][2] && board[2][2] == board[4][4] && board[0][0] != ' ') {
			return board[0][0];
		}

		if(board[4][0] == board[2][2] && board[2][2] ==  board[0][4] && board[4][0] != ' ') {
			return board[4][0];
		}
		return ' ';
	}

	public static boolean isFull(char[][] board) {
		for(int i = 0; i < 5; i += 2) {
			for(int j = 0; j < 5; j += 2) {
				if(board[i][j] == ' ') {
					return false;
				}
			}
		}
		return true;
	}
}
