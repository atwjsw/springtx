package com.imooc.springtx.txbean;

public interface AccountService {	
	
	public void transfer(String outAccount, String inAccount, double amount);

}
