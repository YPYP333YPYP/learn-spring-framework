package com.practice.learnspringframework.game;

public class GameRunner {
	
	GamingConsole game;
	// 약한 결합의 모습
	public GameRunner(GamingConsole game) {
		this.game = game;
	}
	
	public void run() {
		System.out.println("Running game :" + game);
		game.up();
		game.down();
		game.left();
		game.right();
	}
}
