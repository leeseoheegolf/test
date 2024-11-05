package com.lostay.backend.reservation.repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.lostay.backend.reservation.dto.BookHistoryDTO;
import com.lostay.backend.reservation.dto.ReservationHistoryDTO;
import com.lostay.backend.reservation.entity.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long>{

	// 결제 취소 시 reservation 테이블에서 payNo외래키 통해서 데이터 찾기
	Optional<Reservation> findByPayment_PayNo(long payNo);

	// 체크인 안한 숙소
	@Query("SELECT new com.lostay.backend.reservation.dto.ReservationHistoryDTO(" +
			   "u.userNickname, " +
	           "res.reservationNo, res.resReviewStatus, res.checkIn, res.checkOut, " +
	           "p.payNo, p.payDay, r.roomNo, r.roomName, " +
	           "r.roomCheckinTime, r.roomCheckoutTime, " +
	           "h.hotelNo, h.hotelName, h.hotelThumbnail) " +
	           "FROM Reservation res " +
	           "JOIN res.payment p " +
	           "JOIN p.user u " +
	           "JOIN p.room r " +
	           "JOIN r.hotel h " +
	           "WHERE u.userNo = :userNo " +
	           "AND res.resStatus = :resStatus " +
	           "AND res.checkIn > CURRENT_TIMESTAMP " +
			   "ORDER BY res.checkIn ASC " )
	List<ReservationHistoryDTO> findBookHistory(@Param("userNo") Long userNo, @Param("resStatus") String resStatus);

	// 이용 완료한 숙소
	@Query("SELECT new com.lostay.backend.reservation.dto.ReservationHistoryDTO(" +
			   "u.userNickname, " +
	           "res.reservationNo, res.resReviewStatus, res.checkIn, res.checkOut, " +
	           "p.payNo, p.payDay, r.roomNo, r.roomName, " +
	           "r.roomCheckinTime, r.roomCheckoutTime, " +
	           "h.hotelNo, h.hotelName, h.hotelThumbnail) " +
	           "FROM Reservation res " +
	           "JOIN res.payment p " +
	           "JOIN p.user u " +
	           "JOIN p.room r " +
	           "JOIN r.hotel h " +
	           "WHERE u.userNo = :userNo " +
	           "AND res.resStatus = :resStatus " +
	           "AND res.checkIn >= :startDateTime " + 
	           "AND res.checkIn < CURRENT_TIMESTAMP " +
	           "ORDER BY res.checkIn DESC " )
	List<ReservationHistoryDTO> findBookedHistory(@Param("userNo") Long userNo, @Param("resStatus") String resStatus, @Param("startDateTime") LocalDateTime startDateTime);

	// 예약 취소한 숙소
	@Query("SELECT new com.lostay.backend.reservation.dto.ReservationHistoryDTO(" +
			   "u.userNickname, " +
	           "res.reservationNo, res.resReviewStatus, res.checkIn, res.checkOut, " +
	           "p.payNo, p.payDay, r.roomNo, r.roomName, " +
	           "r.roomCheckinTime, r.roomCheckoutTime, " +
	           "h.hotelNo, h.hotelName, h.hotelThumbnail) " +
	           "FROM Reservation res " +
	           "JOIN res.payment p " +
	           "JOIN p.user u " +
	           "JOIN p.room r " +
	           "JOIN r.hotel h " +
	           "WHERE u.userNo = :userNo " +
	           "AND res.resStatus = :resStatus " +
	           "ORDER BY res.checkIn DESC " )
	List<ReservationHistoryDTO> findBookCancleHistory(@Param("userNo") Long userNo, @Param("resStatus") String resStatus);


}
