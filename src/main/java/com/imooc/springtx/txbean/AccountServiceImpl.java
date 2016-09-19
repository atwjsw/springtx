package com.imooc.springtx.txbean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.imooc.springtx.txbean.AccountDao;

@Service("accountService")
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountDao accountDao;

	@Override
	public void transfer(String outAccount, String inAccount, double amount) {
		
		System.out.println("txbean.transfer");
		accountDao.reduceAccount(outAccount, amount);
		int i = 1 / 0;
		accountDao.increaseAccount(inAccount, amount);

	}
}
