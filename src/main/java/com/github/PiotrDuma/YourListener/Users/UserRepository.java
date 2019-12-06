package com.github.PiotrDuma.YourListener.Users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<WebUser, Long>{	
	WebUser findUserByUsername(String username);
}
