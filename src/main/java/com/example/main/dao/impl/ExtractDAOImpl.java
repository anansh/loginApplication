package com.example.main.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.example.main.dao.ExtractDAO;


public class ExtractDAOImpl extends JdbcDaoSupport implements ExtractDAO{

	@Override
	public boolean getRoleDetailsById(String query) {
		boolean returnValue = false;
		List<Map<String, Object>> rows = getJdbcTemplate().queryForList(query);
		int temp = 0;
		for (Map<String, Object> row : rows) {
			String count = row.get("count(*)").toString();
			if(count.toString().equals("0") || count.toString() == "0") {
				
			} else {
				temp++;
			}
		}

		if(temp > 0) {
			returnValue = true;
		}
		return returnValue;
	}

}