package com.example.demo.dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="researchers")
public class Researcher {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="DNI")
	private String dni;
	
	@Column(name="name_surname")
	private String nameSurname;
	
	@ManyToOne
	@JoinColumn(name="faculty")
	private Faculty faculty;
	
	@OneToMany
	@JoinColumn(name="id")
	private List<Reservation> reservations;
	
	
	// Constructors
	
	/**
	 * Default constructor
	 */
	public Researcher () {
		
	}
	
	/**
	 * Constructor using fields
	 * 
	 * @param id
	 * @param dni
	 * @param nameSurname
	 * @param faculty
	 * @param reservations
	 */
	public Researcher(Long id, String dni, String nameSurname, Faculty faculty, List<Reservation> reservations) {
		this.id = id;
		this.dni = dni;
		this.nameSurname = nameSurname;
		this.faculty = faculty;
		this.reservations = reservations;
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
	 * @return the dni
	 */
	public String getDni() {
		return dni;
	}

	/**
	 * @param dni the dni to set
	 */
	public void setDni(String dni) {
		this.dni = dni;
	}

	/**
	 * @return the nameSurname
	 */
	public String getNameSurname() {
		return nameSurname;
	}

	/**
	 * @param nameSurname the nameSurname to set
	 */
	public void setNameSurname(String nameSurname) {
		this.nameSurname = nameSurname;
	}

	/**
	 * @return the faculty
	 */
	public Faculty getFaculty() {
		return faculty;
	}

	/**
	 * @param faculty the faculty to set
	 */
	public void setFaculty(Faculty faculty) {
		this.faculty = faculty;
	}

	/**
	 * @param reservations the reservations to set
	 */
	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}
	
	/**
	 * @return the reservations
	 */
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "Reservation")
	public List<Reservation> getReservations() {
		return reservations;
	}
}