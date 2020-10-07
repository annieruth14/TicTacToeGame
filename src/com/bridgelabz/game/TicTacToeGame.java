package com.bridgelabz.game;

import java.util.Random;
import java.util.Scanner;

public class TicTacToeGame {
	Scanner userInput = new Scanner(System.in);
	public static TicTacToeGame obj = new TicTacToeGame();
	public static final int HEAD = 0;

	public static void main(String[] args) {
		System.out.println("Welcome to Tic tac toe game");
		char board[] = obj.createBoard();
		char userLetter = obj.chooseLetter();
		char computerLetter = (userLetter == 'X') ? 'O' : 'X';
		System.out.println("User: " + userLetter + " Computer: " + computerLetter);
		obj.showBoard(board);
		char userBoard[] = obj.makeMove(board, userLetter);
		obj.showBoard(userBoard);
		String random = obj.checkWhoStartsFirst();
		boolean checkWinner = obj.checkWinner(userBoard, userLetter);
		int computerMove = obj.move(board, userLetter, computerLetter);
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
	public char[] makeMove(char board[], char userLetter) {
		try {
			System.out.println("Select a position to move: ");
			int position = userInput.nextInt();
			for (int index = 1; index < board.length; index++) {
				if (board[position] == ' ') {
					board[position] = userLetter;
				}
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Index out of range");
		}
		showBoard(board);
		return board;
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
			return true;
		else
			return false;
	}

	// Winning move
	public int winningMove(char board[], char computerLetter) {
		for (int index = 1; index < board.length; index++) {
			if (board[index] == ' ') {
				makeMove(board, computerLetter);
				if (checkWinner(board, computerLetter))
					return index;
			}
		}
		return 0;
	}

	// Returns winning move of computer or user 
	// If none then any of the empty corner index is returned
	public int move(char board[], char computerLetter, char userLetter) {
		int computerMove = winningMove(board, computerLetter);
		if (computerMove != 0)
			return computerMove;
		int userMove = winningMove(board, userLetter);
		if (userMove != 0)
			return userMove;
		int corner[] = {1 , 3 , 7 , 9};
		int cornerIndex = 0;
		for(int index = 0; index< board.length;index++) {
			if((index==corner[cornerIndex]) && (index == ' ')) {
				return corner[cornerIndex];
			}
		}
		return 0;
	}
}
