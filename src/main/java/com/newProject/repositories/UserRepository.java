package com.newProject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.newProject.models.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
	
	
	public static final String SELECT_FROM_USER_MASTER_O_WHERE_O_USER_ID_ID = "SELECT * FROM USER_MASTER o where o.user_id = :id";
	
	public static final String SELECT_FROM_USER_MASTER_O_WHERE_O_USER_EMAIL_EMAIL = "SELECT * FROM USER_MASTER o where o.user_email = :email";
	
	public static final String DELETE_FROM_USER_MASTER_O_WHERE_O_USER_ID_ID = "DELETE FROM USER_MASTER o WHERE o.user_id =:Id";

	@SuppressWarnings("unchecked")
	User save(User user);
	
	@Query(value = SELECT_FROM_USER_MASTER_O_WHERE_O_USER_ID_ID , nativeQuery = true)
	User getUserById(Long id);
	
	@Query(value = SELECT_FROM_USER_MASTER_O_WHERE_O_USER_EMAIL_EMAIL , nativeQuery = true)
	User getUserByEmail(String email);
	
	@Modifying
    @Query(value = DELETE_FROM_USER_MASTER_O_WHERE_O_USER_ID_ID , nativeQuery = true)
    void deleteById(int Id);
}
