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

import com.example.demo.dto.Faculty;
import com.example.demo.service.FacultyServiceImpl;

@RestController
@RequestMapping("/api")
public class FacultyController {
	
	@Autowired
	FacultyServiceImpl facultyServiceImpl;
	
	@GetMapping("/faculties")
	public List<Faculty> getAllFaculties() {
		return facultyServiceImpl.listAllFaculties();
	}
	
	@PostMapping("/faculties")
	public Faculty saveFaculty(@RequestBody Faculty f) {
		return facultyServiceImpl.saveFaculty(f);
	}
	
	@GetMapping("/faculties/{id}")
	public Faculty getFacultyById(@PathVariable(name = "id") Long id) {
		return facultyServiceImpl.facultyById(id);
	}
	
	@PutMapping("/faculties/{id}")
	public Faculty updateFaculty(@PathVariable(name = "id") Long id, @RequestBody Faculty f) {
		Faculty selectedFaculty;
		Faculty updatedFaculty;

		selectedFaculty = facultyServiceImpl.facultyById(id);

		selectedFaculty.setName(f.getName());
		selectedFaculty.setResearchers(f.getResearchers());
		selectedFaculty.setTeams(f.getTeams());

		updatedFaculty = facultyServiceImpl.saveFaculty(selectedFaculty);

		return updatedFaculty;
	}
	
	@DeleteMapping("/faculties/{id}")
	public void deleteFaculty(@PathVariable(name = "id") Long id) {
		facultyServiceImpl.deleteFaculty(id);
	}
}
