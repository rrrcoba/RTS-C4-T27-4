package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.dto.Reservation;
import com.example.demo.service.ReservationServiceImpl;

@RestController
@RequestMapping("/api")
public class ReservationController {

	@Autowired
	ReservationServiceImpl reservationServiceImpl;

	@GetMapping("/reservations")
	public List<Reservation> getAllReservations() {
		return reservationServiceImpl.listAllReservations();
	}

	@PostMapping("/reservations")
	public Reservation saveReservation(@RequestBody Reservation r) {
		return reservationServiceImpl.saveReservation(r);
	}

	@GetMapping("/reservations/{id}")
	public Reservation reservationSaleById(@PathVariable(name = "id") Long id) {
		return reservationServiceImpl.reservationById(id);
	}

	@PutMapping("/reservations/{id}")
	public Reservation updateReservation(@PathVariable(name = "id") Long id, @RequestBody Reservation r) {
		Reservation selectedReservation;
		Reservation updatedReservation;

		selectedReservation = reservationServiceImpl.reservationById(id);

		selectedReservation.setResearcher(r.getResearcher());
		selectedReservation.setTeam(r.getTeam());
		selectedReservation.setStart(r.getStart());
		selectedReservation.setFinish(r.getFinish());

		updatedReservation = reservationServiceImpl.saveReservation(selectedReservation);

		return updatedReservation;
	}

	@DeleteMapping("/reservations/{id}")
	public void deleteReservation(@PathVariable(name = "id") Long id) {
		reservationServiceImpl.deleteReservation(id);
	}
}
