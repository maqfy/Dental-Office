package com.practice.dentistOffice.service;

import com.practice.dentistOffice.model.Transaction;

public interface TransactionService {

	Long numberOfTransactions();

	Object findAllTransactions();

	void saveTransaction(Transaction transaction);

}
