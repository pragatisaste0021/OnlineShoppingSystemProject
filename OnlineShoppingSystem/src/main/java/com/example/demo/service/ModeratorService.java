package com.example.demo.service;

import java.util.List;
 

import com.example.demo.entity.Moderator;

public interface ModeratorService {

	public List<Moderator> findAllModerators();
	public Moderator findModeratorById(int id);
	public Moderator addModerator(Moderator m);
	public Moderator updateModerator(Moderator m);
	public void deleteModerator(int id);
}
