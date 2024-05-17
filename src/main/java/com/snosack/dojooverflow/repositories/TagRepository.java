package com.snosack.dojooverflow.repositories;

import org.springframework.data.repository.CrudRepository;

import com.snosack.dojooverflow.models.Tag;

public interface TagRepository extends CrudRepository<Tag, Long> {
	Tag findBySubjectIs(String subject);

}
