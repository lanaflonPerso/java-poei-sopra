package org.eclipse.firstspringmvc.dao;

import org.eclipse.firstspringmvc.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
	public User findByUserName(String username);
}
