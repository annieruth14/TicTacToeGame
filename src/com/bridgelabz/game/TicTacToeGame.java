package com.bridgelabz.game;

public class TicTacToeGame {
	public static void main(String[] args) {
		System.out.println("Welcome to Tic tac toe game");
		TicTacToeGame obj = new TicTacToeGame();
		obj.createBoard();
	}
	// UC1
	public void createBoard() {
		char board[] = new char[10];
		for(int i=1; i< board.length; i++) {
			board[i] = ' ';
		}
	}
}
