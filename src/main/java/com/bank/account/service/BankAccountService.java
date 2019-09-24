package com.bank.account.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.account.entity.BankAccount;
import com.bank.account.entity.UserRegistration;
import com.bank.account.model.BankAccountModel;
import com.bank.account.repository.BankAccountRepo;
import com.bank.account.repository.UserRegistrationRepo;

@Service
public class BankAccountService {
	
	@Autowired
	BankAccountRepo bankAccountRepo;
	
	@Autowired
	UserRegistrationRepo userRegistrationRepo;

	public String createAccount(BankAccountModel bankAccountModel) {
		
		BankAccount bankAccount = new BankAccount();
		
		UserRegistration userRegistration = userRegistrationRepo.findByLoginName(bankAccountModel.getLoginName());
		
		bankAccount.setUserRegistrationId(userRegistration);
		bankAccount.setName(bankAccountModel.getName());		
		bankAccount.setNumber(bankAccountModel.getNumber());		
		bankAccount.setCurrency(bankAccountModel.getCurrency());
		
    bankAccountRepo.save(bankAccount);
    
    String status = "Account Registration Successfull";
	
	return status;

	}
	
	public List<BankAccount> getAccountList(String userId){
		

		return bankAccountRepo.findByUserRegistrationIdLoginName(userId);
		
		
	}
}
