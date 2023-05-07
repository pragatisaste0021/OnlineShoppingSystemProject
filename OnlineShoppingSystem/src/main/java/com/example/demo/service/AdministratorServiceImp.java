package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.dao.AdministratorDao;
import com.example.demo.dao.ModeratorDao;
import com.example.demo.entity.Administrator;
import com.example.demo.entity.Moderator;
import com.example.demo.entity.User;
import com.example.demo.exception.ResourceNotFoundException;

@Service
public class AdministratorServiceImp implements AdministratorService{

	@Autowired
	AdministratorDao dao;
	
	@Autowired
	ModeratorDao mdao;
	
	
	@Override
	public List<Administrator> findAllAdministrator() {
		List<Administrator> list = dao.findAll();
		return list;
	}

	@Override
	public Administrator findAdministratorById(int id) {
		return dao.findById(id).orElseThrow(() -> new ResourceNotFoundException("Administrator id does not exist"));
	}

	@Override
	public Administrator addAdministrator(Administrator a) {
		Administrator existingAdministrator = dao.findById(a.getAdmin_id()).orElse(null);
		if(existingAdministrator == null) {
			a.setAdmin_name(a.getAdmin_name());
			a.setAdmin_address(a.getAdmin_address());
			a.setAdmin_emailId(a.getAdmin_emailId());
			a.setAdmin_password(a.getAdmin_password());
			a.setAdmin_mobile_no(a.getAdmin_mobile_no());
			a.setModerator_id(a.getModerator_id());
			return dao.save(a);
		}
		else {
			throw new ResourceNotFoundException("Moderator id already exists");
		}
	}

	@Override
	public Administrator updateAdministrator(Administrator a) {
		Administrator existingAdministrator = dao.findById(a.getAdmin_id()).orElse(null);
		if(existingAdministrator != null) {
			a.setAdmin_name(a.getAdmin_name());
			a.setAdmin_emailId(a.getAdmin_emailId());
			a.setAdmin_password(a.getAdmin_password());
			a.setAdmin_mobile_no(a.getAdmin_mobile_no());
			a.setModerator_id(a.getModerator_id());
			return dao.save(a);
		
	}
		else {
			throw new ResourceNotFoundException("Moderator id does not exist");
		}
	}

	@Override
	public void deleteAdministrator(int id) {
		Administrator existingAdministrator = dao.findById(id).orElse(null);
		if(existingAdministrator != null) {
			dao.deleteById(id);
		}
		else {
			throw new ResourceNotFoundException("Moderator id does not exist");
		}
	}

}
