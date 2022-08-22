package com.example.demo.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="reservations")
public class Reservation {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="id_researcher")
	private Researcher researcher;
	
	@ManyToOne
	@JoinColumn(name="id_team")
	private Team team;
	
	private String start;
	
	private String finish;
	
	//Constructors
	
	/**
	 * Default constructor
	 */
	public Reservation () {
		
	}

	/**
	 * Constructor using fields
	 * 
	 * @param id
	 * @param researcher
	 * @param team
	 * @param start
	 * @param finish
	 */
	public Reservation(Long id, Researcher researcher, Team team, String start, String finish) {
		this.id = id;
		this.researcher = researcher;
		this.team = team;
		this.start = start;
		this.finish = finish;
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
	 * @return the researcher
	 */
	public Researcher getResearcher() {
		return researcher;
	}

	/**
	 * @param researcher the researcher to set
	 */
	public void setResearcher(Researcher researcher) {
		this.researcher = researcher;
	}

	/**
	 * @return the team
	 */
	public Team getTeam() {
		return team;
	}

	/**
	 * @param team the team to set
	 */
	public void setTeam(Team team) {
		this.team = team;
	}

	/**
	 * @return the start
	 */
	public String getStart() {
		return start;
	}

	/**
	 * @param start the start to set
	 */
	public void setStart(String start) {
		this.start = start;
	}

	/**
	 * @return the finish
	 */
	public String getFinish() {
		return finish;
	}

	/**
	 * @param finish the finish to set
	 */
	public void setFinish(String finish) {
		this.finish = finish;
	}
}
