package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.dto.Reservation;

public interface IReservationDAO extends JpaRepository<Reservation, Long>{

}
