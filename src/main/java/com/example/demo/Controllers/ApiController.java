package com.example.demo.Controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.Book;
import com.example.demo.Repository.BookRepo;
import com.example.demo.Service.ApiService;

@RestController
public class ApiController {
@Autowired
	ApiService ser;
@Autowired
	BookRepo repo;

@GetMapping("/")
	public List<Book> getAll(){
		return repo.findAll();
	}
@GetMapping("/{id}")
	public Optional<Book> getById(@PathVariable int id){
		return ser.getById(id);
	}
@PostMapping("/")
	public String post(@RequestBody Book b) {
		return ser.post(b);
	}
@PutMapping("/put")
	public String put(@RequestBody Book b) {
		repo.save(b);
		return "updated";
	}
@DeleteMapping("/{id}")
	public String delete(@PathVariable int id) {
		repo.deleteById(id);
		return "deleted";
}
}
