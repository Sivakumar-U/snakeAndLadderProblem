package com.snakeladder;

import java.util.Random;

public class SnakeAndLadder {
	public static final int NOPLAY = 1;
	public static final int LADDER = 2;
	public static final int SNAKE = 3;
	public static int COUNTER = 0;
	public static int WINROLLS = 0;
	public static int LOSEROLLS = 0;
	public static int NOPLAYROLLS = 0;
	public static int currentPlayer = -1;

	final static int WINPOINT = 100;

	public static int position = 0;
	public static int calculatedPosition = 0;

	static int player1 = 0;
	static int player2 = 0;

	public static int rollDice(int num) {
		int n = 0;
		Random r = new Random();
		n = r.nextInt(num);
		return (n == 0 ? 1 : n);
	}

	public static int startGame() {
		do {
			int random = rollDice(4);
			int rolldice = rollDice(7);
			System.out.println("---------------------");
			System.out.println("Dice Value : " + rolldice);
			System.out.println("Random value : " + random);
			switch (random) {
			case NOPLAY:
				NOPLAYROLLS++;
				System.out.println("NOPLAY");
				System.out.println("Position of player : " + position);
				System.out.println("----------------------");
				break;
			case LADDER:
				WINROLLS++;
				System.out.println("############## Climb up the ladder ############");
				position += rolldice;
				System.out.println("Position of the  Player = " + position);
				System.out.println("----------------------");
				break;
			case SNAKE:
				LOSEROLLS++;
				System.out.println("~~~~~~~~~~~~~~~~ Swallowed by snake ~~~~~~~~~~~~");
				position -= rolldice;
				System.out.println("Position of the  Player = " + position);
				System.out.println("----------------------");
				break;
			default:
				break;
			}
			return calculatedPosition;
		} while (calculatedPosition != WINPOINT);
	}

	public static void twoPlayers() {
		do {
			System.out.print(
					currentPlayer == -1 ? "\n\n **** First Player Turn ****" : "\n\n **** Second Player Turn ****");

			if (currentPlayer == -1) {
				player1 = startGame();
				System.out.println("First Player Values " + player1);
				System.out.println("Second Player Values " + player2);
				System.out.println("------------------------------");
				if (isWin(player1)) {
					System.out.println("First Player Wins  " + player1);
					System.out.println("------------------------------");
					return;
				}

			} else {
				player2 = startGame();
				System.out.println("\nFirst Player Values " + player1);
				System.out.println("\nSecond Player Values " + player2);
				System.out.println("------------------------------");
				if (isWin(player2)) {
					System.out.println("\nSecond Player Wins  " + player2);
					System.out.println("------------------------------");
					return;
				}

			}
			currentPlayer = -currentPlayer;
		} while (player1 != 100 || player2 != 100);
	}

	public static boolean isWin(int player) {
		return WINPOINT == player;
	}

	public static int calculatePlayerLadderPosition(int position, int dicevalue) {
		position = position + dicevalue;
		if (position > WINPOINT) {
			position = position - dicevalue;
		} else if (position == 100) {
			return position;
		}
		return position;
	}

	public static int calculatePlayerSnakeBitePosition(int position, int dicevalue) {
		position = position - dicevalue;
		if (position < 0) {
			position = 0;
		}
		return position;
	}

	public static void main(String[] args) {
		System.out.println("------------------Start--------------------");

		System.out.println("Player Position At Start: " + position);
		startGame();
		System.out.println("-------------------End----------------------");

		System.out.println("NOPLAY Rolls of Die: " + NOPLAYROLLS);
		System.out.println("Wining Rolls of Die: " + WINROLLS);
		System.out.println("Losing Rolls of Die: " + LOSEROLLS);
		System.out.println("Total Number of Die rolls : " + COUNTER);
	}
}
