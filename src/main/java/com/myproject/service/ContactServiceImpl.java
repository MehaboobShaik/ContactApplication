package com.myproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myproject.dao.BaseDao;
import com.myproject.dao.IContactDao;
import com.myproject.domain.Contact;
import com.myproject.rm.ContactRowMapper;
import com.myproject.util.StringUtility;

@Service
public class ContactServiceImpl extends BaseDao implements IContactService {

	@Autowired
	private IContactDao contactDao;

	@Override
	public void save(Contact contact) {
		contactDao.save(contact);
	}

	@Override
	public void updtae(Contact contact) {

		contactDao.Update(contact);

	}

	@Override
	public void delete(Integer contactId) {
		
		contactDao.delete(contactId);

	}

	@Override
	public void delete(Integer[] contactIds) {
		String ids = StringUtility.toCommaSeperatedString(contactIds);
		String sql = "delete from contact where contactId IN("+ids+")";
	    getJdbcTemplate().update(sql);

	}

	@Override
	public List<Contact> findUserContact(Integer userId) {
		
		List<Contact> findByProperty = contactDao.findByProperty("userid", userId);
		 
		return findByProperty;
	}

	@Override
	public List<Contact> findUserContact(Integer userId, String txt) {
		
		String selectSqlQuery = "select * from contact where userid = ? AND(name Like '%"+txt+"%' OR address Like '%"+txt+"%' OR phone Like '%"+txt+"%' OR email Like '%"+txt+"%' OR remark Like '%"+txt+"%' )";
		List<Contact> query = getJdbcTemplate().query(selectSqlQuery, new ContactRowMapper(),userId);
		return query;
		
		
	}

	@Override
	public Contact findById(Integer contactId) {
		Contact findById = contactDao.findById(contactId);
		return findById;
	}

}
