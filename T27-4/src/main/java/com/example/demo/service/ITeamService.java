package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.Team;

public interface ITeamService {
	/**
	 * Lists all the Team
	 * @return
	 */
	public List<Team> listTeams();
	
	/**
	 * Saves a Team
	 * @param t
	 * @return
	 */
	public Team saveTeam(Team t);
	
	/**
	 * Gets the Team by ID
	 * @param id
	 * @return
	 */
	public Team teamById(Long id);
	
	/**
	 * Updates the Team
	 * @param t
	 * @return
	 */
	public Team updateTeam(Team t);
	
	/**
	 * Deletes the Team
	 * @param id
	 */
	public void deleteTeam(Long id);
}
