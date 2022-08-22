package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.dto.Researcher;

public interface IResearcherDAO extends JpaRepository<Researcher, Long>{

}
