package com.imooc.springtx.txbean;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class AccountDao extends JdbcDaoSupport {
	
	public void reduceAccount(String account, double amount) {
		
		String sql = "UPDATE account SET money=money-? WHERE name=?";
		this.getJdbcTemplate().update(sql, amount, account);		
	};
	
	public void increaseAccount(String account, double amount) {
		
		String sql = "UPDATE account SET money=money+? WHERE name=?";
		this.getJdbcTemplate().update(sql, amount, account);
		
	};

}
