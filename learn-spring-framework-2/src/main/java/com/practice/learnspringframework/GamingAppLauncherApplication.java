package com.practice.learnspringframework;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.practice.learnspringframework.game.GameRunner;
import com.practice.learnspringframework.game.GamingConsole;
import com.practice.learnspringframework.game.MarioGame;
import com.practice.learnspringframework.game.PacManGame;
import com.practice.learnspringframework.game.SuperContraGame;

// 목표 : 코드량을 줄이고, Spring이 자동으로 Bean을 찾아서 생성하며 관리하도록 만든다.
// 1. 코드량 줄이기 : App03GamingSpringBeans 파일과 GamingConfiguration 파일을 각각 만들었지만 GamingAppLauncherApplication 파일 하나로 @Configuration 어노테이션을 사용하여 코드량을 줄였다.
// 2. Spring Bean 자동생성 : @Component 어노테이션으로 가능한데 PacnManGame과 GameRunner, GameConsole 클래스에 모두 @Component 어노테이션을 붙여 Spring에게 명시를 해준다.
//    Configuration에서 @ComponentScan을 이용하여 Spring 자체에서 Auto-Wiring이 되고 자동으로 Bean이 생성된다. 이때 @CompoentScan에는 경로를 명시해야한다. 

@Configuration
@ComponentScan("com.practice.learnspringframework.game")
public class GamingAppLauncherApplication {

	public static void main(String[] args) {
		
		var context = new AnnotationConfigApplicationContext(GamingAppLauncherApplication.class);
		
		context.getBean(GamingConsole.class).up();
		
		context.getBean(GameRunner.class).run();
	}

}