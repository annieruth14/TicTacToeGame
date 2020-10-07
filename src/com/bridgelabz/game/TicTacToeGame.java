package com.bridgelabz.game;

import java.util.Scanner;

public class TicTacToeGame {
	Scanner userInput = new Scanner(System.in);
	public static TicTacToeGame obj = new TicTacToeGame();

	public static void main(String[] args) {
		System.out.println("Welcome to Tic tac toe game");
		char board[] = obj.createBoard();
		char userLetter = obj.chooseLetter();
		char computerLetter = (userLetter == 'X') ? 'O' : 'X';
		System.out.println("User: " + userLetter + " Computer: " + computerLetter);
		obj.showBoard(board);
		char userBoard[] = obj.makeMove(board, userLetter);
		obj.showBoard(userBoard);
	}

	// UC1 Creating a board
	public char[] createBoard() {
		char board[] = new char[10];
		for (int index = 1; index < board.length; index++) {
			board[index] = ' ';
		}
		return board;
	}

	// UC2 Choose a letter
	public char chooseLetter() {
		System.out.println("Choose a letter");
		char letter = userInput.next().charAt(0);
		return letter;
	}

	// UC3 Display the board
	public void showBoard(char board[]) {
		System.out.println("Board");
		System.out.println(" " + board[1] + " | " + board[2] + " | " + board[3]);
		System.out.println("-----------");
		System.out.println(" " + board[4] + " | " + board[5] + " | " + board[6]);
		System.out.println("-----------");
		System.out.println(" " + board[7] + " | " + board[8] + " | " + board[9]);
	}

	// UC4 Make a move
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
		return board;
	}
}
