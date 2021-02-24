package com.human.edu;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.human.service.MemberService;
import com.human.vo.MemberVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations ={"file:src/main/webapp/WEB-INF/spring/**/*.xml"})

public class TestMemberService {	
	@Inject
	private DataSource dataSource;
	
	@Inject
	private MemberService memberService;
	
//==========================================================================================
	@Test
	public void memberDelete() throws Exception {
		List<MemberVO> memberList = memberService.memberSelect();
		System.out.println("디버그 top1구하기 "+memberList.get(0).getUserid()); //List중에 get(0)으로 하나를 뽑고, userID로 지정한다.
		//사용자가 1명이 남을 때 까지 반복 로직
		if(memberList.size()>1) {
		memberService.memberDelete(memberList.get(0).getUserid());
		}else {
			System.out.println("더이상 삭제 불가 합니다. 남은 사용자 1명");
		}
	}
	
	@Test
	public void memberUpdate() throws Exception {
		MemberVO memberVO = new MemberVO();
		memberVO.setUserid("user2");
		memberVO.setUserpw("4321");
		memberVO.setUsername("수정사용자");
		memberVO.setEmail("abc@aka.com");
		memberService.memberUpdate(memberVO);
	}
	
	@Test
	public void memberInsert() throws Exception {
		List<MemberVO> memberList = memberService.memberSelect();
		MemberVO memberVO = new MemberVO();
		memberVO.setUserid("user_"+ memberList.size());
		memberVO.setUserpw("1234");
		memberVO.setUsername("사용자"+memberList.size());
		memberVO.setEmail("user_"+ memberList.size()+"@aka.com");
		memberService.memberInsert(memberVO);
	}
	
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
		System.out.println("JunitTest 실행 확인 메서드!");
	}
	

}
