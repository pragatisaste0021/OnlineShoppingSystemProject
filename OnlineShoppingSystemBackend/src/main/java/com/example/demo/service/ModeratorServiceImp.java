package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ModeratorDao;
import com.example.demo.entity.Moderator;
import com.example.demo.exception.ResourceNotFoundException;

@Service
public class ModeratorServiceImp implements ModeratorService{

	@Autowired
	ModeratorDao dao;
	
	@Override
	public List<Moderator> findAllModerators() {
		List<Moderator> list = dao.findAll();
		return list;
	}

	@Override
	public Moderator findModeratorById(int id) {
		return dao.findById(id).orElseThrow(() -> new ResourceNotFoundException ("Moderator does not exist with id : " + id));
	}

	@Override
	public Moderator addModerator(Moderator m) {
		Moderator existingModerator = dao.findById(m.getModID()).orElse(null);
		if(existingModerator == null) {
			m.setModName(m.getModName());
			m.setModAddress(m.getModAddress());
			m.setEmailId(m.getEmailId());
			m.setEducation(m.getEducation());
			m.setMob_no(m.getMob_no());
			m.setAge(m.getAge());
			m.setDateOfBirth(m.getDateOfBirth());
			return dao.save(m);
		}
		else {
			throw new ResourceNotFoundException("Moderator id already exists");
		}
	}

	@Override
	public Moderator updateModerator(Moderator m) {
		Moderator existingModerator = dao.findById(m.getModID()).orElse(null);
		if(existingModerator != null) {
			m.setModName(m.getModName());
			m.setModAddress(m.getModAddress());
			m.setEmailId(m.getEmailId());
			m.setEducation(m.getEducation());
			m.setMob_no(m.getMob_no());
			m.setAge(m.getAge());
			m.setDateOfBirth(m.getDateOfBirth());
			return dao.save(m);
		}
		else {
			throw new ResourceNotFoundException("Moderator id does not exist");
		}
	}

	@Override
	public void deleteModerator(int id) {
		Moderator existingModerator = dao.findById(id).orElse(null);
		if(existingModerator != null) {
			dao.deleteById(id);
		}
		else {
			throw new ResourceNotFoundException("Moderator id does not exist");
		}
	}

	
}
