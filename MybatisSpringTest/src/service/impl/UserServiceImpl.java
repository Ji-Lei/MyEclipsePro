package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import dao.mapper.UserMapper;
import pojo.User;
import pojo.UsersList;
import service.UserService;

@Transactional(propagation = Propagation.REQUIRED)//添加事务注解,放在此处是全局添加，也可以添加到具体方法上面
@Service("userService")//注解创建实例
public class UserServiceImpl implements UserService{
	
	@Autowired
	@Qualifier("userMapper")//指定固定的对象，直接从spring配置文件获取，而不是注解里
	private UserMapper dao;
	
	@Override
	public List<UsersList> getUsers(String username) {
		return dao.getUsers(username);
	}

	@Override
	public void addUser(User user) {
		dao.addUser(user);
	}

	@Override
	public void deleteUser(String username) {
		dao.deleteUser(username);
	}

	@Override
	public void updateUser(User user) {
		dao.updateUser(user);		
	}

	@Override
	public void addListUsers(List<User> users) {
//		事务处理多次添加，失败一个都会失败
		for(User user:users) {
			addUser(user);
		}
	}

}
