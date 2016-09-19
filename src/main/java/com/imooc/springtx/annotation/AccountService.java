package com.imooc.springtx.annotation;

public interface AccountService {	
	
	public void transfer(String outAccount, String inAccount, double amount);

}
