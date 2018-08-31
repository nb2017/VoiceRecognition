package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.Entity.User;
import com.example.demo.Service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	private static final String VIEW = "user";

	@Autowired
	public UserService service;

	@RequestMapping(method = RequestMethod.GET)
	public String index() {
		return VIEW;
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView userList(ModelAndView mov, @RequestParam("userId") String userId) {

		mov.setViewName(VIEW);
		User user = service.search(Integer.parseInt(userId));
		mov.addObject("user", user);
		return mov;
	}

}
