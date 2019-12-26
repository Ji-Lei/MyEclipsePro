package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import service.UserService;

@Controller
@RequestMapping("/user")
public class UsersController {
	@Autowired
	@Qualifier("userService")
	private UserService userService;
	
	@RequestMapping("/user1")
	public String user1(Model model) {
		
		return "jsp/user";
	}
}
