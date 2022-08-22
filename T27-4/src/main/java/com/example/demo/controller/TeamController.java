package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.Team;
import com.example.demo.service.TeamServiceImpl;

@RestController
@RequestMapping("/api")
public class TeamController {

	@Autowired
	TeamServiceImpl teamServiceImpl;
	
	@GetMapping("/teams")
	public List<Team> getAllTeams() {
		return teamServiceImpl.listTeams();
	}
	
	@PostMapping("/teams")
	public Team saveTeam(@RequestBody Team t) {
		return teamServiceImpl.saveTeam(t);
	}
	
	@GetMapping("/teams/{id}")
	public Team getTeamById(@PathVariable(name="id") Long id) {
		return teamServiceImpl.teamById(id);
	}
	
	@PutMapping("/teams/{id}")
	public Team updateTeam(@PathVariable(name="id") Long id, @RequestBody Team t) {
		Team selectedTeam;
		Team updatedTeam;
		
		selectedTeam = teamServiceImpl.teamById(id);
		
		selectedTeam.setName(t.getName());
		selectedTeam.setFaculty(t.getFaculty());
		selectedTeam.setReservations(t.getReservations());
		
		updatedTeam = teamServiceImpl.saveTeam(selectedTeam);
		
		return updatedTeam;
	}
	
	@DeleteMapping("/teams/{id}")
	public void deleteTeam(@PathVariable(name="id") Long id) {
		teamServiceImpl.deleteTeam(id);
	}
}
