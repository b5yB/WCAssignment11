package com.codercampus.Assignment11.service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codercampus.Assignment11.domain.Transaction;
import com.codercampus.Assignment11.repository.TransactionRepository;

@Service
public class TransactionService {

	@Autowired
	private TransactionRepository tRepo;
	
	public List<Transaction> getTransactions () {
		List<Transaction> transactions = tRepo.findAll();
//				.stream()
//				.sorted(transactions, (Transaction t1, Transaction t2) -> t1.getDate().compareTo(t2.getDate()))
//				.toList();
		Collections.sort(transactions, (t1, t2) -> t1.getDate().compareTo(t2.getDate()));
		return transactions;
	}
	
	public Transaction getTransactionById (int id) {
		Optional<Transaction> ifExists = tRepo.findAll().stream()
							  				  .filter(trans -> trans.getId()==id)
											  .findFirst(); 
											  //.findAny();
		Transaction notExists = new Transaction();
		return ifExists.orElse(notExists);
//		if (ifExists != null) {
//			return ifExists;
//		}
//		else {
//			Transaction notExists = new Transaction();
//			return notExists;
//		}
	}
}