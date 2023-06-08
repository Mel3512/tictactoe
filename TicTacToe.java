import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		// Initialize the game board
		char[][] board = {{' ', ' ', ' '},
				 	      {' ', ' ', ' '}, 
				 	      {' ', ' ', ' '}};
		
		printBoard(board);
		
		while (true) {
			playerTurn(board, scanner); // Player's turn
			if (isGameFinished(board)){
				break; // Check if the game is finished after the player's turn
			}
			printBoard(board);
			
			computerTurn(board); // Computer's turn
			if (isGameFinished(board)){
				break; // Check if the game is finished after the computer's turn
			}
			printBoard(board);
		}
		scanner.close();
	}

	// Check if the game has finished (win or tie)
	private static boolean isGameFinished(char[][] board) {
		
		if (hasContestantWon(board, 'X')) {	
			printBoard(board);
			System.out.println("Player wins!");
			return true;
		}
		
		if (hasContestantWon(board, 'O')) {	
			printBoard(board);
			System.out.println("Computer wins!");
			return true;
		}
		
		// Check if the board is full (tie)
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (board[i][j] == ' ') {
					return false;
				}
			}
		}
		printBoard(board);
		System.out.println("The game ended in a tie!");
		return true;
	}

	// Check if a contestant (player or computer) has won
	private static boolean hasContestantWon(char[][] board, char symbol) {
		// Check all possible winning combinations on the board
		if ((board[0][0] == symbol && board [0][1] == symbol && board [0][2] == symbol) ||
			(board[1][0] == symbol && board [1][1] == symbol && board [1][2] == symbol) ||
			(board[2][0] == symbol && board [2][1] == symbol && board [2][2] == symbol) ||
			
			(board[0][0] == symbol && board [1][0] == symbol && board [2][0] == symbol) ||
			(board[0][1] == symbol && board [1][1] == symbol && board [2][1] == symbol) ||
			(board[0][2] == symbol && board [1][2] == symbol && board [2][2] == symbol) ||
			
			(board[0][0] == symbol && board [1][1] == symbol && board [2][2] == symbol) ||
			(board[0][2] == symbol && board [1][1] == symbol && board [2][0] == symbol) ) {
			return true;
		}
		return false;
	}

	// Computer's turn to make a move
	private static void computerTurn(char[][] board) {
		Random rand = new Random();
		int computerMove;
		while (true) {
			computerMove = rand.nextInt(9) + 1; // Generate a random move between 1 and 9
			if (isValidMove(board, Integer.toString(computerMove))) {
				break; // Check if the move is valid (empty position)
			}
		}
		System.out.println("Computer chose " + computerMove);
		placeMove(board, Integer.toString(computerMove), 'O');
	}

	// Check if a move is valid (within the board and empty position)
	private static boolean isValidMove (char[][] board, String position) {
		switch(position) {
			case "1":
				return (board[0][0] == ' ');
			case "2":
				return (board[0][1] == ' ');
			case "3":
				return (board[0][2] == ' ');
			case "4":
				return (board[1][0] == ' ');
			case "5":
				return (board[1][1] == ' ');
			case "6":
				return (board[1][2] == ' ');
			case "7":
				return (board[2][0] == ' ');
			case "8":
				return (board[2][1] == ' ');
			case "9":
				return (board[2][2] == ' ');
			default:
				return false;
		}
	}

	// Player's turn to make a move
	private static void playerTurn(char[][] board, Scanner scanner) {
		String userInput;
		while (true) {
			System.out.println("Where would you like to play? (1-9)");
			userInput = scanner.nextLine();
			if (isValidMove(board, userInput)){
				break; // Check if the move is valid (empty position)
			} else {
				System.out.println(userInput + " is not a valid move.");
			}
		}
		placeMove(board, userInput, 'X');
	}

	// Place a move on the board
	private static void placeMove(char[][] board, String position, char symbol) {
		switch(position) {
			case "1":
				board[0][0] = symbol;
				break;
			case "2":
				board[0][1] = symbol;
				break;
			case "3":
				board[0][2] = symbol;
				break;
			case "4":
				board[1][0] = symbol;
				break;
			case "5":
				board[1][1] = symbol;
				break;
			case "6":
				board[1][2] = symbol;
				break;
			case "7":
				board[2][0] = symbol;
				break;
			case "8":
				board[2][1] = symbol;
				break;
			case "9":
				board[2][2] = symbol;
				break;
			default:
				System.out.println(":(");
		}
	}

	// Print the current state of the board
	private static void printBoard(char[][] board) {
		System.out.println(board[0][0] + "|" +  board[0][1] + "|" +  board[0][2] );
		System.out.println("-+-+-");
		System.out.println(board[1][0] + "|" +  board[1][1] + "|" +  board[1][2] );
		System.out.println("-+-+-");
		System.out.println(board[2][0] + "|" +  board[2][1] + "|" +  board[2][2] );
	}
}
