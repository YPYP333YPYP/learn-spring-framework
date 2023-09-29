package com.practice.rest.webservices.restfulwebservices.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;


// DAO는 Data Access Object의 줄임말로 쉽게 말하면 데이터베이스에 관련하여 조작하는데 필요한 객체를 뜻한다.
// DaoService에서는 사용자 정보를 조회하거나 저장할 수 있는 메서드를 등록할 수 있다.
// 원래는 H2, Mysql 과 같은 DataBase를 JPA를 사용하여 관리하지만 지금 상태에서는 정적 리스트를 만들어서 관리하도록 한다.
@Component
public class UserDaoService {

	private static List<User> users = new ArrayList<>();
	
	static {
		users.add(new User(1,"Adam",LocalDate.now().minusYears(30)));
		users.add(new User(2,"Eve",LocalDate.now().minusYears(25)));
		users.add(new User(3,"Jim",LocalDate.now().minusYears(20)));
	}
	
	public List<User> findAll() {
		return users;
	}
	
	//public User save(User user) {

	//public User findOne(int id) {

}