package com.myproject.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myproject.domain.Contact;
import com.myproject.service.IContactService;

@Controller
public class ContactController {

	@Autowired
	private IContactService ContactService;

	@RequestMapping(value = "/user/contact_form")
	public String contactFrom(Model m) {
		Contact contact = new Contact();
		m.addAttribute("command", contact);
		return "contact_form";// jsp form view
	}

	/*
	 * 
	 * After save the contact form we are here receive the data.we have access the
	 * command through the model attribute.
	 * 
	 * @ModelAttribute("command")<--Contact c
	 * 
	 * @ModelAttribute("command) Contact c this command contact object have complete
	 * data we have entered in the form
	 */
	@RequestMapping(value = "/user/save_contact")
	public String saveContact(@ModelAttribute("command") Contact c, Model m, HttpSession session) {
		try {
			Integer userId = (Integer) session.getAttribute("userId");
			c.setUserId(userId);// fk,loggedin userId
			ContactService.save(c);
			return "redirect:clist?act=sv";// jsp form view ,redirect user to contact list url
		} catch (Exception e) {
			e.printStackTrace();
			m.addAttribute("err", "failed to save contact");
			return "contact_form";
		}
	}
	@RequestMapping(value = "/user/clist")
	public String contactList(Model m,HttpSession session) {
		Integer userId = (Integer) session.getAttribute("userId");
		m.addAttribute("contactList",ContactService.findUserContact(userId));
		return "clist";//jsp form view
	}

}
