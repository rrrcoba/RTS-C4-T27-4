package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IReservationDAO;
import com.example.demo.dto.Reservation;

@Service
public class ReservationServiceImpl implements IReservationService{
	
	@Autowired
	IReservationDAO iReservationDAO;

	@Override
	public List<Reservation> listAllReservations() {
		return iReservationDAO.findAll();
	}

	@Override
	public Reservation saveReservation(Reservation r) {
		return iReservationDAO.save(r);
	}

	@Override
	public Reservation reservationById(Long id) {
		return iReservationDAO.findById(id).get();
	}

	@Override
	public Reservation updateReservation(Reservation r) {
		return iReservationDAO.save(r);
	}

	@Override
	public void deleteReservation(Long id) {
		iReservationDAO.deleteById(id);
	}

	
}
