package com.human.edu;

import java.sql.Connection;
import java.sql.SQLException;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.human.service.MemberService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations ={"file:src/main/webapp/WEB-INF/spring/**/*.xml"})

public class TestMemberService {	
	@Inject
	private DataSource dataSource;
	
	@Inject
	private MemberService memberService;
	
	
	@Test
	public void memberSelect() throws Exception {
		//Junit으로 멤버서비스 CRUD 중 1)View 2)Read select / test
		System.out.println("디버그 한개 레코드 : " + memberService.memberView("user2"));
		System.out.println("디버그 다중 레코드 : " + memberService.memberSelect());
	}
	
	@Test
	public void oracle_connect() throws SQLException {
		Connection connect = dataSource.getConnection(); 
		//DB커넥트를 new키워드로 만들지 않고, get방식을 사용하는 이유 : 한번 커넥션이 되면, 커넥션을 2번이상 호출하지 않게 됨.(static싱글톤 이라고 함.)
		//new키워드로 객체를 만들면 -> 객체 계속 생성
		System.out.println("현재 접속된 DB커넥션은 "+ connect);
	}
	
	@Test
	public void junit_test() {
		System.out.println("JnuitTest 실행 확인 메서드!");
	}
	

}
