package com.bridgelabz.game;

import java.util.Scanner;

public class TicTacToeGame {
	Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		System.out.println("Welcome to Tic tac toe game");
		TicTacToeGame obj = new TicTacToeGame();
		char board[] = obj.createBoard();
		char userLetter = obj.chooseLetter();
		char computerLetter = (userLetter == 'X') ? '0' : 'X';
		obj.showBoard(board);
	}
	// UC1
	public char[] createBoard() {
		char board[] = new char[10];
		for(int i=1; i< board.length; i++) {
			board[i] = ' ';
		}
		return board;
	}
	// UC2
	public char chooseLetter() {
		System.out.println("Choose a letter");
		char letter = sc.next().charAt(0);
		return letter;
	}
	// UC3
	public void showBoard(char board[]) {
		for(int i=0; i<board.length;i++)
			System.out.println("position: " + i + " Value: "+board[i] );
	}
}
