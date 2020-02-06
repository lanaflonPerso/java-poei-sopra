package org.eclipse.firstspringmvc.dao;

import org.eclipse.firstspringmvc.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long>{

}
