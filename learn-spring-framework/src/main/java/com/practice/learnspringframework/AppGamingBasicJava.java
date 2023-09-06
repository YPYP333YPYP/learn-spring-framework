package com.practice.learnspringframework;

import com.practice.learnspringframework.game.GameRunner;
import com.practice.learnspringframework.game.MarioGame;
import com.practice.learnspringframework.game.SuperContraGame;

public class AppGamingBasicJava {

	public static void main(String[] args) {
		
		//var marioGame = new MarioGame();
		var superContraGame = new SuperContraGame();
		var gameRunner = new GameRunner(superContraGame);
		gameRunner.run();
	}

}
