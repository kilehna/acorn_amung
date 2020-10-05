package com.five.amung.dogs.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.five.amung.dogs.dao.DogsDao;
import com.five.amung.dogs.dto.DogsDto;

@Service
public class DogsServiceImpl implements DogsService{
	@Autowired
	private DogsDao dogsDao;

	@Override
	public boolean insert(HttpServletRequest request, DogsDto dto) {
		String member_id=(String)request.getSession().getAttribute("id");
		dto.setMember_id(member_id);
		String etc=request.getParameter("etc");
		if(etc ==null) {
			dto.setEtc("");
		}
		
		//같은 아이디에 같은 강아지 정보 존재 여부 
		boolean isExist=false;
		//true 일시 이미 저장된 강아지 정보 입니다. 라고 나오게 하기
		List<DogsDto> resultDto=dogsDao.getDogsData(dto);
		for(int i=0; i<resultDto.size(); i++) {
			String dname=resultDto.get(i).getDname();
			if(dname.equals(dto.getDname())) {
				isExist=true;
			}
		}
		if(isExist==false) {
			//dto 를 인자로 받아 dao를 이용해서 정보를 저장한다.
			dogsDao.insert(dto);
		}
		return isExist;
	}

	@Override
	public Map<String, Object> getList(HttpServletRequest request, DogsDto dto) {
		
		String member_id=(String)request.getSession().getAttribute("id");
		dto.setMember_id(member_id);
		
		//dao 로 강아지 리스트를 가지고 온다.
		List<DogsDto> dogList=dogsDao.getList(dto);
		
		
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("dogList", dogList);
		
		return map;
	}

	@Override
	public DogsDto getData(int num) {
		//강아지 정보를 받아온다.(dao)
		return dogsDao.getData(num);
	}
}