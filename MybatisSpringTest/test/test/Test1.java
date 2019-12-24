package test;


import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import pojo.User;
import pojo.UsersList;
import service.UserService;

public class Test1 {

	@Test
	public void test() {
		ApplicationContext context=
				new ClassPathXmlApplicationContext("SpringContext.xml");
		UserService service=(UserService)context.getBean("userService");
//		添加方法
//		User user1=new User();
//		user1.setUsername("admin4");
//		user1.setPassword("666888");
//		service.addUser(user1);
		
//		删除方法
//		service.deleteUser("admin");
		
//		修改方法
//		User user2=new User();
//		user2.setUsername("admin1");
//		user2.setPassword("888666");
//		service.updateUser(user2);
		
//		事务添加，添加多个，要么都成功，要么都失败
//		User user3=new User();
//		User user4=new User();
//		user3.setUsername("admin11");
//		user3.setPassword("111111");
//		user4.setUsername("admin7");
//		user4.setPassword("111111");
//		List<User> list1=new ArrayList<>();
//		list1.add(user3);
//		list1.add(user4);
//		service.addListUsers(list1);
//		查询方法
		List<UsersList> list=service.getUsers(null);//动态sql
		for(UsersList userlList:list) {
			for(User user:userlList.getList()) {
				System.out.println("用户名："+user.getUsername()+"，密码："+user.getPassword());
			}
		}
	}
}
