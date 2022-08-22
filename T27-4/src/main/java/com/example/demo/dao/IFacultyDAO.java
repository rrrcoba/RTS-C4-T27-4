package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.dto.Faculty;

public interface IFacultyDAO extends JpaRepository<Faculty, Long>{

}
