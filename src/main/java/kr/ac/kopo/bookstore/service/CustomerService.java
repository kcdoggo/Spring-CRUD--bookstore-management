package kr.ac.kopo.bookstore.service;

import java.util.List;

import kr.ac.kopo.bookstore.model.Customer;

public interface CustomerService {

	List<Customer> list();

	void add(Customer item);

	Customer item(int custid);

	void update(Customer item);

	void delete(int custid);

}
