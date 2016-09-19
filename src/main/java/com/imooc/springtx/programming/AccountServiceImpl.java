package com.imooc.springtx.programming;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

@Service("accountService")
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountDao accountDao;

	@Autowired
	private TransactionTemplate transactionTemplate;

	@Override
	public void transfer(String outAccount, String inAccount, double amount) {

		transactionTemplate.execute(new TransactionCallbackWithoutResult() {
			@Override
			protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
				accountDao.reduceAccount(outAccount, amount);
				//int i = 1/0;
				accountDao.increaseAccount(inAccount, amount);
			}
		});
	}
}
