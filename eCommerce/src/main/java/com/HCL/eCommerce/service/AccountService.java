package com.HCL.eCommerce.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import com.HCL.eCommerce.entity.Account;
import com.HCL.eCommerce.exception.NoRecordsException;
import com.HCL.eCommerce.repository.AccountRepository;
import com.HCL.eCommerce.vo.AccountVO;
import com.google.common.collect.Lists;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AccountService {

	@Autowired
	AccountRepository accountRepository;
	
	public boolean add(AccountVO accountVO) {
		Account account = new Account();
		BeanUtils.copyProperties(accountVO, account);
		try {
			accountRepository.save(account);
		} catch (DataAccessException dae) {
			log.error("Error while saving into database :{}", dae.getMessage());
		}
		return true;
	}
	
	public boolean delete(String name, String url) {
		Optional<Account> account = accountRepository.findByNameAndUrl(name, url);
		if (!account.isPresent()) {
			throw new NoRecordsException("No Records for Account " + name);
		}
		try {
			Account acc = account.get();
			accountRepository.delete(acc);
		} catch (DataAccessException dae) {
			log.error("Error while deleting from database :{}", dae.getMessage());
		}
		return true;
	}
	
	public boolean deleteById(int id) {
		Optional<Account> account = accountRepository.findById(id);
		if (!account.isPresent()) {
			throw new NoRecordsException("No Records for Account for ID " + id);
		}
		try {
			accountRepository.deleteById(id);
		} catch (DataAccessException dae) {
			log.error("Error while saving into database :{}", dae.getMessage());
		}
		return true;
	}
	
	public boolean updateById(AccountVO accountVO, int id) {
		Account account = accountRepository.findById(id).get();
		//BeanUtils.copyProperties(accountVO, account);
		account.setUrl(accountVO.getUrl());
		account.setName(accountVO.getName());
		account.setBio(accountVO.getBio());
		try {
			accountRepository.save(account);
		} catch (DataAccessException dae) {
			log.error("Error while saving into database :{}", dae.getMessage());
		}
		return true;
	}
	
	public AccountVO get(String name, String url) {
		Optional<Account> account = accountRepository.findByNameAndUrl(name, url);
		if (!account.isPresent()) {
			throw new NoRecordsException("No Records for Account " + name);
		}
		AccountVO accountVO = new AccountVO();
		BeanUtils.copyProperties(account.get(), accountVO);
		return accountVO;
	}
	
	public List<AccountVO> getAll() {
		List<Account> accounts = Lists.newArrayList(accountRepository.findAll());
		if (accounts.isEmpty()) {
			throw new NoRecordsException("No Accounts found");
		}
		List<AccountVO> accountVOs = new ArrayList<>();
		accounts.forEach(account -> {
			AccountVO accountVO = new AccountVO();
			BeanUtils.copyProperties(account, accountVO);
			accountVOs.add(accountVO);
		});
		return accountVOs;
	}
	
	public AccountVO findById(int id) {
		Optional<Account> account = accountRepository.findById(id);
		if (!account.isPresent()) {
			throw new NoRecordsException("No Records for Account for ID " + id);
		}
		AccountVO accountVO = new AccountVO();
		BeanUtils.copyProperties(account.get(), accountVO);
		return accountVO;
	}
}
