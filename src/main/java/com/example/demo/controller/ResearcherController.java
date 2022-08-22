package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.dto.Researcher;
import com.example.demo.service.ResearcherServiceImpl;

@RestController
@RequestMapping("/api")
public class ResearcherController {
	
	@Autowired
	ResearcherServiceImpl researcherServiceImpl;
	
	@GetMapping("/researchers")
	public List<Researcher> getAllResearchers(){
		return researcherServiceImpl.listAllResearchers();
	}
	
	@PostMapping("/researchers")
	public Researcher saveResearcher(@RequestBody Researcher r) {
		return researcherServiceImpl.saveResearcher(r);
	}
	
	@GetMapping("/researchers/{id}")
	public Researcher getResearcherById(@PathVariable(name="id")Long id) {
		return researcherServiceImpl.researcherById(id);
	}
	
	@PutMapping("/researchers/{id}")
	public Researcher updateResearcher(@PathVariable(name="id")Long id, @RequestBody Researcher r) {
		Researcher selectedResearcher;
		Researcher updatedResearcher;
		
		selectedResearcher = researcherServiceImpl.researcherById(id);
		
		selectedResearcher.setDni(r.getDni());
		selectedResearcher.setNameSurname(r.getNameSurname());
		selectedResearcher.setFaculty(r.getFaculty());
		selectedResearcher.setReservations(r.getReservations());
		
		updatedResearcher = researcherServiceImpl.saveResearcher(selectedResearcher);
		
		return updatedResearcher;
	}
	
	@DeleteMapping("/researchers/{id}")
	public void deleteResearcher(@PathVariable(name="id")Long id) {
		researcherServiceImpl.deleteResearcher(id);
	}
}
