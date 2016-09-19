package com.imooc.springtx.programming;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import junit.framework.TestCase;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:springtx-programming.xml")
public class ProgrammingTxTest extends TestCase {
	
	@Autowired
	private AccountService accountService;
	
	@Autowired
	private AccountDao accountDao;
	
	@Test
	public void testAccountDao() {
		accountDao.reduceAccount("bbb", 200);
		accountDao.increaseAccount("aaa", 200);
	}
	
	@Test
	public void testAccountService() {
		accountService.transfer("aaa", "bbb", 200);
	}

}
