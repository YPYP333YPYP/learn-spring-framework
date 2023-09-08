package com.practice.learnspringframework;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.practice.learnspringframework.game.GameRunner;
import com.practice.learnspringframework.game.GamingConsole;
import com.practice.learnspringframework.game.MarioGame;
import com.practice.learnspringframework.game.PacManGame;
import com.practice.learnspringframework.game.SuperContraGame;

public class App03GamingSpringBeans {

	public static void main(String[] args) {
		
		var context = new AnnotationConfigApplicationContext(GamingConfiguration.class);
		
		context.getBean(GamingConsole.class).up();
		
		context.getBean(GameRunner.class).run();
	}

}
