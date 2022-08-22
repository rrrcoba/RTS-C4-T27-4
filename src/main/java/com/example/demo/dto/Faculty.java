package com.example.demo.dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="faculties")
public class Faculty {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	@OneToMany
	@JoinColumn(name="id")
	private List<Researcher> researchers;
	
	@OneToMany
	@JoinColumn(name="id")
	private List<Team> teams;
	
	
	// Constructors
	
	/**
	 * Default constructor
	 */
	public Faculty() {
	}
	
	/**
	 * Constructor using fields
	 * 
	 * @param id
	 * @param name
	 * @param researchers
	 * @param teams
	 */
	public Faculty(Long id, String name, List<Researcher> researchers, List<Team> teams) {
		this.id = id;
		this.name = name;
		this.researchers = researchers;
		this.teams = teams;
	}

	// Getters and setters
	
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the teams
	 */
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "Team")
	public List<Team> getTeams() {
		return teams;
	}

	/**
	 * @param teams the teams to set
	 */
	public void setTeams(List<Team> teams) {
		this.teams = teams;
	}

	/**
	 * @param researchers the researchers to set
	 */
	public void setResearchers(List<Researcher> researchers) {
		this.researchers = researchers;
	}

	/**
	 * @return the researchers
	 */
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "Researcher")
	public List<Researcher> getResearchers() {
		return researchers;
	}
}
