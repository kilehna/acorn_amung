package com.five.amung.reserve.controller;


import java.util.Map;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.five.amung.dogs.dto.DogsDto;
import com.five.amung.dogs.service.DogsService;
import com.five.amung.reserve.dto.ReserveDto;
import com.five.amung.reserve.dto.RoomDto;
import com.five.amung.reserve.dto.RoomPriceDto;
import com.five.amung.reserve.service.ReserveService;

@Controller
public class ReserveController {
	@Autowired
	private ReserveService reserveService;
	
	@Autowired
	private DogsService dogsService;
	
	@RequestMapping("/reserve/reserveform")
	public ModelAndView reserveform(ModelAndView mView) {
		
		mView.setViewName("reserve/reserveform");
		return mView;
	}
	
	@RequestMapping(value = "/reserve/getPrice", method=RequestMethod.GET)
	@ResponseBody
	//방, 체크인 , 체크아웃, 강아지 몸무게 에 따른 가격 불러오기
	public Map<String, Object> getPrice(RoomPriceDto dto){
		//1. 강아지 번호로 강아지 몸무게를 얻어와서 dto 에 담는다.
		int num=dto.getDog_num();
		DogsDto dogDto=dogsService.getData(num);
		String weight=dogDto.getWeight();
		dto.setWeight(weight);
		//2. 전송된 값을 이용해서 서비스에서 가격을 담아온다.
		Map<String, Object> map=reserveService.getPrice(dto);
		
		return map;
	}

	// 리연 추가 - 20200923 일단 페이지만 추가함
	// 마이페이지 / 예약현황
	@RequestMapping("/mypage/private/reserve/status")
	public ModelAndView reserveStatus(HttpServletRequest request, ModelAndView mView) {
		mView.setViewName("mypage/reserve_status");
		return mView;
	}//==== reserveStatus ====
}//======== ReServeController ========