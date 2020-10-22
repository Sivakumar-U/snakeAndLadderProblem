package com.snakeladder;

import java.util.Random;

public class SnakeAndLadder {
	static int player1 = 0;

	public static int rollDice() {
		int n = 0;
		Random r = new Random();
		n = r.nextInt(7);
		return (n == 0 ? 1 : n);
	}

	public static void main(String[] args) {
		int rollDice = rollDice();
		System.out.println("Dice Value: " + rollDice);
	}
}
