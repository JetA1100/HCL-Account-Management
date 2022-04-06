package com.bpb.publications.authors.repository;

import org.springframework.data.repository.CrudRepository;
import com.bpb.publications.authors.entity.Author;
import java.util.Optional;

public interface AuthorRepository extends CrudRepository<Author, Integer> {
	Optional<Author> findByNameAndUrl(String name, String url);

}
