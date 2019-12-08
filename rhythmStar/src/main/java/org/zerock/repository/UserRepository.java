package org.zerock.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.zerock.domain.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByName(String name);
	User findById(String id);

}
