package com.practice.learnspringframework;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.practice.learnspringframework.game.GameRunner;
import com.practice.learnspringframework.game.GamingConsole;
import com.practice.learnspringframework.game.MarioGame;
import com.practice.learnspringframework.game.PacManGame;
import com.practice.learnspringframework.game.SuperContraGame;

// 기존의 Configuration 파일을 제거 한 후 메인 클래스에 @Configuration 어노테이션을 추가한다.
// 더불어 원래는 수동으로 Bean을 생성했지만 @Component 어노테이션을 이용하여 Spring이 자동으로 Bean을 생성할 수 있도록 하는데
// Bean으로 생성될 class에 @Component 어노테이션을 붙이고 Configuration 역활을 하는 클래스에서는 @ComponentScan 어노테이션과 패키지 경로를 명시한다
// 이러면 자동적으로 Bean을 생성하고 메인 클래스가 Configuration이 되면서 코드의 양을 줄일 수 있으며,
// Spring이 자동으로 Bean을 생성하고 자동적으로 연결이 되는 auto-wiring 이 된다.

@Configuration
@ComponentScan("com.practice.learnspringframework.game")
public class GamingAppLauncherApplication {

	public static void main(String[] args) {
		
		var context = new AnnotationConfigApplicationContext(GamingAppLauncherApplication.class);
		
		context.getBean(GamingConsole.class).up();
		
		context.getBean(GameRunner.class).run();
	}

}
