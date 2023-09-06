package com.practice.learnspringframework.game;

public class GameRunner {
	
	//MarioGame game;
	SuperContraGame game;
	// 강한 결합의 모습
	public GameRunner(SuperContraGame game) {
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
