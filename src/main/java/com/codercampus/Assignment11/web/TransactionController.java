package com.codercampus.Assignment11.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.codercampus.Assignment11.domain.Transaction;
import com.codercampus.Assignment11.service.TransactionService;

@Controller
@CrossOrigin(origins = "*")
public class TransactionController {
	
	@Autowired
	private TransactionService tServ;
	
//	@GetMapping("")
//	public String getDemoPage () {
//		return "transactions";
// 	}
	
	@GetMapping("/transactions")
	public String getTransactionPage (ModelMap mm) {
		List<Transaction> transactions = tServ.getTransactions();
		mm.put("transactions", transactions);
		return "transactions";
	}
	
	@GetMapping("/transactions/{transactionid}")
	public String getTransactionById (ModelMap mm, @PathVariable Integer transactionid) {
		Transaction transaction = tServ.getTransactionById(transactionid);
		mm.put("transaction", transaction);
		return "transaction";
	}
}
