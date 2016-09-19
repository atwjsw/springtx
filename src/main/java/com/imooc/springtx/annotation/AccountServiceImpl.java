package com.imooc.springtx.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("accountService")
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountDao accountDao;

	@Override
	/**
	*	propogation: 传播行为
	*	isolation：隔离级别
	*	readOnly： 只读
	*	rollbackFor： 发生哪些异常回滚
	*	noRollbackFor：发生哪些异常不回滚
	*/
	@Transactional(propagation=Propagation.REQUIRED)
	public void transfer(String outAccount, String inAccount, double amount) {
		
		System.out.println("txbean.transfer");
		accountDao.reduceAccount(outAccount, amount);
		int i = 1 / 0;
		accountDao.increaseAccount(inAccount, amount);
	}
}
