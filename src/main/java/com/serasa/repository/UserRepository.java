package com.serasa.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.serasa.domain.User;
import com.serasa.interf.UserRepositoryCustom;

@Repository
public interface UserRepository extends CrudRepository<User, Long> , UserRepositoryCustom { 
	
	@Query("SELECT s FROM User s WHERE s.username =  :username ")
    User findByUsername(String username); 
}
