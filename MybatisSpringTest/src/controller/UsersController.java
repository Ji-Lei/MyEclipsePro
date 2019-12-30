package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import pojo.User;
import pojo.UsersList;
import service.UserService;

@Controller
@RequestMapping("/user")
public class UsersController {
	@Autowired
	@Qualifier("userService")
	private UserService userService;
	
	@RequestMapping("/user1")
	public ModelAndView user1(@RequestParam(required = false) String username) {
		List<UsersList> list=userService.getUsers(username);
		for(UsersList usersList:list) {
			for(User user:usersList.getList()) {
				System.out.println("用户名："+user.getUsername());
			}
		}
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.addObject("user",list.size());
		modelAndView.setViewName("jsp/user");
		return modelAndView;
	}
}
