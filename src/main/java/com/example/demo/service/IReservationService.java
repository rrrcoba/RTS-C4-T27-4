package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.Reservation;

public interface IReservationService {
	
	/**
	 * Lists all the Reservation
	 * @return
	 */
	public List<Reservation> listAllReservations();
	
	/**
	 * Saves a Reservation
	 * @param r
	 * @return
	 */
	public Reservation saveReservation(Reservation r);
	
	/**
	 * Gets the Reservation by ID
	 * @param id
	 * @return
	 */
	public Reservation reservationById(Long id);
	
	/**
	 * Updates the Reservation
	 * @param r
	 * @return
	 */
	public Reservation updateReservation(Reservation r);
	
	/**
	 * Deletes the Reservation
	 * @param id
	 */
	public void deleteReservation(Long id);

}