package com.lostay.backend.reservation.dto;

import java.time.LocalDateTime;
import java.time.LocalTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReservationHistoryDTO {
	
	// 사용자
	private String userNickname;		// 사용자 닉네임
	
	// 예약
	private Long reservationNo; 		// 예약 넘버
	private String resReviewStatus; 	// 리뷰 작성 여부
	private LocalDateTime checkIn; 		// 체크인 날짜
	private LocalDateTime checkOut; 	// 체크아웃 날짜

	// 결제
	private Long payNo; 				// 결제 넘버
	private LocalDateTime payDay;		// 결제 날짜

	// 객실
	private Long roomNo; 				// 객실넘버
	private String roomName; 			// 객실명
	private LocalTime roomCheckInTime; 	// 객실 체크인 시간
	private LocalTime roomCheckOutTime; // 객실 체크아웃 시간

	// 호텔
	private Long hotelNo; 				// 호텔 넘버
	private String hotelName;			// 호텔 이름
	private String hotelThumbnail; 		// 호텔 썸네일
}
