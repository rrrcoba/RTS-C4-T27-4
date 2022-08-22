package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.Researcher;

public interface IResearcherService {
	
	/**
	 * Lists all the Researchers
	 * @return
	 */
	public List<Researcher> listAllResearchers();
	
	/**
	 * Saves a Researcher
	 * @param r
	 * @return
	 */
	public Researcher saveResearcher(Researcher r);
	
	/**
	 * Gets the Researcher by ID
	 * @param id
	 * @return
	 */
	public Researcher researcherById(Long id);
	
	/**
	 * Updates the Researcher
	 * @param r
	 * @return
	 */
	public Researcher updateResearcher(Researcher r);
	
	/**
	 * Deletes the Researcher
	 * @param id
	 */
	public void deleteResearcher(Long id);

}
