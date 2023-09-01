package com.teamx.petadopt.service;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.teamx.petadopt.model.Login;
import com.teamx.petadopt.model.User;


public interface UserService {
	public boolean addUser(User user);
	public List<User> getUser();
	public boolean updateUser(Long id, User user);
	public boolean deleteUser(Long id);
	public Page<User> getAllUser(PageRequest pageRequest);
	public void addUserByJPQL(User user);
	public void updateUserByJPQL(Long id, User user);
    public void deleteUserByJPQL(Long id);
    void addLogin(Login login);
    Login getLoginByUsername(String username);
}
