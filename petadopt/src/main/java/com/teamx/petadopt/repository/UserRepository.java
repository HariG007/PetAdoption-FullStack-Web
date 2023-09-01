package com.teamx.petadopt.repository; 
import java.util.List;
import java.util.Optional; 
import org.springframework.data.jpa.repository.JpaRepository; 
import com.teamx.petadopt.model.User;
public interface UserRepository extends JpaRepository<User,Integer>
{
	boolean existsByEmail(String Email);
	Optional<User> findById(Long id);
	void deleteById(Long id);
}