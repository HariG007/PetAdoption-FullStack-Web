package com.teamx.petadopt.repository.impl; 
import java.util.List; 
import java.util.Optional; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.teamx.petadopt.model.Login;
import com.teamx.petadopt.model.User;
import com.teamx.petadopt.repository.LoginRepository;
import com.teamx.petadopt.repository.UserRepository;
import com.teamx.petadopt.service.UserService;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional; 

@Service //specify that a class performs business logic or data manipulation tasks.
@Transactional//in order to delete data in the database using delete API request 
public class UserServiceImpl implements UserService{
	@Autowired//in-order to access database 
	private UserRepository userRepository; 
	
	@Override 
	public boolean addUser(User user) 
	{
		boolean userExists = userRepository.existsByEmail(user.getEmail()); //To check if the record is present or not? 
		if(!userExists)
		{
			userRepository.save(user); 
			return true; 
		}
		else
		{
			return false;
		}
	}
	@Override 
	public List<User> getUser() //return list of data
	{
		return userRepository.findAll(); 
	}
	@Override 
	public boolean updateUser(Long id, User user)
	{
		Optional<User> existingUserOptional = userRepository.findById(id);
		//container object 
		if(existingUserOptional.isPresent())
		{
			User userExists = existingUserOptional.get(); 
			userExists.setAnimaltype(user.getAnimaltype());
			userExists.setName(user.getName()); 
			userExists.setAge(user.getAge());
			userExists.setEmail(user.getEmail());
			userExists.setId(user.getId());
			userExists.setSex(user.getSex()); 
			userExists.setBreed(user.getBreed());
			userExists.setColour(user.getColour()); 
			userRepository.save(userExists);
			return true;
			}
		else
		{
			return false;
		}
		
		}
	@Override
    public void addUserByJPQL(User user) {
        entityManager.persist(user);
    }
	 @Override
	    public void updateUserByJPQL(Long id, User user) {
	        User existingUser = entityManager.find(User.class, id);
	        if (existingUser != null) {
	            existingUser.setAnimaltype(user.getAnimaltype());
	            existingUser.setName(user.getName());
	            // ... set other properties ...
	            entityManager.merge(existingUser);
	        }
	    }

	    @Override
	    public void deleteUserByJPQL(Long id) {
	        User userToDelete = entityManager.find(User.class, id);
	        if (userToDelete != null) {
	            entityManager.remove(userToDelete);
	        }
	    }
	    
	@Override 
	public boolean deleteUser(Long id) 
	{
		Optional<User> existingUserOptional = userRepository.findById(id);
		if(existingUserOptional.isPresent()) 
		{
			userRepository.deleteById(id); 
			return true; 
			}
		else
		{
			return false; 
		}
	}
	
	@Override
	public Page<User> getAllUser(PageRequest pageRequest) 
	{
		return userRepository.findAll(pageRequest);//Return page of user
	}
	
	@PersistenceContext
    private EntityManager entityManager;

	@Autowired
    private LoginRepository loginRepository;
	
    @Override
    public void addLogin(Login login) {
        loginRepository.save(login);
    }

    @Override
    public Login getLoginByUsername(String username) {
        return loginRepository.findByUsername(username);
    }
	
	}
