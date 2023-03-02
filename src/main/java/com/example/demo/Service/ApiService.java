package com.example.demo.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.Book;
import com.example.demo.Repository.BookRepo;

@Service
public class ApiService {

	@Autowired
		BookRepo repo;
	
	public Optional<Book> getById(int id){
		return repo.findById(id);
	}
	
	public String post(Book b) {
		repo.save(b);
		return "added";
	}
}
