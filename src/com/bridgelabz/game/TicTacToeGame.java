package com.bridgelabz.game;

import java.util.Scanner;

public class TicTacToeGame {
	Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		System.out.println("Welcome to Tic tac toe game");
		TicTacToeGame obj = new TicTacToeGame();
		obj.createBoard();
		obj.chooseLetter();
	}
	// UC1
	public void createBoard() {
		char board[] = new char[10];
		for(int i=1; i< board.length; i++) {
			board[i] = ' ';
		}
	}
	// UC2
	public void chooseLetter() {
		System.out.println("Choose a letter");
		char letter = sc.next().charAt(0);
	}
}
