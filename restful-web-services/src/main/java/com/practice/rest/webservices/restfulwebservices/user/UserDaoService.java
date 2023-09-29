package com.practice.rest.webservices.restfulwebservices.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;


// DAO는 Data Access Object의 줄임말로 쉽게 말하면 데이터베이스에 관련하여 조작하는데 필요한 객체를 뜻한다.
// DaoService에서는 사용자 정보를 조회하거나 저장할 수 있는 메서드를 등록할 수 있다.
// 원래는 H2, Mysql 과 같은 DataBase를 JPA를 사용하여 관리하지만 지금 상태에서는 정적 리스트를 만들어서 관리하도록 한다.
@Component
public class UserDaoService {

	private static List<User> users = new ArrayList<>();
	
	private static int usersCount = 0;
	
	static {
		users.add(new User(++usersCount,"Adam",LocalDate.now().minusYears(30)));
		users.add(new User(++usersCount,"Eve",LocalDate.now().minusYears(25)));
		users.add(new User(++usersCount,"Jim",LocalDate.now().minusYears(20)));
	}
	
	public List<User> findAll() {
		return users;
	}
	
	// ID는 userCount를 이용하여 동적으로 생성하며 정적 리스트에 add 메서드를 이용하여 User 객체를 추가한다.
	public User save(User user) {
		user.setId(++usersCount);
		users.add(user);
		return user;
	}

	// 이전에도 사용한 함수형 인터페이스를 이용하여 메서드를 구축했다. 
	public User findOne(int id) {
		Predicate<? super User> predicate = user -> user.getId().equals(id); 
		return users.stream().filter(predicate).findFirst().get();
	}

}