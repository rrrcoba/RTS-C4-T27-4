package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ITeamDAO;
import com.example.demo.dto.Team;

@Service
public class TeamServiceImpl implements ITeamService{

	@Autowired
	ITeamDAO iTeamDAO;

	@Override
	public List<Team> listTeams() {
		return iTeamDAO.findAll();
	}

	@Override
	public Team saveTeam(Team t) {
		return iTeamDAO.save(t);
	}

	@Override
	public Team teamById(Long id) {
		return iTeamDAO.findById(id).get();
	}

	@Override
	public Team updateTeam(Team t) {
		return iTeamDAO.save(t);
	}

	@Override
	public void deleteTeam(Long id) {
		iTeamDAO.deleteById(id);
	}

	
}
