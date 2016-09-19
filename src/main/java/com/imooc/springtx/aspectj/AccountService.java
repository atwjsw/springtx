package com.imooc.springtx.aspectj;

public interface AccountService {	
	
	public void transfer(String outAccount, String inAccount, double amount);

}
