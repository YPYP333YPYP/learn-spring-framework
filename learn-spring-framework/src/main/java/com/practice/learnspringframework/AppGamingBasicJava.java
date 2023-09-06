package com.practice.learnspringframework;

import com.practice.learnspringframework.game.GameRunner;
import com.practice.learnspringframework.game.MarioGame;
import com.practice.learnspringframework.game.PacManGame;
import com.practice.learnspringframework.game.SuperContraGame;

public class AppGamingBasicJava {

	public static void main(String[] args) {
		
		// var game = new MarioGame();
		// var game = new SuperContraGame();
		var game = new PacManGame();
		var gameRunner = new GameRunner(game);
		gameRunner.run();
	}

}
