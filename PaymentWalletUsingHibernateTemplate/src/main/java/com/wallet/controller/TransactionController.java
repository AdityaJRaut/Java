package com.wallet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.wallet.exception.InsufficientBalanceException;
import com.wallet.model.Transaction;
import com.wallet.service.TransactionService;

@Controller
public class TransactionController {

	@Autowired
	private TransactionService transactionService;

	@GetMapping("/")
	public String viewHomePage(Model model) {
		model.addAttribute("transactions", transactionService.getAllTransactions());
		model.addAttribute("balance", transactionService.getCurrentBalance());
		return "home"; // View the transactions
	}

	@GetMapping("/add")
	public String showForm(Model model) {
		model.addAttribute("transaction", new Transaction());
		return "add-transaction"; // Show the form to add a new transaction
	}

	@PostMapping("/save")
	public String save(Transaction transaction, Model model) {
		try {
			transactionService.saveTransaction(transaction);
			return "redirect:/"; // Success
		} catch (InsufficientBalanceException e) {
			// Send error to view
			model.addAttribute("error", e.getMessage());
			model.addAttribute("transaction", transaction); // Keep form data
			return "add-transaction"; // Stay on the form page
		}
	}
}
