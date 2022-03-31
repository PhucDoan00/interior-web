package doan.backend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import doan.backend.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{

	Optional<Role> findByRoleName(String name);
	
}
