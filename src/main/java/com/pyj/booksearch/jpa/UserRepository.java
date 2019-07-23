package com.pyj.booksearch.jpa;

import com.pyj.booksearch.dto.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
