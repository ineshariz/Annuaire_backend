package com.cynapsys.demo.dao;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.cynapsys.demo.models.User;

public interface UserRepostory extends JpaRepository<User, Integer>{	
	
	Optional<User> findByEmail(String email);
}
