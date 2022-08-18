package com.myproject.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	@RequestMapping(value = "/user/edit_contact")
	public String prepareEditForm(Model m ,HttpSession session ,@RequestParam("cid") Integer contactId) {
		session.setAttribute("aContactId", contactId);
		Contact cid = ContactService.findById(contactId);
		m.addAttribute("command",cid);
		return "contact_form";
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
	public String saveOrUpdateContact(@ModelAttribute("command") Contact c, Model m, HttpSession session) {
		Integer contactId = (Integer) session.getAttribute("aContactId");
        if(contactId == null) {
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
		}else {
			//updateTask
			try {
				c.setContactId(contactId);
				ContactService.updtae(c);
				return "redirect:clist?act=ed";// jsp form view ,redirect user to contact list url
			} catch (Exception e) {
				e.printStackTrace();
				m.addAttribute("err", "failed to edit contact");
				return "contact_form";
			}
			
		}
	}
	@RequestMapping(value = "/user/clist")
	public String contactList(Model m,HttpSession session) {
		Integer userId = (Integer) session.getAttribute("userId");
		m.addAttribute("contactList",ContactService.findUserContact(userId));
		return "clist";//jsp form view
	}
	
	@RequestMapping(value = "/user/contact_search")
	public String contactSearch(Model m,HttpSession session, @RequestParam("freeText") String freeText) {
		Integer userId = (Integer) session.getAttribute("userId");
		m.addAttribute("contactList",ContactService.findUserContact(userId,freeText));
		return "clist";//jsp form view
	}
	
	
	@RequestMapping(value = "user/del_contact")
	public String deleteContact(@RequestParam("cid") Integer contactId) {
		ContactService.delete(contactId);
		return "redirect:clist?act=del";
	}
	
	@RequestMapping(value = "/user/bulk_cdelete")
	public String deleteBulkContact(@RequestParam("cid") Integer[] contactIds) {
		ContactService.delete(contactIds);
		return "redirect:clist?act=muldel";
	}
	


}
