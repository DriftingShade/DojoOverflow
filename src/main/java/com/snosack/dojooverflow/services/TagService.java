package com.snosack.dojooverflow.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.snosack.dojooverflow.models.Tag;
import com.snosack.dojooverflow.repositories.TagRepository;

@Service
public class TagService {
	@Autowired
	private TagRepository tRepo;
	
	public Tag findBySubject(String subject) {
		return tRepo.findBySubjectIs(subject);
	}
	
	public Tag addTag(Tag tag) {
		return tRepo.save(tag);
	}

}
