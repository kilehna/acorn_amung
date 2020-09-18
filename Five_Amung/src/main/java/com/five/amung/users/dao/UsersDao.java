package com.five.amung.users.dao;

import com.five.amung.users.dto.UsersDto;

public interface UsersDao {
	//회원가입 완료 요청 처리
	public void insert(UsersDto dto);
	//아이디가 중복확인 기능 : 아이디 존재 여부 요청 처리
	public boolean isExist(String inputId);
	//ajax 프로필 사진 업로드 요청 처리
	
	//회원 목록 보기 요청 처리
}