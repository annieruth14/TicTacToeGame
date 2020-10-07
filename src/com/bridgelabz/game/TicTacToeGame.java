package com.bridgelabz.game;

import java.util.Scanner;

public class TicTacToeGame {
	Scanner sc = new Scanner(System.in);
	public static TicTacToeGame obj = new TicTacToeGame();
	public static void main(String[] args) {
		System.out.println("Welcome to Tic tac toe game");
		char board[] = obj.createBoard();
		char userLetter = obj.chooseLetter();
		char computerLetter = (userLetter == 'X') ? 'O' : 'X';
		System.out.println("User: "+userLetter + " Computer: "+computerLetter);
		obj.showBoard(board);
		char userBoard[] = obj.makeMove(board, userLetter);
		obj.showBoard(userBoard);
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
		System.out.println("Board");
		System.out.println(" "+board[1]+ " | " + board[2] + " | "+ board[3]);
		System.out.println("-----------");
		System.out.println(" "+board[4]+ " | " + board[5] + " | "+ board[6]);
		System.out.println("-----------");
		System.out.println(" "+board[7]+ " | " + board[8] + " | "+ board[9]);
	}
	// UC4
	public char[] makeMove(char board[], char userLetter) {
		int flag = 0;
		System.out.println("Select a position to move: ");
		int position = sc.nextInt();
		for(int i=1; i< board.length; i++) {
			if(board[position] == ' ') {
				board[position] = userLetter;
			}	
		}
		return board;
	}
}

