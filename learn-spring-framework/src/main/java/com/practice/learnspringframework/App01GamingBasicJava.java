package com.practice.learnspringframework;

import com.practice.learnspringframework.game.GameRunner;
import com.practice.learnspringframework.game.MarioGame;
import com.practice.learnspringframework.game.PacManGame;
import com.practice.learnspringframework.game.SuperContraGame;

public class App01GamingBasicJava {

	public static void main(String[] args) {
		
		// var game = new MarioGame();
		// var game = new SuperContraGame();
		var game = new PacManGame();
		var gameRunner = new GameRunner(game);
		// 목표 : 객체 생성 + 의존성 주입 
		// 의존성이란? 여기서 Game은 GameRunner의 의존성 이라고 볼 수 있다.
		// GamingConsole 또한 GamingRunner에 의존성을 가진다.
		gameRunner.run();
	}

}
