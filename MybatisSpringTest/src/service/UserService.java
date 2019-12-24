package service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import pojo.User;
import pojo.UsersList;

public interface UserService {
	public List<UsersList> getUsers(String username);
	public void addUser(User user);
	public void deleteUser(String username);
	public void updateUser(User user);
	public void addListUsers(List<User> users);
}
