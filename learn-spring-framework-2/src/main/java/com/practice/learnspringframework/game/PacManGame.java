package com.practice.learnspringframework.game;

import org.springframework.stereotype.Component;

@Component
public class PacManGame implements GamingConsole{
	public void up() {
		System.out.println("Jump");
	}
	
	public void down() {
		System.out.println("Down");
	}
	
	public void left() {
		System.out.println("Left");
	}
	
	public void right() {
		System.out.println("Right");
	}
}
