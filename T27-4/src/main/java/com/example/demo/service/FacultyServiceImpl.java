package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IFacultyDAO;
import com.example.demo.dto.Faculty;

@Service
public class FacultyServiceImpl implements IFacultyService{

	@Autowired
	IFacultyDAO iFacultyDAO;

	@Override
	public List<Faculty> listAllFaculties() {
		return iFacultyDAO.findAll();
	}

	@Override
	public Faculty saveFaculty(Faculty f) {
		return iFacultyDAO.save(f);
	}

	@Override
	public Faculty facultyById(Long id) {
		return iFacultyDAO.findById(id).get();
	}

	@Override
	public Faculty updateFaculty(Faculty f) {
		return iFacultyDAO.save(f);
	}

	@Override
	public void deleteFaculty(Long id) {
		iFacultyDAO.deleteById(id);
	}
	
	
}
