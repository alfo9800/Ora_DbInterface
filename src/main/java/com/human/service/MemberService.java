package com.human.service;

import java.util.List;

import com.human.vo.MemberVO;

public interface MemberService {
	public void memberInsert(MemberVO memberVO) throws Exception;
	public List<MemberVO> memberSelect() throws Exception; //List레코드
	public MemberVO memberView(String userid) throws Exception; //한 줄 레코드
	public void memberUpdate(MemberVO memberVO) throws Exception;
	public void memberDelete(String userid) throws Exception;
}
