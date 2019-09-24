package com.bank.account.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bank.account.entity.BankAccount;
import com.bank.account.model.BankAccountModel;
import com.bank.account.service.BankAccountService;

@RestController
@RequestMapping(value="account")
public class BankAccountController {
	
	@Autowired
	BankAccountService bankAccountService;
	
	@RequestMapping(value="/registration1", method=RequestMethod.POST)
	public ResponseEntity<String> accountRegistration(@RequestBody BankAccountModel bankAccountModel){ 
	
		String status = bankAccountService.createAccount(bankAccountModel);
	
	return new  ResponseEntity<String>(status, HttpStatus.OK);
}
	
	@RequestMapping(value="{userId}/list", method=RequestMethod.GET)
	public ResponseEntity<List<BankAccount>> getAccountsList(@PathVariable String userId ){
		
		List<BankAccount> bankAccountList = bankAccountService.getAccountList(userId);
		
		return new ResponseEntity<List<BankAccount>> (bankAccountList, HttpStatus.OK);
	}
	
}