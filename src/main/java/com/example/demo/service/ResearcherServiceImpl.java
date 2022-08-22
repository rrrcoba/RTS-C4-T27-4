package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IResearcherDAO;
import com.example.demo.dto.Researcher;

@Service
public class ResearcherServiceImpl implements IResearcherService{

	@Autowired
	IResearcherDAO iResearcherDAO;

	@Override
	public List<Researcher> listAllResearchers() {
		return iResearcherDAO.findAll();
	}

	@Override
	public Researcher saveResearcher(Researcher r) {
		return iResearcherDAO.save(r);
	}

	@Override
	public Researcher researcherById(Long id) {
		return iResearcherDAO.findById(id).get();
	}

	@Override
	public Researcher updateResearcher(Researcher r) {
		return iResearcherDAO.save(r);
	}

	@Override
	public void deleteResearcher(Long id) {
		iResearcherDAO.deleteById(id);
	}

	
}
