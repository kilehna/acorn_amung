package com.five.amung.reserve.dto;

public class ReserveDto {
	private int num;
	private String member_id;
	private int dog_num;
	private String room_name;
	private String checkin_date;
	private String checkout_date;
	private String start_time;
	private String end_time;
	private String name;
	private String phone;
	private String regdate;
	private String cancel; //예약 취소 여부저장 필드 //"yes" or "no"
	
	public ReserveDto() {}

	public ReserveDto(int num, String member_id, int dog_num, String room_name, String checkin_date,
			String checkout_date, String start_time, String end_time, String name, String phone, String regdate,
			String cancel) {
		super();
		this.num = num;
		this.member_id = member_id;
		this.dog_num = dog_num;
		this.room_name = room_name;
		this.checkin_date = checkin_date;
		this.checkout_date = checkout_date;
		this.start_time = start_time;
		this.end_time = end_time;
		this.name = name;
		this.phone = phone;
		this.regdate = regdate;
		this.cancel = cancel;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getMember_id() {
		return member_id;
	}

	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}

	public int getDog_num() {
		return dog_num;
	}

	public void setDog_num(int dog_num) {
		this.dog_num = dog_num;
	}

	public String getRoom_name() {
		return room_name;
	}

	public void setRoom_name(String room_name) {
		this.room_name = room_name;
	}

	public String getCheckin_date() {
		return checkin_date;
	}

	public void setCheckin_date(String checkin_date) {
		this.checkin_date = checkin_date;
	}

	public String getCheckout_date() {
		return checkout_date;
	}

	public void setCheckout_date(String checkout_date) {
		this.checkout_date = checkout_date;
	}

	public String getstart_time() {
		return start_time;
	}

	public void setstart_time(String start_time) {
		this.start_time = start_time;
	}

	public String getend_time() {
		return end_time;
	}

	public void setend_time(String end_time) {
		this.end_time = end_time;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	public String getCancel() {
		return cancel;
	}

	public void setCancel(String cancel) {
		this.cancel = cancel;
	}
	
}
