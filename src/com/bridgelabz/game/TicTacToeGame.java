package com.bridgelabz.game;

import java.util.Random;
import java.util.Scanner;

public class TicTacToeGame {
	static Scanner userInput = new Scanner(System.in);
	public static TicTacToeGame obj = new TicTacToeGame();
	public static final int HEAD = 0;

	public static void main(String[] args) {
		System.out.println("Welcome to Tic tac toe game");
		char board[] = obj.createBoard();
		char userLetter = obj.chooseLetter();
		char computerLetter = (userLetter == 'X') ? 'O' : 'X';
		System.out.println("User: " + userLetter + " Computer: " + computerLetter);
		String player = obj.checkWhoStartsFirst();
		System.out.println(player + " starts first ");
		
		int flag = 1;
		while (flag == 1) {
			if (player.equals("User")) {
				obj.showBoard(board);
				System.out.println(" Users move ");
				int position = obj.makeUserMove(board, userLetter);
				System.out.println("User placed at position " + position);
				boolean res = obj.game(board, position, userLetter);
				if(res == true){
					System.out.println("User won!!");
					flag = 0;
				}
				player = "Computer";
			} else {
				obj.showBoard(board);
				System.out.println("Computers move");
				int position = obj.move(board, computerLetter, userLetter);
				System.out.println("Computer placed at position " + position);
				boolean res = obj.game(board, position, computerLetter);
				if(res == true){
					System.out.println("Computer won!!");
					flag = 0;
				}
				player = "User";
			}
			if(flag == 0){
				System.out.println("Would you like to play another game? Y/N");
				char userAns = userInput.next().charAt(0);
				if(userAns == 'Y' || userAns == 'y'){
					board = obj.createBoard();
					userLetter = obj.chooseLetter();
					computerLetter = (userLetter == 'X') ? 'O' : 'X';
					System.out.println("User: " + userLetter + " Computer: " + computerLetter);
					player = obj.checkWhoStartsFirst();
					System.out.println(player + " starts first ");
					flag = 1;
				}
			}
		}
	}

	// Checks if there is a tie or win
	public boolean game(char[] board, int move, char letter) {
		makeMove(board, move, letter);
		if (checkWinner(board, letter) == true) {
			showBoard(board);
			return true;
		}
		if (boardIsFull(board)) {
			showBoard(board);
			System.out.println("Game is a tie");
			return true;
		}
		return false;
	}

	// Creating a board
	public char[] createBoard() {
		char board[] = new char[10];
		for (int index = 1; index < board.length; index++) {
			board[index] = ' ';
		}
		return board;
	}

	// Choose a letter
	public char chooseLetter() {
		System.out.println("Choose a letter: X or O");
		char letter = userInput.next().charAt(0);
		return letter;
	}

	// Display the board
	public void showBoard(char board[]) {
		System.out.println("Board");
		System.out.println(" " + board[1] + " | " + board[2] + " | " + board[3]);
		System.out.println("-----------");
		System.out.println(" " + board[4] + " | " + board[5] + " | " + board[6]);
		System.out.println("-----------");
		System.out.println(" " + board[7] + " | " + board[8] + " | " + board[9]);
	}

	// Make a move
	public int makeUserMove(char board[], char userLetter) {
		System.out.println("Select a position to move: ");
		int position = userInput.nextInt();
		try {
			for (int index = 1; index < board.length; index++) {
				if (board[position] == ' ') {
					return position;
				}
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Index out of range");
		}
		return 0;
	}

	public void makeMove(char board[], int position, char letter) {
		try {
			for (int index = 1; index < board.length; index++) {
				if (board[position] == ' ') {
					board[position] = letter;
				} else
					return;
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Index out of range");
		}
	}

	// Check who plays first
	public String checkWhoStartsFirst() {
		Random random = new Random();
		int randomNo = random.nextInt(2);
		String player;
		if (randomNo == HEAD)
			player = "User";
		else
			player = "Computer";
		return player;
	}

	// Winning condition
	public boolean checkWinner(char board[], char input) {
		if ((board[1] == input && board[2] == input && board[3] == input)
				|| (board[4] == input && board[5] == input && board[6] == input)
				|| (board[7] == input && board[8] == input && board[9] == input)
				|| (board[1] == input && board[4] == input && board[7] == input)
				|| (board[2] == input && board[5] == input && board[8] == input)
				|| (board[3] == input && board[6] == input && board[9] == input)
				|| (board[1] == input && board[5] == input && board[9] == input)
				|| (board[3] == input && board[5] == input && board[7] == input))
		{
			return true;
		}
		else{
			return false;
		}
	}
	
	public char[] getCopy(char[] board) {
		char[] copy = new char[board.length];
		for (int i = 1; i < copy.length; i++) {
			copy[i] = board[i];
		}
		return copy;
	}
	
	// Winning move
	public int makeComputerMove(char board[], char letter) {
		char[] copy = getCopy(board);
		for (int index = 1; index < copy.length; index++) {
			if (copy[index] == ' ') {
				makeMove(copy, index, letter);
				if (checkWinner(copy, letter)){
					return index;
				}
				makeMove(copy, index, ' ');
			}
		}
		return 0;
	}

	// Returns winning move of computer
	// If none then any of the empty corner index is returned
	// If none then center or any side is returned
	public int move(char board[], char computerLetter, char userLetter) {
		int computerMove = makeComputerMove(board, computerLetter);
		if (computerMove != 0){
			return computerMove;
		}
		
		int userMove = makeComputerMove(board, userLetter);
		if (userMove != 0){
			return userMove;
		}
		
		int corner[] = { 1, 3, 7, 9 };
		for (int index = 0; index < corner.length; index++) {
			if (board[corner[index]] == ' ') {
				return corner[index];
			}
		}
		
		if (board[5] == ' '){
			return 5;
		}
		
		int sides[] = { 2, 4, 6, 8 };
		for (int index = 0; index < sides.length; index++) {
			if (board[sides[index]] == ' ') {
				return sides[index];
			}
		}
		return 0;
	}

	// Checks if board is full
	private boolean boardIsFull(char[] board) {
		for (int index = 0; index < board.length; index++) {
			if (board[index] == ' ')
				return false;
		}
		return true;
	}
}