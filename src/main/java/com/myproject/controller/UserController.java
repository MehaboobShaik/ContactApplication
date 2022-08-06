package com.myproject.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.myproject.command.LoginCommand;
import com.myproject.command.UserCommand;
import com.myproject.domain.User;
import com.myproject.excpetion.UserBlockedException;
import com.myproject.service.IUserService;

@Controller
public class UserController {

	@Autowired
	private IUserService userService;

	@RequestMapping(value = { "/", "/index" })
	public String index(Model model) {
		model.addAttribute("command", new LoginCommand());
		return "index"; // jsp -/WEB_INF/View/index.jsp
	}

	/*
	 * if we use get method userName and password will be shown in url so use post
	 * to avoid such things . imp-->from controller calling the handleLogin method
	 * dispatcher servlet is working in front controller . who will receive my
	 * request and read the perameters(UN and Pass)then bind parmas to LoginCommand
	 * object then this object will, be given to the controller params supplied by
	 * the front controller to me to check.
	 */
	/*
	 * whatever the details we have added in the model those can be accessable by
	 * jsp. handleLogin front controller is calling this method front Controller is
	 * responsible to passing this arguments
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String handleLogin(@ModelAttribute("command") LoginCommand cmd, Model m, HttpSession session) {

		try {
			User loginUser = userService.Login(cmd.getLoginName(), cmd.getPassword());
			if (loginUser == null) {
				m.addAttribute("err", "login failed! Enter valid details");
				return "index";// jsp-login form

			} else {
				if (loginUser.getRole().equals(userService.ROLE_ADMIN)) {
					// add user details in session (assign session to logged in user)
					addUserInSession(loginUser, session);
					return "redirect:admin/dashboard";
				} else if (loginUser.getRole().equals(userService.ROLE_USER)) {
					addUserInSession(loginUser, session);
					return "redirect:user/dashboard";
				} else {
					m.addAttribute("err", "Invalid user role");
					return "index";
				}
			}
		} catch (UserBlockedException e) {
			// add error msg and go back to index form
			m.addAttribute("err", e.getMessage());
			return "index";// jsp-login form
		}

	}
	@RequestMapping(value = {"/logout" })
	public String logout(HttpSession session) {
        session.invalidate();
		return "redirect:index?act=lo"; // jsp -/WEB_INF/View/dashboard.jsp
	}

	@RequestMapping(value = { "/user/dashboard" })
	public String userDashboard() {

		return "dashboard_user"; // jsp -/WEB_INF/View/dashboard.jsp
	}

	@RequestMapping(value = { "/admin/dashboard" })
	public String adminDashboard() {

		return "dashboard_admin"; // jsp -/WEB_INF/View/dashboardi.jsp
	}
	/*
	 * to acess the f:input we need to add command other we will get exception  
	 */
	@RequestMapping(value = "/reg_form")
	public String registrationFrom(Model m) {
		UserCommand userCommand = new UserCommand();
		m.addAttribute("command",userCommand);
          //todo need command
		return "reg_form";//jsp

	}
	/*
	 * to read the form data we need to add @modelAttribute.
	 * binded the user inside model command with model command(m.addAttribute("command",userCommand); now user containing all user registration details
	 * we have to pass user object to service
	 */
	@RequestMapping(value = "/register")
	public String registerUser(@ModelAttribute("command") UserCommand cmd, Model m) {
		
		try{User user = cmd.getUser();
		user.setRole(userService.ROLE_USER);
		user.setLoginStatus(userService.LOGIN_STATUS_ACTIVE);
		userService.register(user);
		return "redirect:index?act=reg";//redirecting the action getting msg
		}catch(DuplicateKeyException e) {
			e.printStackTrace();
			m.addAttribute("err","username is already registered pls select another username");
			return "reg_form";
		}
		
	}
	
	
	

	/*
	 * This method bind the loggedIn user in HttpSession(I(addUserInSession). this
	 * can be helpful to identify who is logged in upComing pages means user or
	 * admin. HttpSession provides a way to identify a user across more than one page request or
	 * visit to a Web site and to store information about that user.
	 */
	private void addUserInSession(User u, HttpSession session) {

		session.setAttribute("user", u);
		session.setAttribute("userId", u.getUserId());
		session.setAttribute("role", u.getRole());

	}
}
