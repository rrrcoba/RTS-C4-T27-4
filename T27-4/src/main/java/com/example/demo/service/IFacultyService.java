package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.Faculty;

public interface IFacultyService {
	
	/**
	 * Returns all Faculty
	 * 
	 * @return the list
	 */
	public List<Faculty> listAllFaculties();
	
	/**
	 * Saves the Faculty
	 * 
	 * @param f
	 * @return the Faculty
	 */
	public Faculty saveFaculty(Faculty f);
	
	/**
	 * Returns a Faculty
	 * 
	 * @param id
	 * @return the Faculty
	 */
	public Faculty facultyById(Long id);
	
	/**
	 * Updates the Faculty
	 * 
	 * @param f
	 * @return the Faculty
	 */
	public Faculty updateFaculty(Faculty f);
	
	/**
	 * Deletes a Faculty
	 * 
	 * @param id
	 */
	public void deleteFaculty(Long id);
}
