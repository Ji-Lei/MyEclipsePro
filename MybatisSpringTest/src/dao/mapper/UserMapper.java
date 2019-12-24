package dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import pojo.User;
import pojo.UsersList;

public interface UserMapper {
	public List<UsersList> getUsers(@Param("username")String username);
	public void addUser(User user);
	public void deleteUser(@Param("username")String username);
	public void updateUser(User user);
	
}
