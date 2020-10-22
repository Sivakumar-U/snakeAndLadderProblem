package com.snakeladder;

import java.util.Random;

public class SnakeAndLadder {
	public static final int NOPLAY = 1;
	public static final int LADDER = 2;
	public static final int SNAKE = 3;

	public static int position = 0;

	int player1 = 0;

	public static int rollDice(int num) {
		int n = 0;
		Random r = new Random();
		n = r.nextInt(num);
		return (n == 0 ? 1 : n);
	}

	public static void startGame() {
		int random = rollDice(4);
		int rolldice = rollDice(7);
		System.out.println("---------------------");
		System.out.println("Dice Value : " + rolldice);
		System.out.println("Random value : " + random);
		switch (random) {
		case NOPLAY:
			System.out.println("NOPLAY");
			System.out.println("Position of player : " + position);
			System.out.println("----------------------");
			break;
		case LADDER:
			System.out.println("############## Climb up the ladder ############");
			position += rolldice;
			System.out.println("Position of the  Player = " + position);
			System.out.println("----------------------");
			break;
		case SNAKE:
			System.out.println("~~~~~~~~~~~~~~~~ Swallowed by snake ~~~~~~~~~~~~");
			position -= rolldice;
			System.out.println("Position of the  Player = " + position);
			System.out.println("----------------------");
			break;
		default:
			break;
		}
	}

	public static void main(String[] args) {
		System.out.println("Player Position At Start: " + position);
		startGame();
	}
}
