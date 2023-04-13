package com.example.AuthorizationAndPasswordEncryption.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.AuthorizationAndPasswordEncryption.Modal.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Integer> {
	
	@Query( "select u from UserEntity u where u.userName = :username" )
	public UserEntity findByUserName( String username);

}
